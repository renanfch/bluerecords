package br.com.beblue.bluerecords.entrypoint.venda.controller.impl

import br.com.beblue.bluerecords.core.usecase.venda.VendaUseCase
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO
import br.com.beblue.bluerecords.entrypoint.venda.mapper.toCommand
import br.com.beblue.bluerecords.entrypoint.venda.mapper.toResponseDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(VendaRestController.ACTIVE_PATH)
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
}

