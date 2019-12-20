package br.com.beblue.bluerecords.configuration.sistema.usecase

import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio
import br.com.beblue.bluerecords.core.usecase.*
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCash
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCashImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class VendaUseCaseConfiguracao {

    @Bean
    open fun carregaUseCase(vendaRepositorio: VendaRepositorio, notificadorVenda: NotificadorVenda): VendaUseCase =
        VendaUseCaseImpl(vendaRepositorio, notificadorVenda)

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