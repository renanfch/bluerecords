package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.usecase.facade.PopulaBancoUseCaseImpl
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase
import br.com.beblue.bluerecords.core.usecase.GeneroUseCase
import br.com.beblue.bluerecords.core.usecase.facade.PopulaBancoUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PopulaBancoUseCaseConfiugration {

    @Bean
    open fun carregaPopulaBancoUseCase(discoUseCase: DiscoUseCase, generoUseCase: GeneroUseCase): PopulaBancoUseCase {
        return PopulaBancoUseCaseImpl(
            discoUseCase,
            generoUseCase
        )
    }
}