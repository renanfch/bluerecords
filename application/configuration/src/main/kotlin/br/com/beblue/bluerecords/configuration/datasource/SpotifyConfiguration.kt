package br.com.beblue.bluerecords.configuration.datasource

import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient
import br.com.beblue.bluerecords.data.disco.DiscoSpotifyClientImpl
import com.wrapper.spotify.SpotifyApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
open class SpotifyConfiguration {

    @Bean
    @Primary
    open fun loadSpotify() : DiscoSpotifyClient
    {
        val clientId = "5b1fdd5424fe48fa908b8fa2434767af"
        val clientSecret = "489ef90a33584d049f51401a707f7c25"

        val spotifyApi = SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .build()

        val clientCredentials = spotifyApi.clientCredentials().build().execute()
        spotifyApi.accessToken = clientCredentials.accessToken

        return DiscoSpotifyClientImpl(spotifyApi)
    }

}