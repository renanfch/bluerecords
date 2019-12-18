package br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto;


public class ConsultarVendaDTO {

    private Integer pagina;
    private Integer tamanho;
    private String dataInicial;
    private String dataFinal;

    public ConsultarVendaDTO(Integer pagina, Integer tamanho, String dataInicial, String dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.pagina = pagina;
        this.tamanho = tamanho;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

}
