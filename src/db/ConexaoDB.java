
package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class ConexaoDB {
    static Connection getConexao() throws Exception{
        String url = "jdbc:postgresql:sa";
        String driver = "org.postgresql.Driver";
        String usuario = "postgres";
        String senha = "123";
        
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,usuario,senha);
        
        return conn;
    }
}
