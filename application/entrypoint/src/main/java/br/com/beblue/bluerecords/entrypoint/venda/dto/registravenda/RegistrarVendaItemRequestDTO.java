package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda;

public class RegistrarVendaItemRequestDTO {
    public RegistrarVendaItemRequestDTO() {
    }

    public RegistrarVendaItemRequestDTO(Integer idDisco, Integer quantidade) {
        this.idDisco = idDisco;
        this.quantidade = quantidade;
    }

    public Integer getIdDisco() {
        return idDisco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    private Integer idDisco;
    private Integer quantidade;
}
