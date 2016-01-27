/*
 * Server Config Object
 * 
 */

package Entity;

import java.io.Serializable;
/*
 * Class server bao gom cac thong tin ve server va contructor, setter va getter.
 */

public class Server implements Serializable{
    private String ServerName;
    private String Port;
    private String UserName;
    private String Password;
    private String DatabaseName;
    public static final String configFile="lib\\config.txt";//file chua server config

    //contructor
    public Server() {
    }
    public Server(String ServerName, String Port, String UserName, String Password, String DatabaseName) {
        this.ServerName = ServerName;
        this.Port = Port;
        this.UserName = UserName;
        this.Password = Password;
        this.DatabaseName = DatabaseName;
    }
    //setter and getter
    public String getServerName() {
        return ServerName;
    }

    public void setServerName(String ServerName) {
        this.ServerName = ServerName;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String Port) {
        this.Port = Port;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDatabaseName() {
        return DatabaseName;
    }

    public void setDatabaseName(String DatabaseName) {
        this.DatabaseName = DatabaseName;
    }
}
   