package mate.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load Driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", "root");
            dbProperties.put("password", "mysql2022");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/taxi_servise", dbProperties);
        } catch (SQLException throwables) {
            throw new RuntimeException("Can't create connection", throwables);
        }
    }

}
