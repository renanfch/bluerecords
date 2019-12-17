package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio;

import java.util.List;

public class VendaUseCaseImpl implements VendaUseCase {

    public VendaUseCaseImpl(VendaRepositorio vendaRepositorio) {
        this.vendaRepositorio = vendaRepositorio;
    }

    private VendaRepositorio vendaRepositorio;

    @Override
    public Venda registrarVenda(RegistraVendaCommand command) {
        return null;
    }

    @Override
    public List<Venda> consultarVendas(ConsultaVendaCommand command) {
        return null;
    }

    @Override
    public Venda consultarVendaPorId(Integer id) {
        return null;
    }
}
