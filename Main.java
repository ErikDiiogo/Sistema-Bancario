package Java.Projetos.SistemaBancario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("=== Sistema Bancário ===");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver Extrato");
            System.out.println("0 - Sair");

            System.out.println("Digite uma opção: ");
            opcao = scanner.nextInt();

            if ( opcao == 1){
                System.out.println("Nome do Titular: ");
                String titular = scanner.next();

                System.out.println("Saldo inicial: ");
                double saldo = scanner.nextDouble();

                try {
                    Conta conta = new Conta(titular, saldo);
                    banco.adicionarConta(conta);
                    System.out.println("Conta criada com sucesso!");
                } catch(SaldoInsuficienteException erro) {
                    System.out.println(erro.getMessage());
                }

            } else if (opcao == 2) {
                System.out.println("Nome do titular: ");
                String nomeBuscar = scanner.next();
                Conta conta = banco.buscarConta(nomeBuscar);

                if ( conta == null){
                    System.out.println("Conta não encontrada");
                } else {
                    System.out.println("Valor do deposito: ");
                    double valor = scanner.nextDouble();

                    try {
                    conta.depositar(valor);
                    System.out.println("Deposito realizado com sucesso!");
                } catch (IllegalArgumentException erro) {
                    System.out.println(erro.getMessage());
                }
                    }
            } else if(opcao == 3){

                System.out.println("Nome do titular: ");
                String nomeBuscar = scanner.next();
                Conta conta = banco.buscarConta(nomeBuscar);

                if (conta == null ) {
                       System.out.println("Conta não encontrada");
                } else {
                    System.out.println("Valor para Saque: ");
                    double valor = scanner.nextDouble();

                    try {
                        conta.sacar(valor);
                        System.out.println("Saque realizado com sucesso!");
                    } catch (SaldoInsuficienteException erro) {
                        System.out.println(erro.getMessage());
                    }    

            } 
            } else if (opcao == 4) {
                System.out.println("Titular:  ");
                String nomeBuscar = scanner.next();

                Conta conta  = banco.buscarConta(nomeBuscar);

                if(conta == null){
                    System.out.println("Conta não encontrada");
                } else {
                    conta.exibirExtrato();
                }
            }
            
        } while(opcao != 0);

        scanner.close();
    
}

}
