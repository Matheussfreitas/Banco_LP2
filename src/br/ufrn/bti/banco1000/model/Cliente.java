
package br.ufrn.bti.banco1000.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Conta conta;

    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public boolean autenticar(int senha) {
        return conta.getSenha() == senha;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return this.conta;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
}
