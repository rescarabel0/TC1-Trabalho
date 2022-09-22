package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Compra;

import java.util.HashMap;
import java.util.Map;

public class CompraService implements DAOService<Compra, Integer> {
    private static final Map<Integer, Compra> compras = new HashMap<>();

    @Override
    public Map<Integer, Compra> listaTodos() {
        return compras;
    }

    @Override
    public Compra listaUm(Integer integer) {
        return compras.get(integer);
    }

    @Override
    public void salvar(Compra compra) {
        var id = compra.getId();
        if (compras.get(id) != null) {
            System.out.println("Erro!\n");
            return;
        }
        compras.put(id, compra);
    }

    @Override
    public void atualizar(Compra compra) {
        var id = compra.getId();
        if (compras.get(id) == null) {
            System.out.println("Erro!\n");
            return;
        }
        compras.put(id, compra);
    }

    @Override
    public void excluir(Integer integer) {
        if (compras.get(integer) == null) {
            System.out.println("Erro!\n");
            return;
        }
        compras.remove(integer);
    }
}
