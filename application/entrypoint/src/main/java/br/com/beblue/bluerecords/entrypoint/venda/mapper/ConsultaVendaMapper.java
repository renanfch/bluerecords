package br.com.beblue.bluerecords.entrypoint.venda.mapper;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.PaginacaoCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.VendaItem;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.ConsultarVendaDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.ConsultarVendaItemResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.ConsultarVendaResponseDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultaVendaMapper {
    public ConsultaVendaCommand toCommand(ConsultarVendaDTO consultarVendaDTO) {
        PaginacaoCommand paginacaoCommand = new PaginacaoCommand(consultarVendaDTO.getPagina(), consultarVendaDTO.getTamanho());
        return new ConsultaVendaCommand(consultarVendaDTO.getDataInicial(), consultarVendaDTO.getDataFinal(), paginacaoCommand);
    }

    public PaginacaoDTO<ConsultarVendaResponseDTO> toDTO(Paginacao<Venda> vendas) {

        List<ConsultarVendaResponseDTO> vendasResponse = new java.util.ArrayList<>(Collections.emptyList());
        vendas.getObjetos().forEach(it -> vendasResponse.add(new ConsultarVendaResponseDTO(it.getId(), it.getIdCliente(),
                it.getDataVenda(), converteItemToResponse(it.getVendaItens())
        )));
        return new PaginacaoDTO<>(vendas.getTamanho(), vendas.getTotal(), vendas.getPagina(), vendasResponse);
    }

    public ConsultarVendaResponseDTO vendaToResponseDTO(Venda venda) {
        List<ConsultarVendaItemResponseDTO> itensResponse = converteItemToResponse(venda.getVendaItens());
        ConsultarVendaResponseDTO consultarVendaResponseDTO = new ConsultarVendaResponseDTO(
                venda.getId(), venda.getIdCliente(), venda.getDataVenda(), itensResponse);
        return consultarVendaResponseDTO;
    }

    private List<ConsultarVendaItemResponseDTO> converteItemToResponse(List<VendaItem> vendaItems) {
        List<ConsultarVendaItemResponseDTO> consultarVendaItemResponseDTO = new ArrayList<>();
        vendaItems.forEach(it -> consultarVendaItemResponseDTO.add(new ConsultarVendaItemResponseDTO(it.getId(), it.getIdVenda(), it.getIdDisco(),
                it.getValor(), it.getCashBack())));

        return consultarVendaItemResponseDTO;
    }
}
