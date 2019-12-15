package br.com.beblue.bluerecords.data.disco

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.repository.DiscoRepositorio
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import org.springframework.jdbc.core.JdbcTemplate

class DiscoRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : DiscoRepositorio
{
    override fun cadastrar(command: CadastrarDiscoCommand): Disco {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}