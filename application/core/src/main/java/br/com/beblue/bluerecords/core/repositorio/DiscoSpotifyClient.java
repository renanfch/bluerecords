package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Genero;

import java.util.List;

public interface DiscoSpotifyClient {
    List<CadastraDiscoCommand> buscarDiscos(Genero genero, Integer limit, Integer offset);
}
