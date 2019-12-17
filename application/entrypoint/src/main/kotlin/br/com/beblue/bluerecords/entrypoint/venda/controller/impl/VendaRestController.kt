package br.com.beblue.bluerecords.entrypoint.venda.controller.impl

import br.com.beblue.bluerecords.core.usecase.VendaUseCase
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO
import br.com.beblue.bluerecords.entrypoint.venda.dto.VendaResponseDTO
import br.com.beblue.bluerecords.entrypoint.venda.mapper.toCommand
import br.com.beblue.bluerecords.entrypoint.venda.mapper.toResponseDTO
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(VendaRestController.ACTIVE_PATH)
@Api(
    description = "REST API para pesquisar e realizar vendas",
    tags = ["ConsultaVendas"]
)
class VendaRestController(private val vendaUseCase: VendaUseCase)  {

    companion object {
        internal const val ACTIVE_PATH = "/venda"
    }

    @PostMapping
    fun registrarVenda(request: RegistrarVendaRequestDTO): RegistrarVendaResponseDTO {
        val response = verifyAndExecute(request)
        return response
    }

    private fun verifyAndExecute(request: RegistrarVendaRequestDTO): RegistrarVendaResponseDTO {
        return vendaUseCase.registrarVenda(request.toCommand()).toResponseDTO()
    }

    @GetMapping
    fun buscarVenda() : VendaResponseDTO?
    {
        return null
    }
}

