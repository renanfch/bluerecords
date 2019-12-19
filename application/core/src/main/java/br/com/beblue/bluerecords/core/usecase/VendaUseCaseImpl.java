package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio;

public class VendaUseCaseImpl implements VendaUseCase {

    public VendaUseCaseImpl(VendaRepositorio vendaRepositorio) {
        this.vendaRepositorio = vendaRepositorio;
    }

    private VendaRepositorio vendaRepositorio;

    @Override
    public Venda registrarVenda(RegistraVendaCommand command) {
        return vendaRepositorio.cadastrar(command);
    }

    @Override
    public Paginacao<Venda> consultarVendas(ConsultaVendaCommand command) {
        return vendaRepositorio.consultaVendas(command);
    }

    @Override
    public Venda consultarVendaPorId(Integer id) {
        return vendaRepositorio.consulta(id);
    }

}
