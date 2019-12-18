package br.com.beblue.bluerecords.core.entitidade;

public class VendaItem {

    private Integer id;
    private Integer idVenda;
    private Integer idDisco;
    private Double valor;
    private Double cashBack;
    private Integer quantidade;


    public VendaItem(Integer id, Integer idVenda, Integer idDisco, Double valor, Integer quantidade, Double cashBack) {
        this.id = id;
        this.idVenda = idVenda;
        this.idDisco = idDisco;
        this.valor = valor;
        this.cashBack = cashBack;
        this.quantidade = quantidade;
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

    public Double getCashBack() {
        return cashBack;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
