package br.com.mario.model;

public enum Permissao {
    ADMIN("admin", "Administrador"),
    GERENTE("gerente", "Gerente"),
    VENDEDOR("vendedor", "Vendedor"),
    CAIXA("caixa", "Caixa");

    private final String valor;
    private final String descricao;

    Permissao(String valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Permissao fromString(String valor) {
        for (Permissao p : Permissao.values()) {
            if (p.valor.equalsIgnoreCase(valor)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Permissão inválida: " + valor);
    }
}
