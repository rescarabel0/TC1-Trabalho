package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ClienteService implements DAOService<Cliente, String> {
    private final Map<String, Cliente> clientes = new HashMap<>();

    @Override
    public Map<String, Cliente> listaTodos() {
        return clientes;
    }

    @Override
    public Cliente listaUm(String s) {
        return clientes.get(s);
    }

    @Override
    public void salvar(Cliente cliente) throws Exception {
        var cpf = cliente.getCpf();
        if (clientes.get(cpf) != null) {
            System.out.println("Erro!\n");
            return;
        }
        if (!Pattern.matches("([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})", cpf)) {
            System.out.printf("CPF [%s] inválido!\n", cpf);
            throw new Exception();
        }
        for (String telefone : cliente.getTelefones()) {
            if (!Pattern.matches("(\\([0-9]{2}\\)[0-9]{5}-[0-9]{4})", telefone)) {
                System.out.printf("Telefone [%s] inválido!\n", telefone);
                throw new Exception();
            }
        }
        clientes.put(cpf, cliente);
    }

    @Override
    public void atualizar(Cliente cliente) throws Exception {
        var cpf = cliente.getCpf();
        if (clientes.get(cpf) == null) {
            System.out.println("Erro!\n");
            return;
        }
        if (!Pattern.matches("([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})", cpf)) {
            System.out.printf("CPF [%s] inválido!\n", cpf);
            throw new Exception();
        }
        for (String telefone : cliente.getTelefones()) {
            if (!Pattern.matches("(\\([0-9]{2}\\)[0-9]{5}-[0-9]{4})", telefone)) {
                System.out.printf("Telefone [%s] inválido!\n", telefone);
                throw new Exception();
            }
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
