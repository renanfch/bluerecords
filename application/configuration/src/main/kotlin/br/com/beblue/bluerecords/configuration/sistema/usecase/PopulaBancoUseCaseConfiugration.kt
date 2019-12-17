package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.facade.PopulaBancoUseCase
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase
import br.com.beblue.bluerecords.core.usecase.GeneroUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class PopulaBancoUseCaseConfiugration
{
    @Bean
    open fun carregaPopulaBancoUseCase(discoUseCase: DiscoUseCase, generoUseCase: GeneroUseCase) : PopulaBancoUseCase
    {
        return PopulaBancoUseCase(discoUseCase,generoUseCase)
    }
}