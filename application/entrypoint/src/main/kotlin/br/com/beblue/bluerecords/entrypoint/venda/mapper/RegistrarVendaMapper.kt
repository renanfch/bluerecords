package br.com.beblue.bluerecords.entrypoint.venda.mapper

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand
import br.com.beblue.bluerecords.core.entitidade.Venda
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO

fun RegistrarVendaRequestDTO.toCommand(): RegistraVendaCommand {
    return RegistraVendaCommand(this.id)
}

fun Venda.toResponseDTO(): RegistrarVendaResponseDTO {
    return RegistrarVendaResponseDTO(
        this.id
    )
}