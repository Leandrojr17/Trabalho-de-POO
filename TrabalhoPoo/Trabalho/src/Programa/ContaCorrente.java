package Programa;

public class ContaCorrente extends Conta {
    public ContaCorrente(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu valor foi depositado com sucesso, meu parceiro!");
        } else {
            System.out.println("Mano, não deu certo depositar seu dinheiro!");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque tirado de boas, meu brother!");
        } else {
            System.out.println("Mano, não deu certo tirar teu dinheiro!");
        }
    }

    @Override
    public void transferir(double valor, Conta contaParaDeposito) {
        if (valor > 0 && getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
            System.out.println("Transferência realizada, meu brother!!!");
        } else {
            System.out.println("Mano, não deu certo a transferência!!");
        }
    }
}
