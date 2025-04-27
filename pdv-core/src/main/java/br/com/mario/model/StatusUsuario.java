package br.com.mario.model;

public enum StatusUsuario {
    ATIVO("ativo", "Ativo"),
    INATIVO("inativo", "Inativo"),
    BLOQUEADO("bloqueado", "Bloqueado");

    private final String valor;
    private final String descricao;

    StatusUsuario(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

}
