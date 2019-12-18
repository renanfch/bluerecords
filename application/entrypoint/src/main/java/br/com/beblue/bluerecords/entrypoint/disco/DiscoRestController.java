package br.com.beblue.bluerecords.entrypoint.disco;

import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoRequestDTO;
import br.com.beblue.bluerecords.entrypoint.disco.dto.DiscoResponseDTO;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoRequestMapper;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoResponseMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(
        value = "REST API para pesquisar os discos",
        tags = {"ConsultaDiscos"}
)
public class DiscoRestController {
    public DiscoRestController(DiscoUseCase discoUseCase) {
        this.discoUseCase = discoUseCase;
    }

    private DiscoUseCase discoUseCase;

    @GetMapping("discos/{id}")
    public DiscoResponseDTO consultarDisco(Integer id)
    {
        DiscoResponseMapper discoResponseMapper = new DiscoResponseMapper();
        Disco disco = discoUseCase.consultar(id);
        DiscoResponseDTO discoDTO = discoResponseMapper.toResponse(disco);
        return discoDTO;
    }

    @GetMapping("/discos")
    public PaginacaoDTO<DiscoResponseDTO> consultarDiscos(DiscoRequestDTO discoRequestDTO)
    {
        DiscoRequestMapper discoRequestMapper = new DiscoRequestMapper();
        DiscoResponseMapper discoResponseMapper = new DiscoResponseMapper();
        ConsultaDiscoCommand consultaDiscoCommand = discoRequestMapper.toCommand(discoRequestDTO);
        Paginacao<Disco> discos = discoUseCase.consultarDiscos(consultaDiscoCommand);
        return discoResponseMapper.toResponse(discos);
    }


}
