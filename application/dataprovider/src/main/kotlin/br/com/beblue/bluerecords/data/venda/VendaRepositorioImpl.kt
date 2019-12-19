package br.com.beblue.bluerecords.data.venda

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand
import br.com.beblue.bluerecords.core.command.RegistrarVendaItensCommand
import br.com.beblue.bluerecords.core.entitidade.Venda
import br.com.beblue.bluerecords.core.entitidade.VendaItem
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio
import br.com.beblue.bluerecords.data.venda.mapper.VendaItemRowMapper
import br.com.beblue.bluerecords.data.venda.mapper.VendaRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.Date
import java.sql.ResultSet
import java.sql.Statement

open class VendaRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : VendaRepositorio {

    private val INSERT_VENDA = " INSERT INTO venda_tbl  ( id_cliente, data_venda )" +
            " VALUES ( ?,? ); "

    private val INSERT_VENDA_ITENS =
        " INSERT INTO venda_itens_tbl  ( id_venda, id_discos,valor, quantidade,cash_back )" +
                " VALUES ( ?,?,?,?,? ); "

    private val SELECT_VENDA = " SELECT venda_tbl.id_venda, venda_tbl.id_cliente, venda_tbl.data_venda  " +
            " FROM venda_tbl " +
            " WHERE venda_tbl.id_venda = ?; "

    private val SELECT_VENDAS_POR_DATA = " SELECT venda_tbl.id_venda, venda_tbl.id_cliente, venda_tbl.data_venda " +
            " FROM venda_tbl " +
            " WHERE venda_tbl.data_venda BETWEEN ? AND ? ORDER BY venda_tbl.data_venda " +
            " LIMIT ? OFFSET ?; "

    private val SELECT_VENDA_ITEM = " SELECT id_venda_itens,id_venda, id_discos, valor, quantidade, cash_back " +
            " FROM venda_itens_tbl " +
            " WHERE venda_itens_tbl.id_venda = ?; "

    private val SELECT_TOTAL_VENDAS_POR_DATA = " SELECT count(1) as row_count FROM venda_tbl where " +
            "  venda_tbl.data_venda BETWEEN ? AND ? "

    override fun cadastrar(command: RegistraVendaCommand): Venda {
        val keyHolderVenda = GeneratedKeyHolder()
        jdbcTemplate.update({ conexao ->
            val ps = conexao.prepareStatement(INSERT_VENDA, Statement.RETURN_GENERATED_KEYS)
            ps.setInt(1, command.idCliente)
            ps.setDate(2, Date.valueOf(command.date))
            ps
        }, keyHolderVenda)
        val idVenda = keyHolderVenda.key?.toInt() ?: 0
        val venda = Venda(idVenda, command.idCliente, command.date)

        command.registrarVendaItensCommand.forEach {
            var vendaItem = cadastrarItens(idVenda, it)
            venda.adicionarItemVendido(vendaItem)
        }

        return venda
    }

    private fun cadastrarItens(idVenda: Int, command: RegistrarVendaItensCommand): VendaItem {
        val keyHolderVendaItem = GeneratedKeyHolder()
        jdbcTemplate.update({ conexao ->
            val ps = conexao.prepareStatement(INSERT_VENDA_ITENS, Statement.RETURN_GENERATED_KEYS)
            ps.setInt(1, idVenda)
            ps.setInt(2, command.idDisco)
            ps.setDouble(3, command.valor)
            ps.setInt(4, command.quantidade)
            ps.setDouble(5, command.cashBack)
            ps
        }, keyHolderVendaItem)
        val idVendaItens = keyHolderVendaItem.key?.toInt() ?: 0
        return VendaItem(idVendaItens, idVenda, command.idDisco, command.valor, command.quantidade, command.cashBack)
    }

    override fun consultaVendas(command: ConsultaVendaCommand): Paginacao<Venda> {
        val vendas = jdbcTemplate.query(
            SELECT_VENDAS_POR_DATA,
            arrayOf(
                command.dataInicial,
                command.dataFinal,
                command.paginacaoCommand.tamanho,
                command.paginacaoCommand.offset
            ),
            VendaRowMapper()
        )

        vendas.forEach {
            val vendaItem = consultaVendaItem(it.id)
            it.adicionarItensVendido(vendaItem)
        }

        val total = consultaTotalVendas(command)
        val paginacao =
            Paginacao<Venda>(command.paginacaoCommand.tamanho, total, command.paginacaoCommand.pagina, vendas)
        return paginacao
    }

    private fun consultaTotalVendas(command: ConsultaVendaCommand): Int {
        val total = jdbcTemplate.queryForObject(
            SELECT_TOTAL_VENDAS_POR_DATA,
            arrayOf(command.dataInicial, command.dataFinal)
        )
        { rs: ResultSet,
          _: Int ->
            rs.getInt(1)
        }
        return total ?: 0
    }

    override fun consulta(id: Int?): Venda? {
        val vendas = jdbcTemplate.query(
            SELECT_VENDA,
            arrayOf(id),
            VendaRowMapper()
        )
        if (vendas.size <= 0)
            return null

        val venda = vendas[0]
        val vendaItem = consultaVendaItem(venda.id)
        venda.adicionarItensVendido(vendaItem)
        return venda
    }

    private fun consultaVendaItem(idVenda: Int): List<VendaItem>? {
        val vendaItem = jdbcTemplate.query(
            SELECT_VENDA_ITEM,
            arrayOf(idVenda),
            VendaItemRowMapper()
        )
        return vendaItem
    }

}



