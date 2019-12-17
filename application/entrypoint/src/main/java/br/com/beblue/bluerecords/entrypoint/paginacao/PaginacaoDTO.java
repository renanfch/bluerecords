package br.com.beblue.bluerecords.entrypoint.paginacao;

import java.util.List;

public class PaginacaoDTO<T extends PaginavelDTO> {

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

    private Integer tamanho;
    private Integer total;
    private Integer pagina;
    private List<T> objetos;

    public PaginacaoDTO(Integer tamanho, Integer total, Integer pagina, List<T> objetos) {
        this.tamanho = tamanho;
        this.total = total;
        this.pagina = pagina;
        this.objetos = objetos;
    }
}
