package Programa;

import Utilitarios.Utils;

public abstract class Conta {
    private static int contadorDeContas = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0.0;

    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    public Pessoa setPessoa(Pessoa pessoa){
        return pessoa;
    }
    public double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public abstract void transferir(double valor, Conta contaParaDeposito);

    @Override
    public String toString() {
        return "\nNúmero da Conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getCpf() +
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }
}
