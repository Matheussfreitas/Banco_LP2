
package br.ufrn.bti.banco1000.model;

public class Conta {
    private String titular;
    private int agencia;
    private int numero;
    private String tipo;
    private int senha;
    private double saldo;

    public Conta(String titular, int agencia, int numero, String tipo, int senha, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.tipo = tipo;
        this.senha = senha;
        this.saldo = saldo;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor <= 0 || valor > this.saldo) {
            return false;
        }
        this.saldo -= valor;
        destino.saldo += valor;
        return true;
    }

    public int getSenha() {
        return this.senha;
    }

    public double getSaldo() {
        return this.saldo;
    }
}
