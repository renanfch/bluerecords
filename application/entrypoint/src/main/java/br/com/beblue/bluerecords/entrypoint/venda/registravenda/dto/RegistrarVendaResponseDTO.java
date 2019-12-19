package br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto;

public class RegistrarVendaResponseDTO {

    private Integer id;
    private String mensagem;
    private Double totalCashBack;

    public RegistrarVendaResponseDTO(Integer id, String mensagem, Double totalCashBack) {
        this.id = id;
        this.mensagem = mensagem;
        this.totalCashBack = totalCashBack;
    }

    public RegistrarVendaResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Double getTotalCashBack() {
        return totalCashBack;
    }


}
