package br.com.beblue.bluerecords.entrypoint.disco.dto;

import br.com.beblue.bluerecords.entrypoint.paginacao.PaginavelDTO;

public class DiscoResponseDTO implements PaginavelDTO {
    private String nome;
    private Double valor;
    private String mensagem;
    private String genero;

    public DiscoResponseDTO(String nome, Double valor, String genero) {
        this.nome = nome;
        this.valor = valor;
        this.genero = genero;
        this.mensagem = "Sucesso";
    }

    public DiscoResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
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
