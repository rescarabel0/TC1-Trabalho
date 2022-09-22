package br.edu.ifsp.ads.tc1.domains;

import java.util.Objects;

public class Compra {
    private int id;
    private Cliente cliente;
    private Produto produto;

    public Compra(int id, Cliente cliente, Produto produto) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                "\n cliente=" + cliente +
                "\n produto=" + produto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return id == compra.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
