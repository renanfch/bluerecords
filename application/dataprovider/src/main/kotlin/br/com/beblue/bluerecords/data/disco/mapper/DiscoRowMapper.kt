package br.com.beblue.bluerecords.data.disco.mapper

import br.com.beblue.bluerecords.core.entity.Disco
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class DiscoRowMapper : RowMapper<Disco> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Disco? {
        return Disco( id = rs.getInt("id_disco"),
            idGenero = rs.getInt("id_genero"),
            nome = rs.getString("nome"))
    }
}