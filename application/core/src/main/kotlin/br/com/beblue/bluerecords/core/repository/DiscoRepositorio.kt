package br.com.beblue.bluerecords.core.repository

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand

interface DiscoRepositorio {
    fun cadastrar(command: CadastrarDiscoCommand): Disco
}