package br.com.beblue.bluerecords.core.repositorio

import br.com.beblue.bluerecords.core.entity.Genero

interface GeneroRepositorio {
    fun buscarGenero(): List<Genero>
}