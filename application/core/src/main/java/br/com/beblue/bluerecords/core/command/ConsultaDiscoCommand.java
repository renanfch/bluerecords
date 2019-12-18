package br.com.beblue.bluerecords.core.command;

public class ConsultaDiscoCommand {
    private PaginacaoCommand paginacaoCommand;
    private Integer genero;

    public ConsultaDiscoCommand(PaginacaoCommand paginacaoCommand, Integer genero) {
        this.paginacaoCommand = paginacaoCommand;
        this.genero = genero;
    }

    public PaginacaoCommand getPaginacaoCommand() {
        return paginacaoCommand;
    }

    public Integer getGenero() {
        return genero;
    }
}

