package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase
import br.com.beblue.bluerecords.core.usecase.DiscoUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class DiscoUseCaseConfiguration {

    @Bean
    open fun carregaDiscoUseCase(discoRepositorio: DiscoRepositorio, discoSpotifyClient : DiscoSpotifyClient) : DiscoUseCase
    {
        return DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient)
    }

}