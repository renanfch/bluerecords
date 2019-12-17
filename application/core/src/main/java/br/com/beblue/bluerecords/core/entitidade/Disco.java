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

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }



}
