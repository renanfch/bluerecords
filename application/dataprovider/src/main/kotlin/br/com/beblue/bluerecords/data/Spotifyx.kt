package br.com.beblue.bluerecords.data

import com.wrapper.spotify.SpotifyApi
import com.wrapper.spotify.model_objects.specification.Paging
import com.wrapper.spotify.model_objects.specification.Track

class Spotifyx(private val spotifyApi: SpotifyApi)
{

    fun buscarMusicasPorGenero(genero: String, limit: Int = 50, offset: Int = 0): Paging<Track>?
    {
        return spotifyApi
            .searchTracks("genre: $genero")
            .limit(limit)
            .offset(offset)
            .build()
            .execute()
    }

}