package br.com.beblue.bluerecords.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType.SWAGGER_2

@Configuration
@EnableSwagger2
open class SwaggerConfiguration {
    companion object {
        private const val EMAIL_BLUERECORDS = "contato@bluerecords.com.br"
        private const val SITE_BLUERECORDS = "http://bluerecords.com.br"
        private const val TITLE_BLUERECORDS = "Blue Records"
        private const val TITLE_LICENSE = "GC License"
        private const val URL_TERMS_OF_SERVICE_BLUERECORDS = "Terms of Service"
        private const val LICENCE_URL_BLUERECORDS = "http://bluerecords.com.br"
        private const val BASE_PACKAGE = "br.com.beblue.bluerecords.entrypoint"
    }

    @Value("\${application.version}")
    private lateinit var version: String

    @Value("\${application.name}")
    private lateinit var name: String

    @Value("\${application.description}")
    private lateinit var description: String

    @Bean
    open fun api(): Docket {
        return Docket(SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo())
    }

    private fun getApiInfo(): ApiInfo {
        return ApiInfo(
            name, description, version,
            URL_TERMS_OF_SERVICE_BLUERECORDS,
            Contact(TITLE_BLUERECORDS, SITE_BLUERECORDS, EMAIL_BLUERECORDS),
            TITLE_LICENSE,
            LICENCE_URL_BLUERECORDS,
            emptyList()
        )
    }

}
