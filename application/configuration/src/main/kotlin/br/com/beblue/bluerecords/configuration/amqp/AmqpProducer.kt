package br.com.beblue.bluerecords.configuration.amqp

import org.springframework.amqp.rabbit.core.RabbitTemplate

class AmqpProducer(
    private val rabbitTemplate: RabbitTemplate
) {

    fun send(message: String, routingKey: String = "") {
        rabbitTemplate.convertAndSend(routingKey, process(message))
    }

    open fun process(message: String): String {
        return message
    }
}