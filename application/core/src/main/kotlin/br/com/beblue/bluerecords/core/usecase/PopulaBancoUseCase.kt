package br.com.beblue.bluerecords.core.usecase

import br.com.beblue.bluerecords.core.usecase.disco.DiscoUseCase
import br.com.beblue.bluerecords.core.usecase.genero.GeneroUseCase

class PopulaBancoUseCase(private val discoUseCase: DiscoUseCase, private val generoUseCase: GeneroUseCase) {

    fun populaBancoDeDados() {
        if (!discoUseCase.discosForamCadastrados()) {
            val generos = generoUseCase.buscarGenero()
            generos.forEach { genero ->
                val commands = discoUseCase.consultarDiscosParaCadastroPorGenero(genero)
                commands.forEach {
                    discoUseCase.cadastrarDisco(it)
                }
            }
        }
    }

}