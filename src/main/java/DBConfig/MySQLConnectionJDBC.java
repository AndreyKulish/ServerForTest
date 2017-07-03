package DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hitek on 03.07.2017.
 */
public class MySQLConnectionJDBC{

    private static Connection conn = null;
    private static String connectionString;

    public static void setConnection(String portName, String dataBaseName, String userName, String passWord){
        connectionString = "jdbc:mysql://" + portName + "/" + dataBaseName + "?user=" + userName + "&password=" + passWord;
        try {
            conn =
                    DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error Connection");
        }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void endConnection(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
