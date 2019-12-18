package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;

import java.util.List;

public interface VendaUseCase {

    Venda registrarVenda(RegistraVendaCommand command);

    Paginacao<Venda> consultarVendas(ConsultaVendaCommand command);

    Venda consultarVendaPorId(Integer id);

}
