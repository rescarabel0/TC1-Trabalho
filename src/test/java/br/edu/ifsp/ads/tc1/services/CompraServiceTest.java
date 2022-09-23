package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Cliente;
import br.edu.ifsp.ads.tc1.domains.Compra;
import br.edu.ifsp.ads.tc1.domains.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CompraServiceTest {
    private CompraService compraService;
    private Cliente cliente;
    private Produto produto;
    private Compra compra;

    @BeforeEach
    void setUp() {
        compraService = new CompraService();
        cliente = new Cliente(
                "123.456.789-10",
                "Fulano",
                Date.from(Instant.now()),
                "Masculino",
                4280F,
                List.of("fulano@email.com", "fulano1@email.com"),
                List.of("(00)12345-6789")
        );
        produto = new Produto(0,
                "teste",
                1,
                1F,
                1,
                1,
                1F,
                1F,
                Date.from(Instant.now()));
        compra = new Compra(0, cliente, produto);
    }

    @Test
    @DisplayName("Lista Todos retorna vazio")
    void listaTodosVazio() {
        assertTrue(compraService.listaTodos().isEmpty());
    }

    @Test
    @DisplayName("Lista Todos retorna com itens após salvar")
    void listaTodos() throws Exception {
        compraService.salvar(compra);
        assertEquals(Map.of(0, compra), compraService.listaTodos());
    }

    @Test
    @DisplayName("Lista um retorna nulo")
    void listaUmNulo() {
        assertNull(compraService.listaUm(0));
    }

    @Test
    @DisplayName("Lista um retorna compra após salvar")
    void listaUm() throws Exception {
        compraService.salvar(compra);
        assertEquals(compra, compraService.listaUm(0));
    }

    @Test
    @DisplayName("Exclui compra")
    void excluir() {
        compraService.salvar(compra);
        assertEquals(compra, compraService.listaUm(0));
        compraService.excluir(0);
        assertNull(compraService.listaUm(0));
    }
}