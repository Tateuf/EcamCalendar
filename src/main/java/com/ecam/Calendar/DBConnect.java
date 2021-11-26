package com.ecam.Calendar;
import com.jcraft.jsch.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {
    Connection conn;
    ResultSet rs;
    public int Connect_to_DB() {
        String deviceUser = "pi";
        String devicePassWord = "1453";
        String deviceHostName = "109.132.191.163";
        int sshPort = 22;
        int dbPort = 3306;
        String dbUser = "user";
        String dbHostName = "127.0.0.1";
        String dbPassWord = "user";
        String database = "Logiciel";
        Session session;
        try {
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session = jsch.getSession(deviceUser, deviceHostName, sshPort);
            session.setPassword(devicePassWord);
            session.setConfig(config);
            int forwardedPort = session.setPortForwardingL(0, dbHostName, dbPort);
            System.out.println("Establishing Connection ...");
            session.connect();
            System.out.println("Connection Established");
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver ok");
            conn = DriverManager.getConnection("jdbc:mysql://" + dbHostName + ":" + forwardedPort + "/" + database, dbUser, dbPassWord);
            System.out.println("Db Connection established");
        } catch (JSchException | SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public int Select(String select_statement){
        Connect_to_DB();
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(select_statement);
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
            return 1;
        }
        return 0;
    }
    public int Insert(String execute_query){
        try{
            Statement stmt = conn.createStatement();;
            stmt.executeUpdate(execute_query);
        }
        catch (SQLException e){
            System.out.println(e.getErrorCode());
            return 1;
        }
        return 0;
    }
    public ResultSet GetSelect(String select_statement){
        try{
            Select(select_statement);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return rs;
    }
    public void Close_connection(){
        try{
            conn.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

}
