package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.entitidade.CashBack;

public interface CashBackRepositorio {
    CashBack buscarCashBack(Integer idGenero, Integer diaSemana);
}
