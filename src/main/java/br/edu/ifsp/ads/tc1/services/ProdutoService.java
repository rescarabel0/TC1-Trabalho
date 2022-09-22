package br.edu.ifsp.ads.tc1.services;

import br.edu.ifsp.ads.tc1.domains.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoService implements DAOService<Produto, Integer> {
    private final Map<Integer, Produto> produtos = new HashMap<>();

    @Override
    public Map<Integer, Produto> listaTodos() {
        return produtos;
    }

    @Override
    public Produto listaUm(Integer integer) {
        return produtos.get(integer);
    }

    @Override
    public void salvar(Produto produto) {
        var cod = produto.getCodigo();
        if (produtos.get(cod) != null) {
            System.out.println("Erro!\n");
            return;
        }
        produtos.put(cod, produto);
    }

    @Override
    public void atualizar(Produto produto) {
        var cod = produto.getCodigo();
        if (produtos.get(cod) == null) {
            System.out.println("Erro!\n");
            return;
        }
        produtos.put(cod, produto);
    }

    @Override
    public void excluir(Integer integer) {
        if (produtos.get(integer) == null) {
            System.out.println("Erro!\n");
            return;
        }
        produtos.remove(integer);
    }
}
