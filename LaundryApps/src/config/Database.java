package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost/laundry_apps";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Singleton getConnection
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Koneksi ke database gagal: " + e.getMessage());
            }
        }
        return connection;
    }
}
