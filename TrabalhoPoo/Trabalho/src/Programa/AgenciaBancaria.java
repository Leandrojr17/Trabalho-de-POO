package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("-------------------------------------------");
        System.out.println("--------Bem vindo a Agência Bancária-------");
        System.out.println("-------------------------------------------");
        System.out.println("----Selecione uma operação que deseja------");
        System.out.println("-------------------------------------------");
        System.out.println("*|         Opção 1 - Criar Conta         |*");
        System.out.println("*|         Opção 2 - Depositar           |*");
        System.out.println("*|         Opção 3 - Sacar               |*");
        System.out.println("*|         Opção 4 - Transferir          |*");
        System.out.println("*|         Opção 5 - Listar              |*");
        System.out.println("*|         Opção 6 - Sair                |*");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1 -> criarConta();
            case 2 -> depositar();
            case 3 -> sacar();
            case 4 -> transferir();
            case 5 -> listarContas();
            case 6 -> {
                System.out.println("Valeu por usar a agência bancária.");
                System.exit(0);
            }
            default -> {
                System.out.println("Operação Inválida!!");
                operacoes();
            }
        }
    }

    public static void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        System.out.println("\nTipo de Conta (1 - Corrente, 2 - Poupança): ");
        int tipoConta = input.nextInt();
        Conta conta;

        if (tipoConta == 1) {
            conta = new ContaCorrente(pessoa);
        } else if (tipoConta == 2) {
            conta = new ContaPoupanca(pessoa);
        } else {
            System.out.println("Tipo de conta inválido!");
            operacoes();
            return;
        }

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!!");

        operacoes();
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;

        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Iai meu nobre, qual o número da conta?");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Beleza meu brother, qual o valor que você deseja depositar?");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Pronto caba véi, depositado com sucesso!!");
        } else {
            System.out.println("Vish, conta não encontrada para depositar!!");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Iai meu nobre, qual o número da conta?");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Qual o valor que deseja sacar?");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Tá aqui teu dinheiro");
        } else {
            System.out.println("Vish, conta não encontrada para sacar!!");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta de quem vai mandar o valor: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta da conta de quem vai receber o valor: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor da transferência?");
                double valor = input.nextDouble();

                contaRemetente.transferir(valor, contaDestinatario);
            }
        }
        operacoes();
    }

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }

        operacoes();
    }
}
