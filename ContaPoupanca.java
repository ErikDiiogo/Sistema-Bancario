package Java.Projetos.SistemaBancario;

public class ContaPoupanca extends Conta {

    private double rendimento;
    
    public ContaPoupanca(String titular, double saldo, double rendimento)throws SaldoInsuficienteException{
        super(titular, saldo);
        this.rendimento = rendimento;
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException{
        if (valor > getSaldo() ) {
            throw new SaldoInsuficienteException("Saldo insuficiente! Saldo + limite: R$ " +  (getSaldo()));
        }
        super.sacar(valor);
    }

    public void aplicarRendimento(){
        double ganho = getSaldo() * rendimento;
        System.out.println("Rendimento: R$ " + ganho);
        try {
            depositar(ganho);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void exibirExtrato(){
        super.exibirExtrato();

        System.out.println("Rendimento mensal: " + (rendimento * 1000 + "%"));
        System.out.println("Proximo rendimento: R$ " + (getSaldo() * rendimento));
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }   
}
