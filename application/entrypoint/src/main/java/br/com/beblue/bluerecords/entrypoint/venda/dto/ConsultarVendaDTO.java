package br.com.beblue.bluerecords.entrypoint.venda.dto;

import java.util.Date;

public class ConsultarVendaDTO {
    public ConsultarVendaDTO(Integer pagina, Integer tamanho, Date dataInicial, Date dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.pagina = pagina;
        this.tamanho = tamanho;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    private Integer pagina;
    private Integer tamanho;
    private Date dataInicial;
    private Date dataFinal;

}
