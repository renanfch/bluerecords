package br.com.beblue.bluerecords.core.entitidade;

public class VendaItem {

    private Integer id;
    private Integer idVenda;
    private Integer idDisco;
    private Double valor;
    private Integer cashBack;

    public VendaItem(Integer id, Integer idVenda, Integer idDisco, Double valor, Integer cashBack) {
        this.id = id;
        this.idVenda = idVenda;
        this.idDisco = idDisco;
        this.valor = valor;
        this.cashBack = cashBack;
    }

    public Integer getId() {
        return id;
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



}
