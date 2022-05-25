public class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    protected int agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        System.out.printf("%.2f scado da conta %d%n", valor, this.conta);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.printf("%.2f depositado para conta %d%n", valor, this.conta);
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        contaDestino.depositar(valor);
        this.sacar(valor);
        System.out.printf("%.2f transferido para conta %d%n", valor, contaDestino.getConta());
    }

    @Override
    public void imprimirExtrato() {
        System.out.printf("Cliente: %s\n", this.cliente.getNome());
        System.out.printf("CPF: %s\n", this.cliente.getCpf());
        System.out.printf("Agência: %d\n", this.agencia);
        System.out.printf("Conta: %d\n", this.conta);
        System.out.printf("Saldo: %.2f\n", this.saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }


}
