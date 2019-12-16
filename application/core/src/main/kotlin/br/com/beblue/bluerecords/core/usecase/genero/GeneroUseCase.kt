package br.com.beblue.bluerecords.core.usecase.genero

import br.com.beblue.bluerecords.core.entity.Genero

interface GeneroUseCase {
    fun buscarGenero() : List<Genero>
}