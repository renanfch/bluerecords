package br.com.beblue.bluerecords.entrypoint.disco.dto;

import br.com.beblue.bluerecords.entrypoint.paginacao.PaginavelDTO;

public class DiscoResponseDTO implements PaginavelDTO
{
    private String nome;
    private Double valor;

    public DiscoResponseDTO(String nome, Double valor)
    {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    public Double getValor() {
        return valor;
    }

}
