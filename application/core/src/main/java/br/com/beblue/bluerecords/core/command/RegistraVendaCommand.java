package br.com.beblue.bluerecords.core.command;


import java.time.LocalDate;
import java.util.List;

public class RegistraVendaCommand {

    private Integer id;
    private LocalDate date;
    private Integer idCliente;
    List<RegistrarVendaItensCommand> registrarVendaItensCommand;


    public List<RegistrarVendaItensCommand> getRegistrarVendaItensCommand() {
        return registrarVendaItensCommand;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

    public RegistraVendaCommand(Integer id, LocalDate date, Integer idCliente, List<RegistrarVendaItensCommand> registrarVendaItensCommand) {
        this.id = id;
        this.date = date;
        this.idCliente = idCliente;
        this.registrarVendaItensCommand = registrarVendaItensCommand;
    }
}
