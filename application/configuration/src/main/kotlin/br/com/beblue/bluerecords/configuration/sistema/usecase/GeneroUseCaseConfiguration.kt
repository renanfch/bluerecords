package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio
import br.com.beblue.bluerecords.core.usecase.genero.GeneroUseCase
import br.com.beblue.bluerecords.core.usecase.genero.GeneroUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GeneroUseCaseConfiguration {

    @Bean
    open fun carregaGeneroUseCase(generoRepositorio: GeneroRepositorio): GeneroUseCase {
        return GeneroUseCaseImpl(generoRepositorio)
    }

}