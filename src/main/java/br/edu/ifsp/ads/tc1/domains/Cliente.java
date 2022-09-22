package br.edu.ifsp.ads.tc1.domains;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente {
    private String cpf;
    private String nome;
    private Date dataDeNascimento;
    private String sexo;
    private Float salario;
    private List<String> emails;
    private List<String> telefones;

    public Cliente(String cpf, String nome, Date dataDeNascimento, String sexo, Float salario, List<String> emails, List<String> telefones) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.salario = salario;
        this.emails = emails;
        this.telefones = telefones;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<String> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                "\n nome='" + nome + '\'' +
                "\n dataDeNascimento=" + dataDeNascimento +
                "\n sexo='" + sexo + '\'' +
                "\n salario=" + salario +
                "\n emails=" + emails +
                "\n telefones=" + telefones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
