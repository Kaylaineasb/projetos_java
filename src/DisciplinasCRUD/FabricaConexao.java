package DisciplinasCRUD;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
    private static final String USERNAME= "root";
    private static final String PASSWORD ="";
    private static final String URL = "jdbc:mysql://localhost:3306/cursos";

    public static Connection createCon()throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }
}
