package br.com.beblue.bluerecords.core.entitidade;

import br.com.beblue.bluerecords.core.paginacao.Paginavel;

public class Venda implements Paginavel
{
    public Venda(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    private Integer id;

}
