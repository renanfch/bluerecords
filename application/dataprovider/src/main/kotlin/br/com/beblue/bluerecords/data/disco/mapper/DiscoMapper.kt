package br.com.beblue.bluerecords.data.disco.mapper

import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import br.com.beblue.bluerecords.data.disco.dto.DiscoResponseDTO
import kotlin.random.Random.Default.nextDouble

fun List<DiscoResponseDTO>.toCadastrarDiscoCommand(): List<CadastrarDiscoCommand> {
    val discosCommand = mutableListOf<CadastrarDiscoCommand>()
    this.forEach {
        discosCommand.add(CadastrarDiscoCommand(it.nome, it.generoId, valor = nextDouble(1.0,100.0) ))
    }
    return discosCommand
}