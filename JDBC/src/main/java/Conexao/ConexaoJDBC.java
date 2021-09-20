package Conexao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoJDBC {
    public static Properties getProp() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        InputStream file = loader.getResourceAsStream("Config.Properties");
        props.load(file);
        return props;
    }
    public static Connection getConnection(){
        Connection conexao = null;
        try {
            Properties props = getProp();
            String url =  props.getProperty("dados.url");
            String usuario = props.getProperty("dados.usuario");
            String senha =  props.getProperty("dados.senha");
            conexao = DriverManager.getConnection(url,usuario,senha);
            System.out.println("DB conectado!!!");
        }catch (SQLException e){
            System.out.println("ERRO de conexao ao banco " + e.getMessage());
        }catch (IOException e){
            System.out.println("ERRO de conexao ao banco " + e.getMessage());
        }
        return conexao;
    }
}
