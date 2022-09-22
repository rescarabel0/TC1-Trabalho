package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteService implements DAOService<Cliente, String> {
    private static final Map<String, Cliente> clientes = new HashMap<>();

    @Override
    public Map<String, Cliente> listaTodos() {
        return clientes;
    }

    @Override
    public Cliente listaUm(String s) {
        return clientes.get(s);
    }

    @Override
    public void salvar(Cliente cliente) {
        var cpf = cliente.getCpf();
        if (clientes.get(cpf) != null) {
            System.out.println("Erro!\n");
            return;
        }
        clientes.put(cpf, cliente);
    }

    @Override
    public void atualizar(Cliente cliente) {
        var cpf = cliente.getCpf();
        if (clientes.get(cpf) == null) {
            System.out.println("Erro!\n");
            return;
        }
        clientes.put(cpf, cliente);
    }

    @Override
    public void excluir(String s) {
        if (clientes.get(s) == null) {
            System.out.println("Erro!\n");
            return;
        }
        clientes.remove(s);
    }
}
