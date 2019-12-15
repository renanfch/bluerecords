package br.com.beblue.bluerecords.data.venda

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.repository.VendaRepositorio
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import org.springframework.jdbc.core.JdbcTemplate

open class VendaRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : VendaRepositorio {

    override fun cadastrar(command: CadastrarDiscoCommand): Disco {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

