package br.com.mario.model;

public  class ProdutoFactory {

    public static final String  nome = "feijão"; 
    public static final String descricao = "produto";
    public static final int quantidade = 5;
    public static final int id = 1;
    public static final Double preco = 1.0;
    
    public static Produto produtoFactory(){
        
        return new Produto(nome, descricao, preco, quantidade);
    }
}
