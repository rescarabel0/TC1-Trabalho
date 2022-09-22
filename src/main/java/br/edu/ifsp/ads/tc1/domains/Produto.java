package br.edu.ifsp.ads.tc1.domains;

import java.util.Date;
import java.util.Objects;

public class Produto {
    private Integer codigo;
    private String descricao;
    private Integer tamanho;
    private Float peso;
    private Integer altura;
    private Integer largura;
    private Float preco;
    private Float desconto;
    private Date dataDeValidade;

    public Produto(Integer codigo, String descricao, Integer tamanho, Float peso, Integer altura, Integer largura, Float preco, Float desconto, Date dataDeValidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.peso = peso;
        this.altura = altura;
        this.largura = largura;
        this.preco = preco;
        this.desconto = desconto;
        this.dataDeValidade = dataDeValidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Float getDesconto() {
        return desconto;
    }

    public void setDesconto(Float desconto) {
        this.desconto = desconto;
    }

    public Date getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(Date dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                "\n descricao='" + descricao + '\'' +
                "\n tamanho=" + tamanho +
                "\n peso=" + peso +
                "\n altura=" + altura +
                "\n largura=" + largura +
                "\n preco=" + preco +
                "\n desconto=" + desconto +
                "\n dataDeValidade=" + dataDeValidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(codigo, produto.codigo) && Objects.equals(descricao, produto.descricao) && Objects.equals(tamanho, produto.tamanho) && Objects.equals(peso, produto.peso) && Objects.equals(altura, produto.altura) && Objects.equals(largura, produto.largura) && Objects.equals(preco, produto.preco) && Objects.equals(desconto, produto.desconto) && Objects.equals(dataDeValidade, produto.dataDeValidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descricao, tamanho, peso, altura, largura, preco, desconto, dataDeValidade);
    }
}
