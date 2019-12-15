package br.com.beblue.bluerecords.configuration.venda.endpoint

import br.com.beblue.bluerecords.core.usecase.venda.VendaUseCase
import br.com.beblue.bluerecords.entrypoint.venda.controller.impl.VendaRestController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class VendaEndpointConfiguration {

    @Bean
    open fun loadVendaEndpoint(useCase: VendaUseCase): VendaRestController {
        return VendaRestController(useCase)
    }

}