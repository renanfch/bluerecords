package br.com.beblue.bluerecords.entrypoint.disco.mapper;

import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.command.PaginacaoCommand;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoRequestDTO;

public class DiscoRequestMapper {

    private DiscoRequestMapper(){}

    public static ConsultaDiscoCommand toCommand(DiscoRequestDTO discoRequestDTO) {
        PaginacaoCommand paginacaoCommand = new PaginacaoCommand(discoRequestDTO.getPagina(), discoRequestDTO.getTamanho());
        return new ConsultaDiscoCommand(paginacaoCommand, discoRequestDTO.getGeneroId());
    }

}
