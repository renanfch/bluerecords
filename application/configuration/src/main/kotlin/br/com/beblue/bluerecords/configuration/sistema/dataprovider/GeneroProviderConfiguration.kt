package br.com.beblue.bluerecords.configuration.sistema.dataprovider

import br.com.beblue.bluerecords.configuration.datasource.BlueRecordsDatasourceConfiguration
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio
import br.com.beblue.bluerecords.data.genero.GeneroRepositorioImpl
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate

@Configuration
open class GeneroProviderConfiguration {

    @Bean
    open fun carregaGeneroRepositorio(
        @Qualifier(BlueRecordsDatasourceConfiguration.BEAN_BLUERECORDS_JDBC_TEMPLATE) jdbcTemplate: JdbcTemplate
    ) : GeneroRepositorio
    {
        return GeneroRepositorioImpl(jdbcTemplate)
    }
}