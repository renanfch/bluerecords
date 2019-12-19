package br.com.beblue.bluerecords.core.entitidade;

import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda implements Paginavel {

    private Integer id;
    private Integer idCliente;
    private LocalDate dataVenda;
    private Double totalCashBack;
    private List<VendaItem> vendaItens;


    public Venda(Integer id, Integer idCliente, LocalDate dataVenda, Double totalCashBack) {
        this.id = id;
        this.idCliente = idCliente;
        this.dataVenda = dataVenda;
        this.vendaItens = new ArrayList<>();
        this.totalCashBack = totalCashBack;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public List<VendaItem> getVendaItens() {
        return Collections.unmodifiableList(vendaItens);
    }

    public Double getTotalCashBack() {
        return totalCashBack;
    }

    public void adicionarItensVendido(List<VendaItem> vendaItem) {
        this.vendaItens.addAll(vendaItem);
    }
    public void adicionarItemVendido(VendaItem vendaItem) {
        this.vendaItens.add(vendaItem);
    }


}
