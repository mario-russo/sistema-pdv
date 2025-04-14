package br.com.mario.model;

import br.com.mario.model.util.EstoqueException;

public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private Double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String descricao, Double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Produto() {

    }

    void atualizaEStoque(int quantidade){
        if(quantidadeEstoque < quantidade ){
            throw new EstoqueException("Estoque baixo para o produto" + nome);
        }

        quantidadeEstoque -= quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (codigo != other.codigo)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Produto [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
                + ", quantidadeEstoque=" + quantidadeEstoque + "]";
    }

}
