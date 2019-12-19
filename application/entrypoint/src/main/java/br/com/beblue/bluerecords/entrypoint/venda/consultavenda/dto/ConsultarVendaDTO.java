package br.com.beblue.bluerecords.entrypoint.venda.consultavenda.dto;


import br.com.beblue.bluerecords.entrypoint.util.DataUtil;

import java.time.LocalDate;

public class ConsultarVendaDTO {

    private Integer pagina;
    private Integer tamanho;
    private String dataInicial;
    private String dataFinal;

    public ConsultarVendaDTO(Integer pagina, Integer tamanho, String dataInicial, String dataFinal) {
        this.dataInicial = dataInicial == null ? DataUtil.converteLocalDateParaString() : dataInicial;
        this.dataFinal = dataFinal == null ? DataUtil.converteLocalDateParaString() : dataFinal;
        this.pagina = pagina == null ? 1 : pagina;
        this.tamanho = tamanho == null ? 50 : tamanho;
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
