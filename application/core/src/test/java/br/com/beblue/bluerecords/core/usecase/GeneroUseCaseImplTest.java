package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.entitidade.Genero;
import br.com.beblue.bluerecords.core.repositorio.GeneroRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroUseCaseImplTest {

    GeneroRepositorio generoRepositorio = Mockito.mock(GeneroRepositorio.class);
    Genero genero = new Genero(1, "ROCK");

    @Test
    void deveRetornarUmGenero() {
        List<Genero> generos = new ArrayList<>();
        generos.add(genero);
        GeneroUseCase generoUseCase = new GeneroUseCaseImpl(generoRepositorio);
        Mockito.when(generoUseCase.buscarGenero()).thenReturn(generos);
        List<Genero> generosAtual = generoUseCase.buscarGenero();
        assertEquals(1, generosAtual.size());
    }

    @Test
    void deveRetornarUmGeneroComIdUm() {
        List<Genero> generos = new ArrayList<>();
        generos.add(genero);
        GeneroUseCase generoUseCase = new GeneroUseCaseImpl(generoRepositorio);
        Mockito.when(generoUseCase.buscarGenero()).thenReturn(generos);
        List<Genero> generosAtual = generoUseCase.buscarGenero();
        assertEquals(Integer.valueOf(1), generosAtual.get(0).getId());
    }

}