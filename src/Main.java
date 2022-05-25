import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Banco banco = new Banco("Banco Java");

    public static void main(String[] args) {

        boolean quit = false;

        System.out.printf("Bem-vindo(a) ao %s%n", banco.getNome());

        while(!quit){
            listarOpcoes();
            String opcao = scanner.nextLine();

            switch (opcao){
                case "1":
                    cadastrarCliente();
                    break;
                case "2":
                    listarClientes();
                    break;
                case "3":
                    abrirConta();
                    break;
                case "4":
                    fazerTransacao();
                    break;
                case "0":
                    quit = true;
                    break;
            }
        }
    }

    public static void listarOpcoes(){
        System.out.println();
        System.out.println("Digite: ");
        System.out.println("1 - cadastrar cliente");
        System.out.println("2 - listar clientes");
        System.out.println("3 - abrir conta");
        System.out.println("4 - fazer alguma operação");
        System.out.println("0 - sair");
    }

    public static void cadastrarCliente(){
        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        banco.registrarCliente(nome, cpf);
        System.out.printf("O %s agradece a preferência, %s!%n", banco.getNome(), nome);
        System.out.println();
    }

    public static void listarClientes(){
        banco.listarClientes();
        System.out.println();
    }

    public static void abrirConta(){
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite: ");
        System.out.println("1 - conta corrente");
        System.out.println("2 - conta poupança");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();
        banco.abrirConta(cpf, tipoConta);
        System.out.println();
    }

    public static void fazerTransacao(){
        System.out.println("Digite o número da conta: ");
        int conta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite: ");
        System.out.println("1 - sacar");
        System.out.println("2 - depositar");
        System.out.println("3 - transferir");
        System.out.println("4 - imprimir extrato");

        String opcao = scanner.nextLine();

        switch (opcao){
            case "1":
                System.out.println("Digite o valor que deseja sacar:");
                double valorSaque = scanner.nextDouble();
                scanner.nextLine();
                banco.sacar(conta, valorSaque);
                break;
            case "2":
                System.out.println("Digite o valor que deseja depositar:");
                double valorDeposito = scanner.nextDouble();
                scanner.nextLine();
                banco.depositar(conta, valorDeposito);
                break;
            case "3":
                System.out.println("Digite o valor que deseja transferir:");
                double valorTransferencia = scanner.nextDouble();
                System.out.println("Digite o número da conta de destino: ");
                int contaDestino = scanner.nextInt();
                scanner.nextLine();
                banco.transferir(conta, contaDestino, valorTransferencia);
                break;
            case "4":
                banco.imprimirExtrato(conta);
                break;
        }
    }
}
