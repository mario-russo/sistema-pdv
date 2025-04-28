package br.com.mario.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private Long id;
    private LocalDateTime dataVenda;
    private Double valorTotal;
    private String formaPagamento;
    private String observacao;
    private List<ItemVenda> itens;

    public Venda() {
        this.dataVenda = LocalDateTime.now();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public Venda(Long id, String formaPagamento, String observacao) {
        this();
        this.id = id;
        this.formaPagamento = formaPagamento;
        this.observacao = observacao;
    }

    public void adicionarItem(ItemVenda item) {
        itens.add(item);
        valorTotal += item.getPrecoTotal();
    }

    public void removerItem(ItemVenda item) {
        if (itens.remove(item)) {
            valorTotal -= item.getPrecoTotal();
        }
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
}
