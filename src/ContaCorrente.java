public class ContaCorrente extends Conta {
    private static int SEQUENCIAL = 1000;

    public ContaCorrente(Cliente cliente){
        super(cliente);
        super.conta = SEQUENCIAL++;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("------ Conta Corrente------ ");
        super.imprimirExtrato();
    }
}
