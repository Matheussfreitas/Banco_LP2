package br.ufrn.bti.banco1000.view;

import br.ufrn.bti.banco1000.model.Cliente;

import java.util.Scanner;

public class Menu {
    private Banco banco;
    private Scanner scanner;

    public Menu() {
        this.banco = new Banco();
        this.scanner = new Scanner(System.in);
    }

    public void iniciarMenu() {
        boolean sair = false;
        while (!sair) {
            System.out.println("\n--- Banco do IMD ---");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Verificar Saldo");
            System.out.println("5. Transferir");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> criarUsuario(banco, scanner);
                case 2 -> login(banco, scanner);
                case 3 -> logout(banco);
                case 4 -> verificarSaldo(banco);
                case 5 -> transferir(banco, scanner);
                case 6 -> sair = true;
                default -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static void criarUsuario(Banco banco, Scanner scanner) {
        System.out.println("\n--- Criar Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Telefone: ");
        String telefone = scanner.next();
        System.out.print("Senha: ");
        int senha = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();

        banco.criarUsuario(nome, cpf, email, telefone, senha, saldo);
        System.out.println("Usuário criado com sucesso!");
    }

    private static void login(Banco banco, Scanner scanner) {
        System.out.println("\n--- Login ---");
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Senha: ");
        int senha = scanner.nextInt();

        if (banco.login(cpf, senha)) {
            System.out.println("Login realizado com sucesso!");
        } else {
            System.out.println("CPF ou senha incorretos.");
        }
    }

    private static void logout(Banco banco) {
        banco.logout();
        System.out.println("Logout realizado com sucesso.");
    }

    private static void verificarSaldo(Banco banco) {
        Cliente usuarioLogado = banco.getUsuarioLogado();
        if (usuarioLogado != null) {
            System.out.println("Saldo atual: R$ " + usuarioLogado.getConta().getSaldo());
        } else {
            System.out.println("Nenhum usuário está logado.");
        }
    }

    private static void transferir(Banco banco, Scanner scanner) {
        System.out.println("\n--- Transferência ---");
        System.out.print("CPF do destinatário: ");
        String cpf = scanner.next();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        try {
            if (banco.transferir(cpf, valor)) {
                System.out.println("Transferência realizada com sucesso!");
            } else {
                System.out.println("Destinatário não encontrado.");
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
