package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.dto;

import java.util.List;

public class RegistrarVendaRequestDTO {

    private String date;
    private Integer idCliente;
    private List<RegistrarVendaItemRequestDTO> registrarVendaItemRequestDTO;

    public RegistrarVendaRequestDTO() {
    }

    public RegistrarVendaRequestDTO(String date, Integer idCliente, List<RegistrarVendaItemRequestDTO> registrarVendaItemRequestDTO) {
        this.date = date;
        this.idCliente = idCliente;
        this.registrarVendaItemRequestDTO = registrarVendaItemRequestDTO;
    }


    public String getDate() {
        return date;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public List<RegistrarVendaItemRequestDTO> getRegistrarVendaItemRequestDTO() {
        return registrarVendaItemRequestDTO;
    }
}
