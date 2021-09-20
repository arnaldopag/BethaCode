package Model;

public class Conta {
    private String dono;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }



    public Conta(String dono) {
        this.dono = dono;
    }

    public void Deposito(double valorDeposito) throws IllegalAccessException {
        if (valorDeposito <= 0){
            throw new IllegalAccessException("Valor Do deposito invalido");
        }
        this.saldo += valorDeposito;
    }
    public void Saque(double valorSaque) throws IllegalAccessException {
        if (valorSaque <= 0){
            throw new IllegalAccessException("Valor saque invalido");
        }
        if (valorSaque > this.saldo){
            throw new IllegalAccessException("Valor saque maior que saldo");
        }
        this.saldo -= valorSaque;
    }
}
