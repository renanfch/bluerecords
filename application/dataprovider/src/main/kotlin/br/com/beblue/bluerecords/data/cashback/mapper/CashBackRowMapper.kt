package br.com.beblue.bluerecords.data.cashback.mapper

import br.com.beblue.bluerecords.core.entitidade.CashBack
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class CashBackRowMapper : RowMapper<CashBack> {
    override fun mapRow(rs: ResultSet, rowNum: Int): CashBack {
        return CashBack(
            rs.getInt("id_cashback"),
            rs.getInt("id_genero"),
            rs.getInt("dia_semana"),
            rs.getDouble("porcentagem_cash_back")
        )
    }
}