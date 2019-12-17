package br.com.beblue.bluerecords.core.entitidade;

public class Disco {

    public Disco(Integer id, Integer idGenero, String nome, Double valor) {
        this.id = id;
        this.idGenero = idGenero;
        this.nome = nome;
        this.valor = valor;
    }

    private Integer id;
    private Integer idGenero;
    private String nome;
    private Double valor;

    public Integer getId() {
        return id;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

}
