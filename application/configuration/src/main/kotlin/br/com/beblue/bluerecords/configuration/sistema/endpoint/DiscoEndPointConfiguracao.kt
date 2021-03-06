package br.com.beblue.bluerecords.configuration.sistema.endpoint

import br.com.beblue.bluerecords.core.usecase.DiscoUseCase
import br.com.beblue.bluerecords.entrypoint.disco.DiscoRestController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class DiscoEndPointConfiguracao {

    @Bean
    open fun carregaDiscoEndPoint(discoUseCase: DiscoUseCase): DiscoRestController {
        return DiscoRestController(discoUseCase)
    }

}