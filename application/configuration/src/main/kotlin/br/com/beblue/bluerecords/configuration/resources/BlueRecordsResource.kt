package br.com.beblue.bluerecords.configuration.resources

import br.com.beblue.bluerecords.configuration.resources.BlueRecordsResource.Companion.PREFIX
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = PREFIX)
data class BlueRecordsResource(
    var database: BlueRecordsDatabaseResource? = null
) {
    companion object {
        const val PREFIX = "bluerecords"
    }
}