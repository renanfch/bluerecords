package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.entitidade.CashBack;
import br.com.beblue.bluerecords.core.repositorio.CashBackRepositorio;

public class CashBackUseCaseImpl implements CashBackUseCase {

    public CashBackUseCaseImpl(CashBackRepositorio cashBackRepositorio) {
        this.cashBackRepositorio = cashBackRepositorio;
    }

    private CashBackRepositorio cashBackRepositorio;

    @Override
    public CashBack buscarCashBack(Integer idGenero, Integer diaSemana) {
        return cashBackRepositorio.buscarCashBack(idGenero, diaSemana);
    }

}
