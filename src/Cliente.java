import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Conta> contas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        contas = new ArrayList<>();
    }

    public void abrirContaCorrente(){
        this.contas.add(new ContaCorrente(this));
    }

    public void abrirContaPoupanca(){
        this.contas.add(new ContaPoupanca(this));
    }

    @Override
    public String toString() {
        return String.format("%s: %s", nome, cpf);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Conta getConta(int numero){
        Conta contaCliente;

        for (Conta conta:
             contas) {
            if (numero == conta.getConta())
                return conta;
        }

        return null;
    }
}
