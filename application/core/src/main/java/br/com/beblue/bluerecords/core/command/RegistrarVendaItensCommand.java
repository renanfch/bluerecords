package br.com.beblue.bluerecords.core.command;

public class RegistrarVendaItensCommand {
    private Integer idDisco;
    private Integer quantidade;
    private Double cashBack;
    private Double valor;

    public RegistrarVendaItensCommand(Integer idDisco, Integer quantidade) {
        this.idDisco = idDisco;
        this.quantidade = quantidade;
        this.cashBack = 0.0;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getCashBack() {
        return cashBack;
    }

    public void setCashBack(Double cashBack) {
        this.cashBack = cashBack;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
