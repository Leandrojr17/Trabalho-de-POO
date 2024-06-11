package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class OperacoesBancarias implements OperacoesFinanceirasInterface {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias = new ArrayList<>();

    public void criarConta() {
        System.out.println("\nNome: ");
        String nome = input.next();
        System.out.println("\nCPF: ");
        String cpf = input.next();
        System.out.println("\nEmail: ");
        String email = input.next();
        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa) {
            @Override
            public void depositar(double valor) {

            }

            @Override
            public void sacar(double valor) {

            }

            @Override
            public void transferir(double valor, Conta contaParaDeposito) {

            }
        };
        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!!");
    }

    public void depositar() {
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
    }

    public void sacar() {
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
    }

    public void transferir() {
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
                System.out.println("Transferência realizada, meu brother!!!");
            } else {
                System.out.println("Mano, não deu certo a transferência!!");
            }
        } else {
            System.out.println("Mano, não deu certo a transferência!!");
        }
    }

    public void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }
    }

    private Conta encontrarConta(int numeroConta){
        for (Conta conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
