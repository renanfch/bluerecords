package br.com.beblue.bluerecords.core.entitidade;

public class CashBack {
    public CashBack(Integer id, Integer idGenero, Integer diaSemana, Double porcentagemCashBack) {
        this.id = id;
        this.idGenero = idGenero;
        this.diaSemana = diaSemana;
        this.porcentagemCashBack = porcentagemCashBack;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public Double getPorcentagemCashBack() {
        return porcentagemCashBack;
    }

    private Integer id;
    private Integer idGenero;
    private Integer diaSemana;
    private Double porcentagemCashBack;
}

