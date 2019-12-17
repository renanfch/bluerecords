package br.com.beblue.bluerecords.core.entitidade;

public class Venda {
    public Venda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;

}
