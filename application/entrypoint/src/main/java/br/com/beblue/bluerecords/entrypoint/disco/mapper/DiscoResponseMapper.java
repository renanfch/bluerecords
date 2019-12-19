package br.com.beblue.bluerecords.entrypoint.disco.mapper;

import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class DiscoResponseMapper {

    private DiscoResponseMapper() {
    }

    public static ResponseEntity<PaginacaoDTO<DiscoResponseDTO>> toResponse(Paginacao<Disco> discos) {
        List<DiscoResponseDTO> discosResponse = new java.util.ArrayList<>(Collections.emptyList());
        discos.getObjetos().forEach(it -> discosResponse.add(new DiscoResponseDTO(it.getNome(), it.getValor(), it.getGenero())));
        return ResponseEntity.ok(new PaginacaoDTO<>(discos.getTamanho(), discos.getTotal(), discos.getPagina(), discosResponse));
    }

    public static ResponseEntity<DiscoResponseDTO> toResponse(Disco disco) {
        if (disco == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DiscoResponseDTO("Disco não encontrado"));
        }
        return ResponseEntity.ok(new DiscoResponseDTO(disco.getNome(), disco.getValor(), disco.getGenero()));
    }
}
