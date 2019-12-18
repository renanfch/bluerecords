package br.com.beblue.bluerecords.core.command;

public class CadastraDiscoCommand
{
    private String nome;
    private Integer idGenero;
    private Double valor;

    public CadastraDiscoCommand(String nome, Integer idGenero, Double valor) {
        this.nome = nome;
        this.idGenero = idGenero;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    public Integer getIdGenero() {
        return idGenero;
    }
    public Double getValor() {
        return valor;
    }


}


