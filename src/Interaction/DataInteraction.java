/*
 * Class to interact with Database
 * 
 */
package Interaction;

import Entity.Server;
import GUI.ConfigServer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * GiangNT
 */
/*
 * Ham ket noi server, su dung driver JDBC
 */
public class DataInteraction {
    //tam thoi tu ket noi

    private static Server server = null;
    private static String url = null;
    //jdbc:derby://localhost:1527/ProjectXDB [sa on SA]
    private static Connection conn = null;
    public static String message = "";

    /*
     Method to connect database
     */
    public static Connection connect() {
        try {
            //configServer();
            if (conn == null) {
                String username;
                String password;

                try {
                    server = ConfigServer.getServer();
                    url = "jdbc:derby://" + server.getServerName() + ":" + server.getPort() + "/" + server.getDatabaseName();
                    username = server.getUserName();
                    password = server.getPassword();
                } catch (NullPointerException ex) {
                    url = "jdbc:derby://localhost:1527/ProjectXDB";
                    username = "sa";
                    password = "123456";
                }

                conn = DriverManager.getConnection(url, username, password);
                message = "Connect to database successfully";
            }
        } catch (SQLException ex) {
            message = "Database connecting failure.";
        } catch (Exception ex) {
            message = "Other Exception";
        }
        return conn;
    }
    //Method to create a resultset

    public static ResultSet createResultSet(String sql) {
        ResultSet rs = null;
        try {
            Statement st = connect().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql);
            message = "Success";
        } catch (SQLException ex) {
            ex.printStackTrace();
            message = "Fail";
        } finally {
            return rs;
        }

    }

    // Method to execute a query by statement
    public static int execQuery(String sql) {
        int flag = 0;
        try {
            Statement st = connect().createStatement();
            flag = st.executeUpdate(sql);
            message = "Success";

        } catch (SQLException ex) {
            ex.printStackTrace();
            message = "Fail";
            flag = -1;
        } finally {
            return flag;
        }
    }

    //GetMessage
    public static String getMessage() {
        return message;
    }
}
