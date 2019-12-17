package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;

public interface VendaRepositorio {
    Disco cadastrar(CadastraDiscoCommand command);
}
