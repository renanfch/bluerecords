package br.com.beblue.bluerecords.entrypoint.paginacao;

import java.util.List;

public class PaginacaoDTO<T extends PaginavelDTO> {

    private Integer tamanho;
    private Integer total;
    private Integer pagina;
    private List<T> objetos;
    private String mensagem;

    public PaginacaoDTO(Integer tamanho, Integer total, Integer pagina, List<T> objetos) {
        this.tamanho = tamanho;
        this.total = total;
        this.pagina = pagina;
        this.objetos = objetos;
        this.mensagem = "Sucesso";
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getPagina() {
        return pagina;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public List<T> getObjetos() {
        return objetos;
    }

    public String getMensagem() {
        return mensagem;
    }

    public PaginacaoDTO(String mensagem) {
        this.mensagem = mensagem;
    }

}
