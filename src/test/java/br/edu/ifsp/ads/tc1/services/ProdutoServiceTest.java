package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoServiceTest {
    private ProdutoService produtoService;
    private Produto produto;

    @BeforeEach
    void setUp() {
        produtoService = new ProdutoService();
        produto = new Produto(0,
                "teste",
                1,
                1F,
                1,
                1,
                1F,
                1F,
                Date.from(Instant.now()));
    }

    @Test
    @DisplayName("Mapa está vazio")
    void listaTodosVazia() {
        assertTrue(produtoService.listaTodos().isEmpty());
    }

    @Test
    @DisplayName("Mapa contém produtos após salvar")
    void salvaEListaTodos() {
        produtoService.salvar(produto);
        assertEquals(Map.of(0, produto), produtoService.listaTodos());
    }

    @Test
    @DisplayName("Não encontra produto")
    void listaUmNull() {
        assertNull(produtoService.listaUm(0));
    }

    @Test
    @DisplayName("Encontra um produto por código após salvar")
    void listaUm() {
        produtoService.salvar(produto);
        assertEquals(produto, produtoService.listaUm(0));
    }

    @Test
    @DisplayName("Produto foi atualizado com sucesso com uso de Sets")
    void atualizar() {
        var now = java.util.Date.from(Instant.now());
        produtoService.salvar(produto);

        produto.setDescricao("editado");
        produto.setPeso(2F);
        produto.setTamanho(2);
        produto.setAltura(2);
        produto.setPreco(2F);
        produto.setDesconto(2F);
        produto.setDataDeValidade(now);

        produtoService.atualizar(produto);
        var produtoAtualizado = produtoService.listaUm(0);

        assertAll("Teste Gets",
                () -> assertEquals("editado", produtoAtualizado.getDescricao()),
                () -> assertEquals(2, produtoAtualizado.getTamanho()),
                () -> assertEquals(2F, produtoAtualizado.getPeso()),
                () -> assertEquals(2, produtoAtualizado.getAltura()),
                () -> assertEquals(2, produtoAtualizado.getPreco()),
                () -> assertEquals(2F, produtoAtualizado.getDesconto()),
                () -> assertEquals(now, produtoAtualizado.getDataDeValidade())
        );
    }

    @Test
    @DisplayName("Produto excluído com sucesso")
    void excluir() {
        produtoService.salvar(produto);
        assertAll("Produto foi salvo e depois excluído",
                () -> assertNotNull(produtoService.listaUm(0)),
                () -> {
                    produtoService.excluir(0);
                    assertNull(produtoService.listaUm(0));
                });
    }
}