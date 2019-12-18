package br.com.beblue.bluerecords.core.command;


import java.time.LocalDate;
import java.util.List;

public class RegistraVendaCommand {
    private LocalDate date;
    private Integer idCliente;
    List<RegistrarVendaItensCommand> registrarVendaItensCommand;

    public RegistraVendaCommand(LocalDate date, Integer idCliente, List<RegistrarVendaItensCommand> registrarVendaItensCommand) {
        this.date = date;
        this.idCliente = idCliente;
        this.registrarVendaItensCommand = registrarVendaItensCommand;
    }

    public List<RegistrarVendaItensCommand> getRegistrarVendaItensCommand() {
        return registrarVendaItensCommand;
    }
    public Integer getIdCliente() {
        return idCliente;
    }
    public LocalDate getDate() {
        return date;
    }


}
