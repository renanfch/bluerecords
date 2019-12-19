package br.com.beblue.bluerecords.entrypoint.disco;

import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoRequestDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoResponseDTO;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoRequestMapper;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoResponseMapper;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(
        value = "REST API para pesquisar os discos",
        tags = {"API de consulta e venda de discos."}
)
public class DiscoRestController {
    public DiscoRestController(DiscoUseCase discoUseCase) {
        this.discoUseCase = discoUseCase;
    }

    private DiscoUseCase discoUseCase;

    @GetMapping("disco/{id}")
    public ResponseEntity<DiscoResponseDTO> consultarDisco(@PathVariable Integer id) {
        Disco disco = discoUseCase.consultar(id);
        return DiscoResponseMapper.toResponse(disco);
    }

    @GetMapping("/disco")
    public ResponseEntity<PaginacaoDTO<DiscoResponseDTO>> consultarDiscos(DiscoRequestDTO discoRequestDTO) {
        ConsultaDiscoCommand consultaDiscoCommand = DiscoRequestMapper.toCommand(discoRequestDTO);
        Paginacao<Disco> discos = discoUseCase.consultarDiscos(consultaDiscoCommand);
        return DiscoResponseMapper.toResponse(discos);
    }


}
