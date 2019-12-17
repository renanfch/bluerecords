package br.com.beblue.bluerecords.data.genero

import br.com.beblue.bluerecords.core.entitidade.Genero
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio
import br.com.beblue.bluerecords.data.genero.mapper.GeneroRowMapper
import org.springframework.jdbc.core.JdbcTemplate

class GeneroRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : GeneroRepositorio
{
    private val SELECT_GENERO = " SELECT * FROM genero_tbl; "

    override fun buscarGenero(): List<Genero>
    {
        val generos = jdbcTemplate.query(SELECT_GENERO, GeneroRowMapper())
        return generos
    }
}