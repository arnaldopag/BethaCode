package aplicacao;

import Model.Conta;
import excecoes.BethaCodeException;
import excecoes.FuncaoExemplo;

import java.sql.SQLException;
import java.util.Scanner;

public class MinhaApp {
    public static void main(String[] args) throws IllegalAccessException {
        /*FuncaoExemplo.aumentaFrase(null);
        //exemplo throws no metodo diminuirFrase
        try {
            FuncaoExemplo.diminuirFrase("JESUS");
        } catch (SQLException e) {
           System.out.println("gerou erro no sql");
        }catch (NullPointerException e){
            System.out.println("gerou erro nulo");
        }*/
        /*exemplo excecao
        new BethaCodeException();*/
        int opcao = 0;
        do {
            try{
                Conta novaConta = new Conta("Arnaldo");
                Scanner sc = new Scanner(System.in);
                    System.out.println(" 1 - Depositar");
                    System.out.println(" 2 - Sacar");
                    System.out.println(" 3 - Saldo");
                    System.out.println(" 0 - Sair");
                    System.out.print("Opcao: ");
                    opcao = sc.nextInt();
                    if(opcao == 1){
                        System.out.println("Valor deposito: ");
                        double deposito = sc.nextDouble();
                        novaConta.Deposito(deposito);
                    }else if(opcao == 2){
                        System.out.println("Valor Saque: ");
                        double saque = sc.nextDouble();
                        novaConta.Saque(saque);
                    }else if(opcao == 3){
                        System.out.println("Valor Saldo: " + novaConta.getSaldo());
                    }else if(opcao == 0){
                        System.out.println("Programa encerrado!!!");
                    }else{
                        System.out.println("Opcao invalida");
                    }
            }catch (IllegalAccessException e){
                System.out.println(e);
            }
        }while (opcao != 0);


    }
}
