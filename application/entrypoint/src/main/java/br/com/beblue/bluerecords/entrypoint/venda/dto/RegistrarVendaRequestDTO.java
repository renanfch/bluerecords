package br.com.beblue.bluerecords.entrypoint.venda.dto;

import java.time.LocalDate;
import java.util.List;

public class RegistrarVendaRequestDTO {

    public RegistrarVendaRequestDTO(){

    }

    public RegistrarVendaRequestDTO(Integer id, LocalDate date, Integer idCliente, List<RegistrarVendaItemRequestDTO> registrarVendaItemRequestDTO) {
        this.id = id;
        this.date = date;
        this.idCliente = idCliente;
        this.registrarVendaItemRequestDTO = registrarVendaItemRequestDTO;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public List<RegistrarVendaItemRequestDTO> getRegistrarVendaItemRequestDTO() {
        return registrarVendaItemRequestDTO;
    }

    private Integer id;
    private LocalDate date;
    private Integer idCliente;
    private List<RegistrarVendaItemRequestDTO> registrarVendaItemRequestDTO;
}
