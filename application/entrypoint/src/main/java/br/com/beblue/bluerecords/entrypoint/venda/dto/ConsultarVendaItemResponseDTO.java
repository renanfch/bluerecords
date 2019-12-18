package br.com.beblue.bluerecords.entrypoint.venda.dto;

public class ConsultarVendaItemResponseDTO {

    public ConsultarVendaItemResponseDTO(Integer idVendaItens, Integer idVenda, Integer idDisco, Double valor, Integer cashBack) {
        this.idVendaItens = idVendaItens;
        this.idVenda = idVenda;
        this.idDisco = idDisco;
        this.valor = valor;
        this.cashBack = cashBack;
    }

    public Integer getIdVendaItens() {
        return idVendaItens;
    }

    public Integer getIdVenda() {
        return idVenda;
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

    private Integer idVendaItens;
    private Integer idVenda;
    private Integer idDisco;
    private Double valor;
    private Integer cashBack;

}
