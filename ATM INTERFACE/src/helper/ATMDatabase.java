package helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ATMDatabase {

    public BankAccount authenticateUser(String username, String password) {
        BankAccount account = null;
        String query = "SELECT username, balance FROM accountsDetails WHERE username = ? AND password = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String retrievedUsername = resultSet.getString("username");
                    double balance = resultSet.getDouble("balance");
                    account = new BankAccount(retrievedUsername, balance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public void updateAccount(BankAccount account) {
        String query = "UPDATE accountsDetails SET balance = ? WHERE username = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, account.getBalance());
            statement.setString(2, account.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean createAccount(BankAccount account, String password) {
        String query = "INSERT INTO accountsDetails (username, password, balance) VALUES (?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, account.getUsername());
            statement.setString(2, password);
            statement.setDouble(3, account.getBalance());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
