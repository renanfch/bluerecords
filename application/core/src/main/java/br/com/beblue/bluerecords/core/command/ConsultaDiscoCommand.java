package br.com.beblue.bluerecords.core.command;

public class ConsultaDiscoCommand {
    public ConsultaDiscoCommand(String genero) {
        this.genero = genero;
    }
    public String getGenero() {
        return genero;
    }
    private String genero;

}

