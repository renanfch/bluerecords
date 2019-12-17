package br.com.beblue.bluerecords.core.command;

import java.util.Date;

public class ConsultaVendaCommand {
    public ConsultaVendaCommand(Date dataInicial, Date dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    public Date getDataFinal() {
        return dataFinal;
    }

    private Date dataInicial;
    private Date dataFinal;
}
