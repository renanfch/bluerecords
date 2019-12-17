package br.com.beblue.bluerecords.core.command;

public class CadastraDiscoCommand {
    public CadastraDiscoCommand(String nome, Integer idGenero, Double valor) {
        this.nome = nome;
        this.idGenero = idGenero;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Integer idGenero) {
        this.idGenero = idGenero;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    private String nome;
    private Integer idGenero;
    private Double valor;
}


