package br.com.beblue.bluerecords.configuration.datasource

import br.com.beblue.bluerecords.configuration.resources.BlueRecordsDatabaseResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.jdbc.core.JdbcTemplate
import javax.sql.DataSource

@Configuration
open class BlueRecordsDatasourceConfiguration {
    companion object {
        const val BEAN_BLUERECORDS_DATA_SOURCE = "blueRecordsDataSource"
        const val BEAN_BLUERECORDS_JDBC_TEMPLATE = "blueRecordsDataSourceTemplate"
    }

    @Bean(BEAN_BLUERECORDS_DATA_SOURCE)
    @Autowired
    open fun blueRecordsDataSource(resource: BlueRecordsDatabaseResource): DataSource {
        return DataSourceBuilder.create().apply {
            url(resource.url)
            username(resource.user)
            password(resource.password)
            driverClassName(resource.driver)
        }.build()
    }

    @Bean(BEAN_BLUERECORDS_JDBC_TEMPLATE)
    @DependsOn(BEAN_BLUERECORDS_DATA_SOURCE)
    open fun blueRecordsJdbcTemplate(
        @Qualifier(BEAN_BLUERECORDS_DATA_SOURCE) blueRecordsDataSource: DataSource
    ): JdbcTemplate {
        return JdbcTemplate(blueRecordsDataSource)
    }
}