package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;

public interface DiscoRepositorio {
    Disco cadastrar(CadastraDiscoCommand command);
    Boolean existeDiscoCadastrado();
    Paginacao<Disco> consultarDiscos(ConsultaDiscoCommand command);
    Disco consultar(Integer id);
}
