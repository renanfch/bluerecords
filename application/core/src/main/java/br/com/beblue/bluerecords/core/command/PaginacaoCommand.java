package br.com.beblue.bluerecords.core.command;

public class PaginacaoCommand {
    private Integer pagina;
    private Integer tamanho;
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public Integer getPagina() {
        return pagina;
    }

    public void setPagina(Integer pagina) {
        this.pagina = pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }
    public Integer getOffset()
    {
        return tamanho * pagina;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public PaginacaoCommand(Integer pagina, Integer tamanho) {
        this.pagina = pagina;
        this.tamanho = tamanho;
    }
}
