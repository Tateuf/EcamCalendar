package com.ecam.Calendar;
import com.jcraft.jsch.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class DBConnect {
    public int Ping() {
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
            Connection con = DriverManager.getConnection("jdbc:mysql://" + dbHostName + ":" + forwardedPort + "/" + database, dbUser, dbPassWord);
            System.out.println("Db Connection established");
        } catch (JSchException | SQLException e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
