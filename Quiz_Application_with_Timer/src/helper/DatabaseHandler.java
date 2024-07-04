package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/quiz";
    private String username = "root";
    private String password = "root";
    private String query = "SELECT * FROM quizques";
    private Connection connection;

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    public ResultSet executeQuery() throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
