package br.com.beblue.bluerecords.configuration.amqp

import br.com.beblue.bluerecords.core.usecase.NotificadorVenda
import br.com.beblue.bluerecords.data.amqp.NotificadorVendaImpl
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AmqpConfiguration {

    @Bean
    open fun carregaNotificadorVenda(rabbitTemplate: RabbitTemplate): NotificadorVenda {
        return NotificadorVendaImpl(rabbitTemplate)
    }

}