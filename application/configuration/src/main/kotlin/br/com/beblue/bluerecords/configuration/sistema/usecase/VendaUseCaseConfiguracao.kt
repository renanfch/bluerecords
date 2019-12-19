package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio
import br.com.beblue.bluerecords.core.usecase.CashBackUseCase
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase
import br.com.beblue.bluerecords.core.usecase.VendaUseCase
import br.com.beblue.bluerecords.core.usecase.VendaUseCaseImpl
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCash
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCashImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class VendaUseCaseConfiguracao {

    @Bean
    open fun carregaUseCase(vendaRepositorio: VendaRepositorio): VendaUseCase =
        VendaUseCaseImpl(vendaRepositorio)

    @Bean
    open fun carregaVendaComCashBackUseCase(
        vendaUseCase: VendaUseCase,
        cashBackUseCase: CashBackUseCase,
        discoUseCase: DiscoUseCase
    ):
            VendaComCashBackUseCash {
        return VendaComCashBackUseCashImpl(vendaUseCase, cashBackUseCase, discoUseCase)
    }

}