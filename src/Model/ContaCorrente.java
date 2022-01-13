package Model;

import Enums.TipoConta;

public class ContaCorrente extends Conta{

    private TipoConta tipo;
    @Override
    public void sacar(double valor) {
        if(this.getSaldo()<=0 || this.getSaldo()<valor){
            System.out.println("O saldo é isuficiente para realizar a operaçao");
        }
            else{
                this.setSaldo(this.getSaldo()-valor);
                //System.out.println("Saque de R$:"+this.getSaldo()+" efetuado com sucesso");
            }
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Nao e possivel efetuar depositos de valores zerados");
        } else {
            this.setSaldo(this.getSaldo() + valor);
            //System.out.println("Deposito de de R$:"+valor+" efetuado com sucesso");
        }
    }

    @Override
    public void consultar() {
        System.out.println("Saldo de R$:"+this.getSaldo()+" na conta corrente");
    }

    @Override
    public void transferir(double valor, Conta destino) {
        if(destino.getNumConta()<=0){
            System.out.println("O numero informado da Conta não existe");
        }else{
                this.sacar(valor);
                destino.depositar(valor);
            System.out.println("O valor de R$:"+valor+" foi transferido com sucesso");
        }
    }

    public ContaCorrente(int numConta){
        this.setNumConta(numConta);
        this.setSaldo(0.0d);
        this.tipo = TipoConta.CONTA_CORRENTE;
    }
}
