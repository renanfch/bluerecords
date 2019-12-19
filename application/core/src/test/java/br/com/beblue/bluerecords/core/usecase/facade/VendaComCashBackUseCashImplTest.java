package br.com.beblue.bluerecords.core.usecase.facade;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistrarVendaItensCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.usecase.CashBackUseCase;
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendaComCashBackUseCashImplTest {

    VendaUseCase vendaUseCase = Mockito.mock(VendaUseCase.class);
    CashBackUseCase cashBackUseCase = Mockito.mock(CashBackUseCase.class);
    DiscoUseCase discoUseCase = Mockito.mock(DiscoUseCase.class);

    List<RegistrarVendaItensCommand> itensVenda = new ArrayList<>();
    RegistraVendaCommand registraVendaCommand = new RegistraVendaCommand(LocalDate.now(), 1, new ArrayList<>(itensVenda));
    Venda venda = new Venda(1, 1, LocalDate.now(), 10.0);

    @Test
    void deveRetonarDezDeCashBack() {
        VendaComCashBackUseCash vendaComCashBackUseCash = new VendaComCashBackUseCashImpl(vendaUseCase, cashBackUseCase, discoUseCase);
        Mockito.when(vendaComCashBackUseCash.registrarVenda(registraVendaCommand)).thenReturn(venda);
        Venda vendaAtual = vendaComCashBackUseCash.registrarVenda(registraVendaCommand);
        assertEquals(Double.valueOf(10.0), vendaAtual.getTotalCashBack());
    }
}