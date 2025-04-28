package br.com.mario.model;

public class ItemVenda {
    private Long id;
    private String produtoNome;
    private Integer quantidade;
    private Double precoUnitario;
    private Double precoTotal;

    public ItemVenda() {
    }

    public ItemVenda(Long id, String produtoNome, Integer quantidade, Double precoUnitario) {
        this.id = id;
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = quantidade * precoUnitario;
    }
    public ItemVenda(String produtoNome, Integer quantidade, Double precoUnitario) {
        
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = quantidade * precoUnitario;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProdutoNome() { return produtoNome; }
    public void setProdutoNome(String produtoNome) { this.produtoNome = produtoNome; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { 
        this.quantidade = quantidade; 
        recalcularPrecoTotal();
    }

    public Double getPrecoUnitario() { return precoUnitario; }
    public void setPrecoUnitario(Double precoUnitario) { 
        this.precoUnitario = precoUnitario; 
        recalcularPrecoTotal();
    }

    public Double getPrecoTotal() { return precoTotal; }
    
    private void recalcularPrecoTotal() {
        if (quantidade != null && precoUnitario != null) {
            this.precoTotal = quantidade * precoUnitario;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        ItemVenda other = (ItemVenda) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
