package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.entitidade.Genero;
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio;

import java.util.List;

public class GeneroUseCaseImpl implements GeneroUseCase {

    public GeneroUseCaseImpl(GeneroRepositorio generoRepositorio) {
        this.generoRepositorio = generoRepositorio;
    }

    private GeneroRepositorio generoRepositorio;

    @Override
    public List<Genero> buscarGenero() {
        return generoRepositorio.buscarGenero();
    }
}
