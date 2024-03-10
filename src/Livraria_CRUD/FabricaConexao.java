package Livraria_CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/livraria";

    public static Connection createConnection()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        return connection;
    }

    public static void main(String[] args) throws Exception{
        Connection con = createConnection();
        if (con!=null){
            con.close();
        }

    }
}
