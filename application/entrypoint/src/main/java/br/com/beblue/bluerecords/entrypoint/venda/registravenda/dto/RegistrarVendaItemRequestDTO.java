package br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto;

public class RegistrarVendaItemRequestDTO {

    private Integer idDisco;
    private Integer quantidade;

    public RegistrarVendaItemRequestDTO() {
    }

    public RegistrarVendaItemRequestDTO(Integer idDisco, Integer quantidade) {
        this.idDisco = idDisco;
        this.quantidade = quantidade;
    }

    public Integer getIdDisco() {
        return idDisco;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
}
