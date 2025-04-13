package br.com.mario.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProdutoTest {

    Produto produto = new Produto();

    @Test
    void testa_criacao_da_classe(){
        produto.setNome("café");
        assertEquals("café", produto.getNome());;
    }
}
