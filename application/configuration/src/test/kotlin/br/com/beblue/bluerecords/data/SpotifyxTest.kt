package br.com.beblue.bluerecords.data

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
internal class SpotifyxTest {

    @Autowired
    private lateinit var spotifyx: Spotifyx

    @Test
    fun buscarMusicasPorGenero()
    {
        val teste = spotifyx.buscarMusicasPorGenero("mpb")
    }
}