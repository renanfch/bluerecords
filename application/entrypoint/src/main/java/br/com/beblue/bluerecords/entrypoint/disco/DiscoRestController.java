package br.com.beblue.bluerecords.entrypoint.disco;

import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoRequestDTO;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;

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
        return null;
    }

    @GetMapping("/discos")
    public Page<DiscoResponseDTO> consultarDiscos(DiscoRequestDTO discoRequestDTO)
    {
        return null;
    }


}
