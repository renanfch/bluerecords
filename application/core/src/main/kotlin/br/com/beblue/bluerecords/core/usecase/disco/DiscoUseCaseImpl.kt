package br.com.beblue.bluerecords.core.usecase.disco

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.entity.Genero
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient
import br.com.beblue.bluerecords.core.usecase.disco.command.CadastrarDiscoCommand
import br.com.beblue.bluerecords.core.usecase.disco.command.ConsultaDiscosCommand

class DiscoUseCaseImpl(private val discoRepositorio: DiscoRepositorio,
                       private val discoSpotifyClient: DiscoSpotifyClient
) : DiscoUseCase
{

    override fun consultarDiscoPorId(id: Int): Disco {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun discosForamCadastrados(): Boolean {
        return discoRepositorio.existeDiscoCadastrado()
    }

    override fun consultarDiscosParaCadastroPorGenero(genero: Genero): List<CadastrarDiscoCommand>
    {
        return discoSpotifyClient.buscarDiscos(genero, 50,0)
    }

    override fun cadastrarDisco(command: CadastrarDiscoCommand): Disco {
        return discoRepositorio.cadastrar(command)
    }

}