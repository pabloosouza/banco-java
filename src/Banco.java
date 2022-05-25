import java.util.ArrayList;
import java.util.List;

public class Banco {
    public String nome;
    public List<Cliente> clientes;

    public Banco(String nome) {
        this.nome = nome;
        clientes = new ArrayList<>();
    }

    public void registrarCliente(String nome, String cpf){
        Cliente cliente = new Cliente(nome, cpf);
        clientes.add(cliente);
    }

    public void listarClientes(){
        System.out.printf("Clientes %s: %n", nome);
        for (Cliente cliente:
                clientes) {
            System.out.println(cliente);
        }
    }

    public void imprimirExtrato(int numero){
        Conta conta = encontrarConta(numero);

        if (conta == null){
            System.out.printf("Conta com número %d não encontrada.%n", numero);
            return;
        }

        conta.imprimirExtrato();
    }

    public void sacar(int numero, double valor){
        Conta conta = encontrarConta(numero);

        if (conta == null){
            System.out.printf("Conta com número %d não encontrada.%n", numero);
            return;
        }

        conta.sacar(valor);
    }

    public void depositar(int numero, double valor){
        Conta conta = encontrarConta(numero);

        if (conta == null){
            System.out.printf("Conta com número %d não encontrada.%n", numero);
            return;
        }

        conta.depositar(valor);
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor){
        Conta contaOrigem = encontrarConta(numeroOrigem);
        Conta contaDestino = encontrarConta(numeroDestino);

        if (contaOrigem == null){
            return;
        }

        if (contaDestino == null){
            return;
        }

        contaOrigem.transferir(valor, contaDestino);
    }
    public void abrirConta(String cpf, int tipoConta){
        Cliente cliente = encontrarCliente(cpf);

        if (cliente == null){
            return;
        }

        int numero;

        switch (tipoConta){
            case 1:
                 cliente.abrirContaCorrente();
                break;
            case 2:
                cliente.abrirContaPoupanca();
                break;
            default:
                System.out.println("Tipo de conta não existente.");
        }

    }

    private Cliente encontrarCliente(String cpf){

        for (Cliente cliente:
                clientes) {
            if (cliente.getCpf().equals(cpf))
                    return cliente;
        }

        System.out.printf("Cliente com CPF %s não encontrado.", cpf);
        return null;
    }

    private Conta encontrarConta(int numero){

        for (Cliente cliente: clientes) {
            if (cliente.getConta(numero) != null)
                return cliente.getConta(numero);
        }

        System.out.printf("Conta com número %d não encontrada.", numero);
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
