package br.com.beblue.bluerecords.data.amqp

import br.com.beblue.bluerecords.core.usecase.NotificadorVenda
import org.springframework.amqp.rabbit.core.RabbitTemplate

class NotificadorVendaImpl(private val rabbitTemplate: RabbitTemplate) :
    NotificadorVenda {

    companion object {
        const val ROUTING_KEY = "bluerecords.venda.*"
    }

    override fun notificarNovaVenda(idVenda: Int?) {
        println("Venda efetuada com sucesso.")
        send("{\"idVenda\": $idVenda}", ROUTING_KEY)
    }

    private fun send(message: String, routingKey: String) {
        rabbitTemplate.convertAndSend("amq.topic", routingKey, process(message))
    }

    private fun process(message: String): String {
        return message
    }

}