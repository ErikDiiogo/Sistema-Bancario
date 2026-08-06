package Java.Projetos.SistemaBancario;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta){
        contas.add(conta);
        
    }
    public void listarContas(){
        for (Conta c : contas) {
            System.out.println(c.getTitular() + " | e o seu saldo é de R$ " + c.getSaldo());
        }
    }
    public Conta buscarConta(String titular) {
        for (Conta c : contas) {
            if (c.getTitular().equalsIgnoreCase(titular)){
                return c;
            }
        }
        return null;
    }
    }