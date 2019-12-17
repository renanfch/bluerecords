package br.com.beblue.bluerecords.entrypoint.venda.mapper;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO;

public class RegistrarVendaMapper {

    public RegistraVendaCommand toCommand(RegistrarVendaRequestDTO registrarVendaRequestDTO)
    {
        return new RegistraVendaCommand(registrarVendaRequestDTO.getId());
    }

    public RegistrarVendaResponseDTO toResponseDTO(Venda venda)
    {
        return new RegistrarVendaResponseDTO(
                venda.getId()
        );
    }
}
