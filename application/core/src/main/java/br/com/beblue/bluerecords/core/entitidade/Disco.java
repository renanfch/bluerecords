package br.com.beblue.bluerecords.core.entitidade;

import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginavel;

public class Disco implements Paginavel {

    private Integer id;
    private Integer idGenero;
    private String nome;
    private Double valor;
    private String genero;

    public Disco(Integer id, Integer idGenero, String nome, Double valor, String genero) {
        this.id = id;
        this.idGenero = idGenero;
        this.nome = nome;
        this.valor = valor;
        this.genero = genero;
    }

    public Disco(Integer id, Integer idGenero, String nome, Double valor) {
        this.id = id;
        this.idGenero = idGenero;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Double getValor() {
        return valor;
    }

}
