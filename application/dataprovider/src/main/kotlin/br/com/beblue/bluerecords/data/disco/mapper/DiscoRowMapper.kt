package br.com.beblue.bluerecords.data.disco.mapper

import br.com.beblue.bluerecords.core.entitidade.Disco
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class DiscoRowMapper : RowMapper<Disco> {
    override fun mapRow(rs: ResultSet, rowNum: Int): Disco? {
        val disco = Disco(
            rs.getInt("id_disco"),
            rs.getInt("id_genero"),
            rs.getString("nome"),
            rs.getDouble("valor"),
            rs.getString("descricao")
        )
        return disco
    }
}