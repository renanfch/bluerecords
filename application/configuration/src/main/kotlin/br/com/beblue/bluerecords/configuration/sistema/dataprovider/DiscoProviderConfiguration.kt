package br.com.beblue.bluerecords.configuration.sistema.dataprovider

import br.com.beblue.bluerecords.configuration.datasource.BlueRecordsDatasourceConfiguration
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio
import br.com.beblue.bluerecords.data.disco.DiscoRepositorioImpl
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
open class DiscoProviderConfiguration {

    @Bean
    open fun carregaDiscoProvider(
        @Qualifier(BlueRecordsDatasourceConfiguration.BEAN_BLUERECORDS_JDBC_TEMPLATE) jdbcTemplate: JdbcTemplate): DiscoRepositorio
    {
        return DiscoRepositorioImpl(jdbcTemplate)
    }

}