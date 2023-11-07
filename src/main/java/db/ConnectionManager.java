package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    public static Connection getConnectDB() {
        return connectDB;
    }

    public static Connection connectDB;
    static String url = "jdbc:postgresql://localhost:5432/mydb";
    static String username = "denis";
    static String password = "denis";

    public static void connectDB() {
        try {
            connectDB = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnections() {
        try {
            if (connectDB != null) {
                connectDB.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
