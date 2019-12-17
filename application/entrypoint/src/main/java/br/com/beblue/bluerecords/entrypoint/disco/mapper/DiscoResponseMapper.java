package br.com.beblue.bluerecords.entrypoint.disco.mapper;

import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoResponseDTO;

import java.util.Collections;
import java.util.List;

public class DiscoResponseMapper {

    public PaginacaoDTO<DiscoResponseDTO> toResponse(Paginacao<Disco> discos) {
        List<DiscoResponseDTO> discosResponse = new java.util.ArrayList<>(Collections.emptyList());
        discos.getObjetos().forEach(it -> discosResponse.add(new DiscoResponseDTO(it.getNome(), it.getValor())));
        return new PaginacaoDTO<>(discos.getTamanho(), discos.getTotal(), discos.getPagina(), discosResponse);
    }
}
