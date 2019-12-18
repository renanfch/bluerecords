package br.com.beblue.bluerecords.core.usecase.facade;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;

public interface VendaComCashBackUseCash {
    Venda registrarVenda(RegistraVendaCommand command);
}
