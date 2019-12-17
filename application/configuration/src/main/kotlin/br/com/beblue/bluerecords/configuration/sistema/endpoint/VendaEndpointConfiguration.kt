package br.com.beblue.bluerecords.configuration.sistema.endpoint

import br.com.beblue.bluerecords.core.usecase.VendaUseCase
import br.com.beblue.bluerecords.entrypoint.venda.VendaRestController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class VendaEndpointConfiguration {

    @Bean
    open fun loadVendaEndpoint(useCase: VendaUseCase): VendaRestController {
        return VendaRestController(useCase)
    }

}