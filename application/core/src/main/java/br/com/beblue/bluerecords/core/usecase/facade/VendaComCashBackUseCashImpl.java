package br.com.beblue.bluerecords.core.usecase.facade;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.CashBack;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.usecase.CashBackUseCase;
import br.com.beblue.bluerecords.core.usecase.DiscoUseCase;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;

public class VendaComCashBackUseCashImpl implements VendaComCashBackUseCash {

    public VendaComCashBackUseCashImpl(VendaUseCase vendaUseCase, CashBackUseCase cashBackUseCase, DiscoUseCase discoUseCase) {
        this.vendaUseCase = vendaUseCase;
        this.cashBackUseCase = cashBackUseCase;
        this.discoUseCase = discoUseCase;
    }

    private VendaUseCase vendaUseCase;
    private CashBackUseCase cashBackUseCase;
    private DiscoUseCase discoUseCase;

    @Override
    public Venda registrarVenda(RegistraVendaCommand command)
    {
        Integer diaSemana = command.getDate().getDayOfWeek().getValue();
        command.getRegistrarVendaItensCommand().forEach(it -> {

            Disco disco = discoUseCase.consultar(it.getIdDisco());
            Integer idGenero = discoUseCase.consultar(it.getIdDisco()).getIdGenero();
            Double valor = disco.getValor();
            CashBack cashBack = cashBackUseCase.buscarCashBack(idGenero, diaSemana);
            it.setValor(valor);
            it.setCashBack(calcularCashBack(it.getQuantidade(), valor, cashBack.getPorcentagemCashBack()));
        });
        return vendaUseCase.registrarVenda(command);
    }

    private Double calcularCashBack(Integer quantidade, Double valor, Double cashBack)
    {
        return ((valor * cashBack) / 100) * quantidade;
    }
}
