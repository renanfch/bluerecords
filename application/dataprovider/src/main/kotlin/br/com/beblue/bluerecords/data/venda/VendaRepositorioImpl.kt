package br.com.beblue.bluerecords.data.venda

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand
import br.com.beblue.bluerecords.core.entitidade.Disco
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio
import org.springframework.jdbc.core.JdbcTemplate

open class VendaRepositorioImpl(private val jdbcTemplate: JdbcTemplate) : VendaRepositorio {

    override fun cadastrar(command: CadastraDiscoCommand): Disco {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

