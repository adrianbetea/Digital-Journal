import Pages.LoginPage;
import database.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]){
        LoginPage loginPage = new LoginPage();
        //MainPage mp = new MainPage();
        Connection con = DatabaseConnectionManager.getConnection();
        System.out.println(con);
        Statement stmt= null;
        try {
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from users");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}