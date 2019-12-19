package br.com.beblue.bluerecords.data.disco

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand
import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand
import br.com.beblue.bluerecords.core.entitidade.Disco
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio
import br.com.beblue.bluerecords.data.disco.mapper.DiscoRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.ResultSet
import java.sql.Statement

class DiscoRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : DiscoRepositorio {

    private val INSERT_DISCO = " INSERT INTO disco_tbl  ( id_genero, nome, valor )" +
            " VALUES ( ?,?,? ); "

    private val SELECT_DISCO = " SELECT id_disco, id_genero, nome, valor, '' as descricao FROM disco_tbl; "
    private val SELECT_DISCO_POR_ID = " SELECT disco_tbl.id_disco, disco_tbl.id_genero, disco_tbl.nome, " +
            " disco_tbl.valor, genero_tbl.descricao FROM disco_tbl " +
            " INNER JOIN genero_tbl ON genero_tbl.id_genero = disco_tbl.id_genero WHERE disco_tbl.id_genero = ?; "
    private val SELECT_DISCO_POR_GENERO =
        " SELECT disco_tbl.id_disco, disco_tbl.id_genero, nome, valor, genero_tbl.descricao FROM disco_tbl  " +
                " INNER JOIN genero_tbl ON genero_tbl.id_genero = disco_tbl.id_genero " +
                " WHERE disco_tbl.id_genero = ? ORDER BY nome ASC LIMIT ? OFFSET ?; "
    private val SELECT_TOTAL_DISCO = " SELECT count(1) as row_count FROM disco_tbl where id_genero = ?; "

    override fun cadastrar(command: CadastraDiscoCommand): Disco {

        val keyHolderDisco = GeneratedKeyHolder()
        jdbcTemplate.update({ conexao ->
            val ps = conexao.prepareStatement(INSERT_DISCO, Statement.RETURN_GENERATED_KEYS)
            ps.setInt(1, command.idGenero)
            ps.setString(2, command.nome)
            ps.setDouble(3, command.valor)
            ps
        }, keyHolderDisco)

        return Disco(keyHolderDisco.key?.toInt() ?: 0, command.idGenero, command.nome, command.valor)
    }

    override fun consultarDiscos(command: ConsultaDiscoCommand): Paginacao<Disco> {
        val discos = jdbcTemplate.query(
            SELECT_DISCO_POR_GENERO,
            arrayOf(command.genero, command.paginacaoCommand.tamanho, command.paginacaoCommand.offset),
            DiscoRowMapper()
        )

        val total = consultaTotalDiscos(command)
        val paginacao =
            Paginacao<Disco>(command.paginacaoCommand.tamanho, total, command.paginacaoCommand.pagina, discos)
        return paginacao
    }

    private fun consultaTotalDiscos(command: ConsultaDiscoCommand): Int {
        val total = jdbcTemplate.queryForObject(
            SELECT_TOTAL_DISCO,
            arrayOf(command.genero)
        )
        { rs: ResultSet,
          _: Int ->
            rs.getInt(1)
        }
        return total ?: 0
    }

    override fun existeDiscoCadastrado(): Boolean {
        val discoExists = jdbcTemplate.query(
            SELECT_DISCO,
            DiscoRowMapper()
        )
        return discoExists.size > 0
    }

    override fun consultar(id: Int?): Disco? {
        val disco = jdbcTemplate.query(
            SELECT_DISCO_POR_ID,
            arrayOf(id),
            DiscoRowMapper()
        )
        return if (disco.size > 0)
            disco[0]
        else
            null
    }
}