package br.com.beblue.bluerecords.configuration.sistema.endpoint

import br.com.beblue.bluerecords.core.usecase.VendaUseCase
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCash
import br.com.beblue.bluerecords.entrypoint.venda.VendaRestController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class VendaEndpointConfiguration {

    @Bean
    open fun loadVendaEndpoint(useCase: VendaUseCase, useCaseCashBack: VendaComCashBackUseCash): VendaRestController {
        return VendaRestController(useCase, useCaseCashBack)
    }

}