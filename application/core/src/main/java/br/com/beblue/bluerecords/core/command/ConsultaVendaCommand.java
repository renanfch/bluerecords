package br.com.beblue.bluerecords.core.command;

import java.time.LocalDate;

public class ConsultaVendaCommand {

    private PaginacaoCommand paginacaoCommand;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    public ConsultaVendaCommand(LocalDate dataInicial, LocalDate dataFinal, PaginacaoCommand paginacaoCommand) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.paginacaoCommand = paginacaoCommand;
    }

    public PaginacaoCommand getPaginacaoCommand() {
        return paginacaoCommand;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }
}
