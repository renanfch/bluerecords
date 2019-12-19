package br.com.beblue.bluerecords.entrypoint.venda.amqp

import br.com.beblue.bluerecords.core.usecase.NotificadorVenda
import org.springframework.amqp.rabbit.core.RabbitTemplate

class NotificadorVendaImpl(private val rabbitTemplate: RabbitTemplate) : NotificadorVenda {

    override fun enviarEmail(idVenda: Int?) {
        send("","")
    }

    private fun send(message: String, routingKey: String = "") {
        rabbitTemplate.convertAndSend(routingKey, process(message))
    }

    private fun process(message: String): String
    {
        return message
    }

}