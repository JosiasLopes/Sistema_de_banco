package Model;

import Enums.TipoConta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class ContaPoupanca extends Conta{

    private TipoConta tipo;
    private Boolean rendeu;

    public String getTipoConta(){
        return this.tipo.name();
    }

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
        System.out.println("Saldo de R$:"+this.getSaldo()+" na conta poupanca");
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
    public void rendimento30Dias(){
        LocalDate inicio = LocalDate.now();
        LocalDate anterior = inicio.minusDays(30);

        //calcula o periodo que ocorreu da data atual até ela-30 dias
        //caso seja ok faz adiocna o rendimento
        if(rendeu==false){
            int minimo = Period.between(anterior,inicio).getDays();
            int maximo = Period.between(anterior,inicio).getDays();
            if((minimo>=28) && (maximo<32)){
                rendeu = true;
                double vl = this.getSaldo()+(this.getSaldo()*0.05);
                this.setSaldo(vl);
            }
        }


    }

    public ContaPoupanca(int numConta){
        this.setNumConta(numConta);
        this.setSaldo(0.0d);
        this.tipo = TipoConta.CONTA_POUPANCA;
        rendeu = false;
    }
}
