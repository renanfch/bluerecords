package br.com.beblue.bluerecords.data.disco.mapper

import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import br.com.beblue.bluerecords.data.disco.dto.DiscoResponseDTO
import java.time.LocalDate
import java.time.format.DateTimeFormatter


fun List<DiscoResponseDTO>.toCadastrarDiscoCommand(): List<CadastrarDiscoCommand> {
    val discosCommand = mutableListOf<CadastrarDiscoCommand>()
    this.forEach {
        discosCommand.add(CadastrarDiscoCommand(it.nome, it.generoId))
    }
    return discosCommand
}