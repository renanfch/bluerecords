package br.com.beblue.bluerecords.data

import br.com.beblue.bluerecords.core.entity.Genero
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class DiscoSpotifyClientTest {

    @Autowired
    private lateinit var discoSpotifyClient: DiscoSpotifyClient

    @Test
    fun buscarMusicasPorGenero()
    {
        val teste = discoSpotifyClient.buscarDiscos(Genero(1, "rock"))
    }

}