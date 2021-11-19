package com.ecam.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DBConnect {
    public static void Connect() throws ClassNotFoundException {
        String userName = "user";
        String password = "user";
        String url1 = "jdbc:mysql://109.132.191.163:3306/Logiciel";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(url1,userName,password);
            String query = "select id from test";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int id = rs.getInt("id");
                // print the results
                System.out.format("%s\n", id);
            }
            st.close();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("Hello World");

    }
}
