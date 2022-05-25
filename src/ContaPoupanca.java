public class ContaPoupanca extends Conta {
    private static int SEQUENCIAL = 2000;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        super.conta = SEQUENCIAL++;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("------ Conta Poupança------ ");
        super.imprimirExtrato();
    }
}
