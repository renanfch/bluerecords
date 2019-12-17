package br.com.beblue.bluerecords.core.facade;

import br.com.beblue.bluerecords.core.command.CadastraDiscoCommand;
import br.com.beblue.bluerecords.core.entitidade.Genero;
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.core.usecase.GeneroUseCase;

import java.util.List;

public class PopulaBancoUseCase {

    public PopulaBancoUseCase(DiscoUseCase discoUseCase, GeneroUseCase generoUseCase) {
        this.discoUseCase = discoUseCase;
        this.generoUseCase = generoUseCase;
    }

    private DiscoUseCase discoUseCase;
    private GeneroUseCase generoUseCase;

    public void populaBancoDeDados() {
        if (!discoUseCase.discosForamCadastrados()) {
            List<Genero> generos = generoUseCase.buscarGenero();
            generos.forEach(genero -> {
                List<CadastraDiscoCommand> commands = discoUseCase.consultarDiscosParaCadastroPorGenero(genero);
                commands.forEach(it -> discoUseCase.cadastrarDisco(it));
            });
        }
    }
}
