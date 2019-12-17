package br.com.beblue.bluerecords.entrypoint.disco.mapper;

public class DiscoRequestDTO
{
    private String genero;
    private Integer pagina;
    private Integer tamanho;

    public String getGenero() {
        return genero;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public DiscoRequestDTO(String genero, Integer pagina, Integer tamanho) {
        this.genero = genero;
        this.pagina = pagina;
        this.tamanho = tamanho;
    }
}
