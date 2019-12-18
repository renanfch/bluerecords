package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.Genero;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio;
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient;

import java.util.List;

public class DiscoUseCaseImpl implements DiscoUseCase {

    private DiscoRepositorio discoRepositorio;
    private DiscoSpotifyClient discoSpotifyClient;

    public DiscoUseCaseImpl(DiscoRepositorio discoRepositorio ,
                            DiscoSpotifyClient discoSpotifyClient) {
        this.discoRepositorio = discoRepositorio;
        this.discoSpotifyClient = discoSpotifyClient;
    }

    @Override
    public Disco consultar(Integer id)
    {
        return discoRepositorio.consultar(id);
    }

    @Override
    public Boolean discosForamCadastrados() {
        return discoRepositorio.existeDiscoCadastrado();
    }

    @Override
    public List<CadastraDiscoCommand> consultarDiscosParaCadastroPorGenero(Genero genero) {
        return discoSpotifyClient.buscarDiscos(genero, 50,0);
    }

    @Override
    public Paginacao<Disco> consultarDiscos(ConsultaDiscoCommand command)
    {
        return discoRepositorio.consultarDiscos(command);
    }

    @Override
    public Disco cadastrar(CadastraDiscoCommand command) {
        return discoRepositorio.cadastrar(command);
    }

}
