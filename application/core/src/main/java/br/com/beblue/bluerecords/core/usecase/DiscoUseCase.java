package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.Genero;

import java.util.List;

public interface DiscoUseCase {
    Disco consultarDiscoPorId(Integer id);
    Boolean discosForamCadastrados();
    List<CadastraDiscoCommand> consultarDiscosParaCadastroPorGenero(Genero genero);
    Disco cadastrarDisco(CadastraDiscoCommand command);
}
