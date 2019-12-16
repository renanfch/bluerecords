package br.com.beblue.bluerecords.core.usecase.disco

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.entity.Genero
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand

interface DiscoUseCase
{
    fun consultarDiscoPorId(id: Int): Disco
    fun discosForamCadastrados() : Boolean
    fun consultarDiscosParaCadastroPorGenero(genero: Genero): List<CadastrarDiscoCommand>
    fun cadastrarDisco(command: CadastrarDiscoCommand) : Disco
}