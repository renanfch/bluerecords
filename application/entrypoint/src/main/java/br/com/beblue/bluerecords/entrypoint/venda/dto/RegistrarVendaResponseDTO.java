package br.com.beblue.bluerecords.entrypoint.venda.dto;

public class RegistrarVendaResponseDTO
{
    public Integer getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    private Integer id;
    private String mensagem;

    public RegistrarVendaResponseDTO(Integer id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

}
