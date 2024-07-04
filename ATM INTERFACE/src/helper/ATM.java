package helper;

public class ATM implements ATMInterface {
    private ATMDatabase database;
    private BankAccount currentAccount;
    private ATM_Machine atmGUI;

    public ATM(ATMDatabase database) {
        this.database = database;
    }

    public void setAtmGUI(ATM_Machine atmGUI) {
        this.atmGUI = atmGUI;
    }

    @Override
    public boolean login(String username, String password) {
        currentAccount = database.authenticateUser(username, password);
        return currentAccount != null;
    }

    @Override
    public void withdraw(double amount) {
        if (currentAccount != null) {
            currentAccount.withdraw(amount);
            database.updateAccount(currentAccount);
            atmGUI.displayMessage("Withdrawal successful. New balance: " + currentAccount.getBalance());
        }
    }

    @Override
    public void deposit(double amount) {
        if (currentAccount != null) {
            currentAccount.deposit(amount);
            database.updateAccount(currentAccount);
            atmGUI.displayMessage("Deposit successful. New balance: " + currentAccount.getBalance());
        }
    }

    @Override
    public void checkBalance() {
        if (currentAccount != null) {
            atmGUI.displayMessage("Current balance: " + currentAccount.getBalance());
        }
    }

    public void logout() {
        currentAccount = null;
    }

    public void createAccount(String username, String password, double initialDeposit) {
        if (database.createAccount(new BankAccount(username, initialDeposit), password)) {
            atmGUI.displayMessage("Account created successfully.");
        } else {
            atmGUI.displayMessage("Failed to create account. Username may already exist.");
        }
    }
}
