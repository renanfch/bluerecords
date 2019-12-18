package br.com.beblue.bluerecords.core.entitidade;

public class Genero {

    private Integer id;
    private String descricao;

    public Genero(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

}
