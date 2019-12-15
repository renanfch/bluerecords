package br.com.beblue.bluerecords.configuration.resources

import br.com.beblue.bluerecords.configuration.resources.BlueRecordsDatabaseResource.Companion.PREFIX
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = PREFIX)
data class BlueRecordsDatabaseResource(
    var url: String = "",
    var user: String = "",
    var password: String = "",
    var driver: String = ""
) {
    companion object {
        const val PREFIX = "bluerecordsdb.database"
    }
}