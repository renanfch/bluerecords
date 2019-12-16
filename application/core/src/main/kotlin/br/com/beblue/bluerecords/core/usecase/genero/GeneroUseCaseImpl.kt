package br.com.beblue.bluerecords.core.usecase.genero

import br.com.beblue.bluerecords.core.entity.Genero
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio

class GeneroUseCaseImpl(private val generoRepositorio: GeneroRepositorio) : GeneroUseCase
{
    override fun buscarGenero(): List<Genero> {
        return generoRepositorio.buscarGenero()
    }
}