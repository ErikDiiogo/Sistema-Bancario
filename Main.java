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
            System.out.println("5 - Adicionar Rendimento");
            System.out.println("0 - Sair");

            System.out.println("Digite uma opção: ");
            opcao = scanner.nextInt();

            if ( opcao == 1){

                System.out.println("Tipo de Conta: ");
                System.out.println("1 - Conta Normal");
                System.out.println("2 - Conta Poupança"); 
                System.out.println("3 - Conta Corrente");
                int tipo = scanner.nextInt();

                System.out.println("Nome do Titular: ");
                String titular = scanner.next();

                System.out.println("Saldo inicial: ");
                double saldo = scanner.nextDouble();

                try {

                 if ((tipo == 1)) {
                    Conta conta = new Conta(titular, saldo);
                    banco.adicionarConta(conta);
                    System.out.println("Parabéns você Criou uma Conta Normal!");

                 } else if (tipo == 2){
                    System.out.println("taxa de rendimento (ex: 0.005 para 5%): ");
                    double rendimento = scanner.nextDouble();
                    ContaPoupanca conta = new ContaPoupanca(titular, saldo, rendimento);
                    banco.adicionarConta(conta);
                    System.out.println("Parabéns você criou uma Conta Poupança");

                 } else if (tipo == 3) {
                    System.out.println("Limite: ");
                    double limite = scanner.nextDouble();
                    ContaCorrente conta = new ContaCorrente(titular, saldo, limite);
                    banco.adicionarConta(conta);
                    System.out.println("parabéns você criou uma conta Corrente");
                 }
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
            }  else if(opcao == 5) {
                System.out.println("Nome do titular: ");
                String nomeBuscar = scanner.next();

                Conta conta = banco.buscarConta(nomeBuscar);

                if (conta == null) {
                    System.out.println("Conta não encontrada");
                } else if (conta instanceof ContaPoupanca){
                    ContaPoupanca poupanca = (ContaPoupanca) conta;
                    poupanca.aplicarRendimento();
                } else {
                    System.out.println("Essa conta não é uma conta poupanca");
                }
          } else if (opcao == 0) {
            System.out.println("Obrigado por usar nosso sistema bancário");
          }
            
        } while(opcao != 0);

        scanner.close();
    
}

}
