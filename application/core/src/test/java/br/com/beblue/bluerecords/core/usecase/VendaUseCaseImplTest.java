package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.command.PaginacaoCommand;
import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistrarVendaItensCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.repositorio.VendaRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendaUseCaseImplTest {

    PaginacaoCommand paginacaoCommand = new PaginacaoCommand(1, 50);
    ConsultaVendaCommand consultaVendaCommand = new ConsultaVendaCommand(LocalDate.now(), LocalDate.now(), paginacaoCommand);
    RegistrarVendaItensCommand registrarVendaItensCommand = new RegistrarVendaItensCommand(1, 2);
    List<RegistrarVendaItensCommand> itensVenda = new ArrayList<>();
    RegistraVendaCommand registraVendaCommand = new RegistraVendaCommand(LocalDate.now(), 1, new ArrayList<>(itensVenda));
    Venda venda = new Venda(1, 1, LocalDate.now(), 10.0);
    VendaRepositorio vendaRepositorio = Mockito.mock(VendaRepositorio.class);
    NotificadorVenda notificadorVenda = Mockito.mock(NotificadorVenda.class);

    @Test
    public void deveRetonarVendaComIdUm() {
        VendaUseCase vendaUseCase = new VendaUseCaseImpl(vendaRepositorio,notificadorVenda);
        Mockito.when(vendaRepositorio.consulta(1)).thenReturn(venda);
        Venda vendaAtual = vendaUseCase.consultarVendaPorId(1);

        assertEquals(Integer.valueOf(1), vendaAtual.getId());
    }

    @Test
    public void deveRegistrarUmaVenda() {
        VendaUseCase vendaUseCase = new VendaUseCaseImpl(vendaRepositorio,notificadorVenda);
        Mockito.when(vendaRepositorio.cadastrar(registraVendaCommand)).thenReturn(venda);
        Venda vendaAtual = vendaUseCase.registrarVenda(registraVendaCommand);

        assertEquals(Integer.valueOf(1), vendaAtual.getId());
    }
}