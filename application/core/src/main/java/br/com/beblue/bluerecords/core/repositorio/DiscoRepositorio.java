package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;

public interface DiscoRepositorio {
    Disco cadastrar(CadastraDiscoCommand command);
    Boolean existeDiscoCadastrado();
}
