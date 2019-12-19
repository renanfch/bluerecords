package br.com.beblue.bluerecords.configuration.sistema.dataprovider

import br.com.beblue.bluerecords.configuration.datasource.BlueRecordsDatasourceConfiguration.Companion.BEAN_BLUERECORDS_JDBC_TEMPLATE
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio
import br.com.beblue.bluerecords.data.venda.VendaRepositorioImpl
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
open class VendaRepositorioConfiguracao {

    @Bean
    @Primary
    open fun carregaVendaRepositorio(@Qualifier(BEAN_BLUERECORDS_JDBC_TEMPLATE) jdbcTemplate: JdbcTemplate): VendaRepositorio {
        return VendaRepositorioImpl(jdbcTemplate)
    }

}