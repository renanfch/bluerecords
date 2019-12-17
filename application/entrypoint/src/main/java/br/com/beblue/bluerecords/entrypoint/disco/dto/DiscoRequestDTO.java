package br.com.beblue.bluerecords.entrypoint.disco.dto;

public class DiscoRequestDTO
{
    private Integer generoId;
    private Integer pagina;
    private Integer tamanho;

    public Integer getGeneroId() {
        return generoId;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public DiscoRequestDTO(Integer generoId, Integer pagina, Integer tamanho) {
        this.generoId = generoId;
        this.pagina = pagina;
        this.tamanho = tamanho;
    }
}
