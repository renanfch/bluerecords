package br.com.beblue.bluerecords.data.venda.mapper

import br.com.beblue.bluerecords.core.entitidade.VendaItem
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class VendaItemRowMapper : RowMapper<VendaItem> {

    override fun mapRow(rs: ResultSet, p1: Int): VendaItem? {
        return VendaItem(
            rs.getInt("id_venda_itens"),
            rs.getInt("id_venda"),
            rs.getInt("id_discos"),
            rs.getDouble("valor"),
            rs.getInt("cash_back")
        )
    }

}