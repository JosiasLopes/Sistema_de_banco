package Model;

public abstract class Conta {

    protected double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected int getNumConta() {
        return numConta;
    }

    protected void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    private double saldo;
    private int numConta;
    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract void consultar();
    public abstract void transferir(double valor,Conta destino);
}
