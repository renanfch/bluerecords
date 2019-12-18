package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.repositorio.CashBackRepositorio
import br.com.beblue.bluerecords.core.usecase.CashBackUseCase
import br.com.beblue.bluerecords.core.usecase.CashBackUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class CashBackUseCaseConfiguration {

    @Bean
    open fun carregaCashBackUseCase(cashBackRepositorio: CashBackRepositorio): CashBackUseCase {
        return CashBackUseCaseImpl(cashBackRepositorio)
    }

}