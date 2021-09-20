package excecoes;


import java.sql.SQLException;

public class FuncaoExemplo {
    public static void aumentaFrase(String frase) {
        String novaFrase = null;
        try{
            novaFrase = frase.toUpperCase();
            System.out.println("Frase antiga " + frase);
            System.out.println("Frase nova " + novaFrase);
        }catch (NullPointerException e){
            System.out.println("valor Nulo");
        }finally {
            System.out.println("sempre executa");
        }
    }
    public static void diminuirFrase(String frase) throws NullPointerException, SQLException {
        String novaFrase = frase.toLowerCase();
        System.out.println(frase);
        System.out.println(novaFrase);


    }
}
