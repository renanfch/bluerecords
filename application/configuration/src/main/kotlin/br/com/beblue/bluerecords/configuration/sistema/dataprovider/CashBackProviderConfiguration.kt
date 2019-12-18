package br.com.beblue.bluerecords.configuration.sistema.dataprovider

import br.com.beblue.bluerecords.configuration.datasource.BlueRecordsDatasourceConfiguration
import br.com.beblue.bluerecords.core.repositorio.CashBackRepositorio
import br.com.beblue.bluerecords.data.cashback.CashBackRepositorioImpl
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
open class CashBackProviderConfiguration {

    @Bean
    open fun carregaCashBackRepositorio(
        @Qualifier(BlueRecordsDatasourceConfiguration.BEAN_BLUERECORDS_JDBC_TEMPLATE) jdbcTemplate: JdbcTemplate
    ): CashBackRepositorio {
        return CashBackRepositorioImpl(jdbcTemplate)
    }
}