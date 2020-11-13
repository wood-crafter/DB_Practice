/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author phanh
 */
public class DBContext {
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT + ";databaseName=" + DB_NAME;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, USERNAME, PASSWORD);
    }

    private final String SERVER_NAME = "DESKTOP-4ARF9HT\\SQLEXPRESS";
    private final String DB_NAME = "ToDo";
    private final String PORT = "1433";
    private final String USERNAME = "sa";
    private final String PASSWORD = "123456";
}
