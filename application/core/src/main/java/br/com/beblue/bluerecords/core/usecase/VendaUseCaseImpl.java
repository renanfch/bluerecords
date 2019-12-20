package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio;

public class VendaUseCaseImpl implements VendaUseCase {

    private VendaRepositorio vendaRepositorio;
    private NotificadorVenda notificadorVenda;

    public VendaUseCaseImpl(VendaRepositorio vendaRepositorio, NotificadorVenda notificadorVenda) {
        this.vendaRepositorio = vendaRepositorio;
        this.notificadorVenda = notificadorVenda;
    }

    @Override
    public Venda registrarVenda(RegistraVendaCommand command) {
        Venda venda = vendaRepositorio.cadastrar(command);
        if(venda.getId()>0)
            notificadorVenda.notificarNovaVenda(venda.getId());

        return venda;
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
