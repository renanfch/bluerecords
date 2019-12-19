package br.com.beblue.bluerecords.entrypoint.disco.dto;

public class DiscoRequestDTO {
    private Integer generoId;
    private Integer pagina;
    private Integer tamanho;

    public DiscoRequestDTO(Integer generoId, Integer pagina, Integer tamanho) {
        this.generoId = generoId==null?1:generoId;
        this.pagina = pagina==null?1:pagina;
        this.tamanho = tamanho==null?50:tamanho;
    }

    public Integer getGeneroId() {
        return generoId;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }


}
