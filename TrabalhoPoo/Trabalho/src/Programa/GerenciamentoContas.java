package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoContas implements GerenciamentoContasInterface {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias = new ArrayList<>();

    @Override
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

    @Override
    public void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas.");
        }
    }

    public static Conta encontrarConta(int numeroConta) {
        for (Conta conta : contasBancarias) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }
        return null;
    }
}
