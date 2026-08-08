package Java.Projetos.SistemaBancario;

public class ContaCorrente extends Conta{

    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) throws SaldoInsuficienteException{
        super(titular, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException{
        if(valor > getSaldo() + limite){
            throw new SaldoInsuficienteException("Saldo insuficiente! Saldo + limite: R$ " +(getSaldo() + limite));
        }
        super.sacar(valor);
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();

        System.out.println("Limite: R$ " + limite);
        System.out.println("Total disponivel: R$ " + (getSaldo() + limite));
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
}