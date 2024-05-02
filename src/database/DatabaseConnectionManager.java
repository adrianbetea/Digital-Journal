package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionManager {
    private static Connection con;
    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/digital_journal","root","root");
            return con;
        }catch(Exception e){ System.out.println(e);}

        return null;
    }
}
