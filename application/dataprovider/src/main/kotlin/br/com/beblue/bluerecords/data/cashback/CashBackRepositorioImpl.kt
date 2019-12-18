package br.com.beblue.bluerecords.data.cashback

import br.com.beblue.bluerecords.core.entitidade.CashBack
import br.com.beblue.bluerecords.core.entitidade.Genero
import br.com.beblue.bluerecords.core.repositorio.CashBackRepositorio
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio
import br.com.beblue.bluerecords.data.cashback.mapper.CashBackRowMapper
import br.com.beblue.bluerecords.data.genero.mapper.GeneroRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class CashBackRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : CashBackRepositorio {

    private val SELECT_CASHBACK = " SELECT id_cashback,id_genero,dia_semana,porcentagem_cash_back " +
            " FROM cashback_tbl" +
            " where id_genero = ? and dia_semana = ?; "

    override fun buscarCashBack(idGenero: Int, diaSemana: Int): CashBack {
        val cashback = jdbcTemplate.query(
            SELECT_CASHBACK,
            arrayOf(idGenero, diaSemana),
            CashBackRowMapper()
        )
        return cashback[0]
    }
}