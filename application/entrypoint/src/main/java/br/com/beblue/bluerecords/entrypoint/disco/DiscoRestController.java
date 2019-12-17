package br.com.beblue.bluerecords.entrypoint.disco;

import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoRequestDTO;
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoResponseDTO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(
        description = "REST API para pesquisar os discos",
        tags = {"ConsultaDiscos"}
)
public class DiscoRestController {
    public DiscoRestController(DiscoUseCase discoUseCase) {
        this.discoUseCase = discoUseCase;
    }

    private DiscoUseCase discoUseCase;

    @GetMapping("/disco")
    DiscoResponseDTO get(DiscoRequestDTO request)
    {
        return null;
    }
}
