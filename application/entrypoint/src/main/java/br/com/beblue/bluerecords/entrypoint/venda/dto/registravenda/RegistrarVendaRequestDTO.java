package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda;

import java.time.LocalDate;
import java.util.List;

public class RegistrarVendaRequestDTO {

    public RegistrarVendaRequestDTO(){

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

    private String date;
    private Integer idCliente;
    private List<RegistrarVendaItemRequestDTO> registrarVendaItemRequestDTO;
}
