package br.com.beblue.bluerecords.core.repositorio

import br.com.beblue.bluerecords.core.entity.Genero
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand

interface DiscoSpotifyClient {
    fun buscarDiscos(genero: Genero, limit:Int = 50, offset:Int = 0) : List<CadastrarDiscoCommand>
}