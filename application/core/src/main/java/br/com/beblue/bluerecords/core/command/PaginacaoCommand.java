package br.com.beblue.bluerecords.core.command;

public class PaginacaoCommand {
    private Integer pagina;
    private Integer tamanho;

    public PaginacaoCommand(Integer pagina, Integer tamanho) {
        this.pagina = pagina;
        this.tamanho = tamanho;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public Integer getOffset() {
        if (pagina == 1 || pagina == 0)
            return 0;
        return tamanho * (pagina - 1);
    }
}
