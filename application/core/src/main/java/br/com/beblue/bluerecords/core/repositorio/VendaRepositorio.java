package br.com.beblue.bluerecords.core.repositorio;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;

public interface VendaRepositorio {
    Venda cadastrar(RegistraVendaCommand command);
    Paginacao<Venda> consultaVendas(ConsultaVendaCommand command);
    Venda consulta(Integer id);
}
