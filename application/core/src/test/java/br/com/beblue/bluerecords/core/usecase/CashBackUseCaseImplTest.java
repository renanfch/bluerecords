package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.entitidade.CashBack;
import br.com.beblue.bluerecords.core.repositorio.CashBackRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CashBackUseCaseImplTest {

    CashBackRepositorio cashBackRepositorio = Mockito.mock(CashBackRepositorio.class);
    CashBack cashBack = new CashBack(1,1,1,40.0);

    @Test
    void deveRetonarCashBackComQuarentaPorcentoDesconto()
    {
        CashBackUseCase cashBackUseCase = new CashBackUseCaseImpl(cashBackRepositorio);
        Mockito.when(cashBackUseCase.buscarCashBack(1,1)).thenReturn(cashBack);
        CashBack cashBackAtual = cashBackUseCase.buscarCashBack(1,1);
        assertEquals(Double.valueOf(40.0),cashBackAtual.getPorcentagemCashBack());
    }
}