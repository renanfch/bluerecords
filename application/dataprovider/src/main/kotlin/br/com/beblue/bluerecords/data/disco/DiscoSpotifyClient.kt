package br.com.beblue.bluerecords.data.disco

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand
import br.com.beblue.bluerecords.core.entitidade.Genero
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient
import br.com.beblue.bluerecords.data.disco.dto.DiscoResponseDTO
import br.com.beblue.bluerecords.data.disco.mapper.toCadastrarDiscoCommand
import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track

class DiscoSpotifyClientImpl(private val spotifyApi: SpotifyApi) : DiscoSpotifyClient {

    //Busca os primeiros 50 discos não repetidos, se buscar apenas uma vez vem vários repetidos.
    override fun buscarDiscos(genero: Genero, limit: Int, offset: Int): List<CadastraDiscoCommand> {
        val discos = mutableListOf<DiscoResponseDTO>()
        var off = offset

        while (discos.size < 50) {
            val musicas = buscarMusicasPorGenero(genero.descricao, limit, off).items

            musicas.forEach { it ->
                if (!discos.any { discoResponse ->
                        discoResponse.nome == it.album.name
                    })
                    if (discos.size < 50)
                        discos.add(DiscoResponseDTO(it.album.name, it.album.releaseDate, genero.id))
            }
            off += 50
        }

        return discos.toCadastrarDiscoCommand()
    }

    private fun buscarMusicasPorGenero(genero: String, limit: Int = 50, offset: Int = 0): Paging<Track> {
        return spotifyApi
            .searchTracks("genre: $genero")
            .limit(limit)
            .offset(offset)
            .build()
            .execute()
    }

}