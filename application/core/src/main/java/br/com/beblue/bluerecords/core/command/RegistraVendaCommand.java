package br.com.beblue.bluerecords.core.command;

public class RegistraVendaCommand {

    public RegistraVendaCommand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private Integer id;

}
