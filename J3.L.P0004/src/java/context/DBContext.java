/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author s1tha
 */
public class DBContext {

    private final String serverName = "localhost"; //127.0.0.1
    private final String dbName = "Digital News";
    private final String portNumber = "1433";
    private final String userID = "SE1431";
    private final String password = "123";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) throws Exception {
        if (resultSet != null && !resultSet.isClosed()) {
            resultSet.close();
        }
        if (preparedStatement != null && !preparedStatement.isClosed()) {
            preparedStatement.close();
        }
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public String getResource() {
        return "public/images/";
    }
}
