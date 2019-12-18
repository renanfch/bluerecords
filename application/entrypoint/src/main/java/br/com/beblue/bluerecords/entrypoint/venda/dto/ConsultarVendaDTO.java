package br.com.beblue.bluerecords.entrypoint.venda.dto;


import java.time.LocalDate;

public class ConsultarVendaDTO {
    public ConsultarVendaDTO(Integer pagina, Integer tamanho, LocalDate dataInicial, LocalDate dataFinal) {
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.pagina = pagina;
        this.tamanho = tamanho;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
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
    private LocalDate dataInicial;
    private LocalDate dataFinal;

}
