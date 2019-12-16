package br.com.beblue.bluerecords.data.disco

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import br.com.beblue.bluerecords.data.disco.mapper.DiscoRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.Statement

class DiscoRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : DiscoRepositorio
{

    private val INSERT_DISCO = " INSERT INTO disco_tbl  ( id_genero, nome, valor )" +
            " VALUES ( ?,?,? ); "

    private val SELECT_DISCO = " SELECT id_disco, id_genero, nome, valor FROM disco_tbl; "

    override fun cadastrar(command: CadastrarDiscoCommand): Disco {

        val keyHolderDisco = GeneratedKeyHolder()
        jdbcTemplate.update({ conexao ->
            val ps = conexao.prepareStatement(INSERT_DISCO, Statement.RETURN_GENERATED_KEYS )
            ps.setInt(1, command.idGenero)
            ps.setString(2, command.nome)
            ps.setDouble(3, command.valor)
            ps
        }, keyHolderDisco)

        return Disco(keyHolderDisco.key?.toInt() ?: 0, command.idGenero, command.nome, command.valor)
    }

    override fun existeDiscoCadastrado(): Boolean {
        val discoExists = jdbcTemplate.query(
            SELECT_DISCO,
            DiscoRowMapper()
        )
        return discoExists.size > 0
    }
}