public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Java");

        banco.cadastrarCliente("Aristeu", "335471258-69");
        banco.cadastrarCliente("Juma", "320347125-69");

        banco.listarClientes();

        System.out.println();

        banco.abrirConta("335471258-69", 1);
        banco.abrirConta("320347125-69", 2);

        System.out.println();

        banco.depositar(2000, 2500.0);
        System.out.println();
        banco.sacar(2000, 1000.0);
        System.out.println();
        banco.transferir(2000, 1000,500.0);
        System.out.println();

        System.out.println();
        banco.imprimirExtrato(2000);
        banco.imprimirExtrato(1000);
    }
}
