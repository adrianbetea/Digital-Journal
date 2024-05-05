import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import database.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]){

        //MainPage mp = new MainPage();
        //Connection con = DatabaseConnectionManager.getConnection();
        //System.out.println(con);
        LoginPage.getInstance().setVisible(true);
        //RegisterPage.getInstance(con).setVisible(true);
    }
}