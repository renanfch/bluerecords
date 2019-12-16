package br.com.beblue.bluerecords.data.genero.mapper

import br.com.beblue.bluerecords.core.entity.Genero
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class GeneroRowMapper : RowMapper<Genero> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Genero? {
        return Genero(
            id = rs.getInt("id_genero"),
            descricao = rs.getString("descricao")
        )
    }
}