package br.com.beblue.bluerecords.data.disco.mapper

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand
import br.com.beblue.bluerecords.data.disco.dto.DiscoResponseDTO
import kotlin.random.Random.Default.nextDouble

fun List<DiscoResponseDTO>.toCadastrarDiscoCommand(): List<CadastraDiscoCommand> {
    val discosCommand = mutableListOf<CadastraDiscoCommand>()
    this.forEach {
        discosCommand.add(CadastraDiscoCommand(it.nome, it.generoId, nextDouble(1.0, 100.0)))
    }
    return discosCommand
}