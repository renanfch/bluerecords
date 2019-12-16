package br.com.beblue.bluerecords.configuration.datasource

import br.com.beblue.bluerecords.core.usecase.PopulaBancoUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
open class DataBaseInitializer : ApplicationListener<ApplicationReadyEvent>
{
    @Autowired
    private lateinit var populaBancoUseCase: PopulaBancoUseCase

    override fun onApplicationEvent(event: ApplicationReadyEvent)
    {
        populaBancoUseCase.populaBancoDeDados()
    }
}