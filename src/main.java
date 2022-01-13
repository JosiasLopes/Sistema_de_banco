import Model.ContaCorrente;
import Model.ContaPoupanca;

public class main {

    public static void main(String[] args){

        ContaCorrente c1 = new ContaCorrente(10);
        ContaPoupanca c2 = new ContaPoupanca(11);

        //consultando saldo inicial
        c1.consultar();
        c2.consultar();
        //depositando na conta corrente
        c1.depositar(100.0d);
        c2.depositar(100.0d);
        //sacar valores
        c1.sacar(9.25d);
        c2.sacar(2.34d);
        c1.consultar();
        c2.consultar();
        //efetuando transferencia entre contas
        c1.transferir(10.75,c2);
        c1.consultar();
        c2.consultar();

        c2.rendimento30Dias();
        c2.rendimento30Dias();
        c2.consultar();
        System.out.println(c2.getTipoConta());
    }
}
