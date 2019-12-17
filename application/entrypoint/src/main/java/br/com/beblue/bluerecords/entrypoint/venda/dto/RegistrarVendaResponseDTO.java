package br.com.beblue.bluerecords.entrypoint.venda.dto;

public class RegistrarVendaResponseDTO
{
    public RegistrarVendaResponseDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer id;
}
