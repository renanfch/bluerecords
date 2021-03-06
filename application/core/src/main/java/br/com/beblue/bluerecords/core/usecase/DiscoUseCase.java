package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.command.ConsultaDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.Genero;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;

import java.util.List;

public interface DiscoUseCase {
    Disco consultar(Integer id);
    Boolean discosForamCadastrados();
    List<CadastraDiscoCommand> consultarDiscosParaCadastroPorGenero(Genero genero);
    Paginacao<Disco> consultarDiscos(ConsultaDiscoCommand command);
    Disco cadastrar(CadastraDiscoCommand command);
}
