package br.com.beblue.bluerecords.core.command;

public class RegistrarVendaItensCommand {
    private Integer idDisco;
    private Double valor;
    private Integer cashBack;

    public RegistrarVendaItensCommand(Integer idDisco, Double valor, Integer cashBack) {
        this.idDisco = idDisco;
        this.valor = valor;
        this.cashBack = cashBack;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public void setIdDisco(Integer idDisco) {
        this.idDisco = idDisco;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCashBack() {
        return cashBack;
    }

    public void setCashBack(Integer cashBack) {
        this.cashBack = cashBack;
    }


}
