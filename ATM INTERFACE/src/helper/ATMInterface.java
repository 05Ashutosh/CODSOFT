package helper;

public interface ATMInterface {
    boolean login(String username, String password);

    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
}
