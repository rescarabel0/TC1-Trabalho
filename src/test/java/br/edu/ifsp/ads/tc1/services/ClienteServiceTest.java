package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {
    private ClienteService clienteService;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        clienteService = new ClienteService();
        cliente = new Cliente(
                "123.456.789-10",
                "Fulano",
                Date.from(Instant.now()),
                "Masculino",
                4280F,
                List.of("fulano@email.com", "fulano1@email.com"),
                List.of("(00)12345-6789")
        );
    }

    @Test
    @DisplayName("Lista Todos retorna vazio")
    void listaTodosVazio() {
        assertTrue(clienteService.listaTodos().isEmpty());
    }

    @Test
    @DisplayName("Lista Todos retorna com itens após salvar")
    void listaTodos() throws Exception {
        clienteService.salvar(cliente);
        assertEquals(Map.of("123.456.789-10", cliente), clienteService.listaTodos());
    }

    @Test
    @DisplayName("Lista um retorna nulo")
    void listaUmNulo() {
        assertNull(clienteService.listaUm(""));
    }

    @Test
    @DisplayName("Lista um retorna cliente após salvar")
    void listaUm() throws Exception {
        clienteService.salvar(cliente);
        assertEquals(cliente, clienteService.listaUm("123.456.789-10"));
    }

    @Test
    @DisplayName("Erro ao salvar CPF inválido")
    void erroSalvarCPFInvalido() {
        var clienteCpfInvalido = new Cliente(
                "12345678910",
                null,
                null,
                null,
                null,
                null,
                null
        );
        assertThrows(Exception.class, () -> clienteService.salvar(clienteCpfInvalido));
    }

    @Test
    @DisplayName("Erro ao salvar Telefone inválido")
    void erroSalvarTelefoneInvalido() {
        var clienteTelefoneInvalido = new Cliente(
                "123.456.789-10",
                null,
                null,
                null,
                null,
                null,
                List.of("11123456789")
        );
        assertThrows(Exception.class, () -> clienteService.salvar(clienteTelefoneInvalido));
    }

    @Test
    @DisplayName("Atualiza Cliente")
    @Order(0)
    void atualizar() throws Exception {
        clienteService.salvar(cliente);
        var date = java.util.Date.from(Instant.now());

        cliente.setNome("Editado");
        cliente.setSexo("Feminino");
        cliente.setSalario(1000F);
        cliente.setEmails(List.of());
        cliente.setTelefones(List.of());
        cliente.setDataDeNascimento(date);

        clienteService.atualizar(cliente);
        var clienteAtualizado = clienteService.listaUm("123.456.789-10");

        assertAll("Teste gets pós atualizar",
                () -> assertEquals("123.456.789-10", clienteAtualizado.getCpf()),
                () -> assertEquals("Editado", clienteAtualizado.getNome()),
                () -> assertEquals("Feminino", clienteAtualizado.getSexo()),
                () -> assertEquals(List.of(), clienteAtualizado.getEmails()),
                () -> assertEquals(List.of(), clienteAtualizado.getTelefones()),
                () -> assertEquals(date, clienteAtualizado.getDataDeNascimento())
        );
    }

    @Test
    @DisplayName("Excluir usuário")
    void excluir() throws Exception {
        clienteService.salvar(cliente);
        assertEquals(cliente, clienteService.listaUm("123.456.789-10"));
        clienteService.excluir("123.456.789-10");
        assertNull(clienteService.listaUm("123.456.789-10"));
    }
}