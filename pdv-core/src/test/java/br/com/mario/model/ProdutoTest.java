package br.com.mario.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.mario.model.util.EstoqueException;

@ExtendWith(MockitoExtension.class)
public class ProdutoTest {

    Produto produto = ProdutoFactory.produtoFactory();

    @Test
    void testa_criacao_da_classe() {
        assertEquals(ProdutoFactory.nome, produto.getNome());
    }

    @Test
    @DisplayName("Retorna erro quando a quantidade é mais baixa que o estoque!")
    void retorna_erro_produto_estoque_baixo() {
        produto.setQuantidadeEstoque(5);

        assertThrows(EstoqueException.class, () -> {
            produto.atualizaEStoque(6);
        });
    }

    @Test
    void atualiza_estoque() {
        int valorEsperado = 1;
        produto.atualizaEStoque(4);
        assertEquals(valorEsperado, produto.getQuantidadeEstoque());
    }
}
