package br.com.beblue.bluerecords

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = ["br.com.beblue.bluerecords.configuration"])
open class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}