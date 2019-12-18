package br.com.beblue.bluerecords.entrypoint.venda.dto;

public class RegistrarVendaItemRequestDTO {
    public RegistrarVendaItemRequestDTO() {

    }

    public RegistrarVendaItemRequestDTO(Integer idDisco, Double valor, Integer cashBack) {
        this.idDisco = idDisco;
        this.valor = valor;
        this.cashBack = cashBack;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getCashBack() {
        return cashBack;
    }

    private Integer idDisco;
    private Double valor;
    private Integer cashBack;
}
