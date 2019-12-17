package br.com.beblue.bluerecords.core.command;

public class ConsultaDiscoCommand  {

    public ConsultaDiscoCommand(PaginacaoCommand paginacaoCommand, Integer genero)
    {
        this.paginacaoCommand = paginacaoCommand;
        this.genero = genero;
    }

    public PaginacaoCommand getPaginacaoCommand() {
        return paginacaoCommand;
    }

    private PaginacaoCommand paginacaoCommand;


    public Integer getGenero() {
        return genero;
    }

    private Integer genero;

}

