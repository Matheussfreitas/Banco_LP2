
package br.ufrn.bti.banco1000.view;

import br.ufrn.bti.banco1000.model.Cliente;
import br.ufrn.bti.banco1000.model.Conta;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private Cliente usuarioLogado;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.usuarioLogado = null;
    }

    public void criarUsuario(String nome, String cpf, String email, String telefone, int senha, double saldo) {
        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        cliente.setConta(new Conta(nome, 1234, clientes.size() + 1, "Corrente", senha, saldo));
        clientes.add(cliente);
    }

    public boolean login(String cpf, int senha) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf) && cliente.autenticar(senha)) {
                this.usuarioLogado = cliente;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        this.usuarioLogado = null;
    }

    public Cliente getUsuarioLogado() {
        return this.usuarioLogado;
    }

    public Cliente buscarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean transferir(String cpfDestinatario, double valor) {
        if (usuarioLogado == null) {
            throw new IllegalStateException("Nenhum usuário está logado.");
        }
        Cliente destinatario = buscarCliente(cpfDestinatario);
        if (destinatario == null) {
            return false;
        }
        return usuarioLogado.getConta().transferir(destinatario.getConta(), valor);
    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
}
