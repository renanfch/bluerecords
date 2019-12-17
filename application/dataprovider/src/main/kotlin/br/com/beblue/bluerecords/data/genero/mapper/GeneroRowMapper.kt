package br.com.beblue.bluerecords.data.genero.mapper

import br.com.beblue.bluerecords.core.entitidade.Genero
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class GeneroRowMapper : RowMapper<Genero> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Genero? {
        return Genero(
            rs.getInt("id_genero"),
            rs.getString("descricao")
        )
    }
}