package courseMngmtSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final Connection connection = getConnection();

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/cms", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Statement getStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}