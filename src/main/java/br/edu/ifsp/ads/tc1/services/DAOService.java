package br.edu.ifsp.ads.tc1.services;

import java.util.Map;

public interface DAOService<T, K> {
    Map<K, T> listaTodos();

    T listaUm(K k);

    void salvar(T t) throws Exception;

    void atualizar(T t) throws Exception;

    void excluir(K k);
}
