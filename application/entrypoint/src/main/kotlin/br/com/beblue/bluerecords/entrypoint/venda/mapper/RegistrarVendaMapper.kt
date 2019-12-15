package br.com.beblue.bluerecords.entrypoint.venda.mapper

import br.com.beblue.bluerecords.core.entity.Venda
import br.com.beblue.bluerecords.core.usecase.venda.command.RegistrarVendaCommand
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO

fun RegistrarVendaRequestDTO.toCommand(): RegistrarVendaCommand {
    return RegistrarVendaCommand(this.id)
}

fun Venda.toResponseDTO(): RegistrarVendaResponseDTO {
    return RegistrarVendaResponseDTO(
        this.id
    )
}