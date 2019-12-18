package br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.mapper;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.PaginacaoCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.VendaItem;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaItemResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultaVendaMapper {
    public ConsultaVendaCommand toCommand(ConsultarVendaDTO consultarVendaDTO) {
        PaginacaoCommand paginacaoCommand = new PaginacaoCommand(consultarVendaDTO.getPagina(), consultarVendaDTO.getTamanho());
        LocalDate dataInicial = DataUtil.converteParaLocalDate(consultarVendaDTO.getDataInicial());
        LocalDate dataFinal = DataUtil.converteParaLocalDate(consultarVendaDTO.getDataFinal());
        return new ConsultaVendaCommand(dataInicial, dataFinal, paginacaoCommand);
    }

    public ResponseEntity<PaginacaoDTO<ConsultarVendaResponseDTO>> toDTO(Paginacao<Venda> vendas) {
        List<ConsultarVendaResponseDTO> vendasResponse = new java.util.ArrayList<>(Collections.emptyList());
        vendas.getObjetos().forEach(it -> vendasResponse.add(new ConsultarVendaResponseDTO(it.getId(), it.getIdCliente(),
                it.getDataVenda(), converteItemToResponse(it.getVendaItens())
        )));
        return ResponseEntity.ok(new PaginacaoDTO<>(vendas.getTamanho(), vendas.getTotal(), vendas.getPagina(), vendasResponse));
    }

    public ResponseEntity<ConsultarVendaResponseDTO> vendaToResponseDTO(Venda venda) {
        if (venda == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ConsultarVendaResponseDTO("Não encontrou nenhuma venda com esse ID."));

        List<ConsultarVendaItemResponseDTO> itensResponse = converteItemToResponse(venda.getVendaItens());
        ConsultarVendaResponseDTO consultarVendaResponseDTO = new ConsultarVendaResponseDTO(
                venda.getId(), venda.getIdCliente(), venda.getDataVenda(), itensResponse);

        return ResponseEntity.ok(consultarVendaResponseDTO);
    }

    private List<ConsultarVendaItemResponseDTO> converteItemToResponse(List<VendaItem> vendaItems) {
        List<ConsultarVendaItemResponseDTO> consultarVendaItemResponseDTO = new ArrayList<>();
        vendaItems.forEach(it -> {
            if (it != null) {
                consultarVendaItemResponseDTO.add(new ConsultarVendaItemResponseDTO(it.getId(), it.getIdVenda(), it.getIdDisco(),
                        it.getValor(), it.getCashBack()));
            }
        });

        return consultarVendaItemResponseDTO;
    }
}
