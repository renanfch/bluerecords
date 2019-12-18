package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.entitidade.CashBack;

public interface CashBackUseCase {
    public CashBack buscarCashBack(Integer idGenero, Integer diaSemana);
}
