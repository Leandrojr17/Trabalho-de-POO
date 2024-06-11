package Programa;

import java.util.Scanner;

public class OperacoesFinanceiras implements OperacoesFinanceirasInterface {
    static Scanner input = new Scanner(System.in);

    @Override
    public void depositar() {
        System.out.println("Iai meu nobre, qual o número da conta?");
        int numeroConta = input.nextInt();
        Conta conta = GerenciamentoContas.encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Beleza meu brother, qual o valor que você deseja depositar?");
            double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Pronto caba véi, depositado com sucesso!!");
        } else {
            System.out.println("Vish, conta não encontrada para depositar!!");
        }
    }

    @Override
    public void sacar() {
        System.out.println("Iai meu nobre, qual o número da conta?");
        int numeroConta = input.nextInt();
        Conta conta = GerenciamentoContas.encontrarConta(numeroConta);
        if (conta != null) {
            System.out.println("Qual o valor que deseja sacar?");
            double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            System.out.println("Tá aqui teu dinheiro");
        } else {
            System.out.println("Vish, conta não encontrada para sacar!!");
        }
    }

    @Override
    public void transferir() {
        System.out.println("Número da conta de quem vai mandar o valor: ");
        int numeroContaRemetente = input.nextInt();
        Conta contaRemetente = GerenciamentoContas.encontrarConta(numeroContaRemetente);
        if (contaRemetente != null) {
            System.out.println("Número da conta da conta de quem vai receber o valor: ");
            int numeroContaDestinatario = input.nextInt();
            Conta contaDestinatario = GerenciamentoContas.encontrarConta(numeroContaDestinatario);
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
}
