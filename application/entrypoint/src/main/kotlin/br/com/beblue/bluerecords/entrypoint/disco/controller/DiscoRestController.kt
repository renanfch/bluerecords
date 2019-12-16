package br.com.beblue.bluerecords.entrypoint.disco.controller

import br.com.beblue.bluerecords.core.usecase.disco.DiscoUseCase
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoRequestDTO
import br.com.beblue.bluerecords.entrypoint.disco.mapper.DiscoResponseDTO
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(
    description = "REST API para pesquisar os discos",
    tags = ["ConsultaDiscos"]
)
class DiscoRestController(private val discoUseCase: DiscoUseCase) {

    @GetMapping("/disco")
    fun get(request: DiscoRequestDTO): DiscoResponseDTO? {
        return null
    }

}

