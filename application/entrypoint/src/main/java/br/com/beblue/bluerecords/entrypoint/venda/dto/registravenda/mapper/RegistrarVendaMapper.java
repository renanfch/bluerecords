package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.mapper;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistrarVendaItensCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.RegistrarVendaResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrarVendaMapper {

    public RegistraVendaCommand toCommand(RegistrarVendaRequestDTO registrarVendaRequestDTO) {
        List<RegistrarVendaItensCommand> itens = new ArrayList<>();

        registrarVendaRequestDTO.getRegistrarVendaItemRequestDTO().forEach(it ->
                itens.add(new RegistrarVendaItensCommand(it.getIdDisco(), it.getQuantidade())));

        LocalDate data = DataUtil.converteParaLocalDate(registrarVendaRequestDTO.getDate());

        return new RegistraVendaCommand(
                data,
                registrarVendaRequestDTO.getIdCliente(),
                itens);
    }

    public RegistrarVendaResponseDTO toResponseDTO(Venda venda) {
        return new RegistrarVendaResponseDTO(
                venda.getId(),
                "Sucesso"
        );
    }
}