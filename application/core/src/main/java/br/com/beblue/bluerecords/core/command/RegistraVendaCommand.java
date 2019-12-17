package br.com.beblue.bluerecords.core.command;

public class RegistraVendaCommand {

    public RegistraVendaCommand(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

}
