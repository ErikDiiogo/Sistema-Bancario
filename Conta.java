package Java.Projetos.SistemaBancario;

public class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) throws SaldoInsuficienteException {
        if ( saldo < 0) {
            throw new SaldoInsuficienteException("Saldo inicial não pode ser negativo");
        }
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) throws IllegalArgumentException {
        if(valor <= 0) {
            throw new IllegalArgumentException("O valor do deposito não pode ser igual ou menor que zero");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException{
        if(valor <= 0) {
            throw new SaldoInsuficienteException("Valor invalido");
        }

        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insufiente! Saldo: R$ " + this.saldo);
        }
        this.saldo -= valor;
    }

    public void exibirExtrato() {
    System.out.println("Titular: " + this.titular);
    System.out.println("Saldo: " + this.saldo);
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
