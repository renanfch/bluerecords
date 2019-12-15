package br.com.beblue.bluerecords.data.venda.mapper

import br.com.beblue.bluerecords.core.entity.Venda
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class VendaRowMapper : RowMapper<Venda> {

    override fun mapRow(rs: ResultSet, p1: Int): Venda? {
        return Venda(
            rs.getInt("id")
        )
    }

}