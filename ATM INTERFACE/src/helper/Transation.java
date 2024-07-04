package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transation extends Frame {
    private ATM atm;
    private Label label;
    private Button checkBalanceButton, withdrawButton, depositButton, logoutButton;
    private TextField amountField;

    public Transation(ATM atm) {
        this.atm = atm;


        setTitle("ATM Main Menu");
        setSize(750, 500);
        setLayout(null);
        setLocationRelativeTo(null);


        checkBalanceButton = new Button("Check Balance");
        checkBalanceButton.setBounds(100, 100, 200, 50);
        add(checkBalanceButton);
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atm.checkBalance();
            }
        });

        withdrawButton = new Button("Withdraw");
        withdrawButton.setBounds(100, 200, 200, 50);
        add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    atm.withdraw(amount);
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid amount. Please enter a valid number.");
                }
            }
        });

        depositButton = new Button("Deposit");
        depositButton.setBounds(100, 300, 200, 50);
        add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    atm.deposit(amount);
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid amount. Please enter a valid number.");
                }
            }
        });

        label = new Label("Amount");
        label.setBounds(400,150,200,50);
        add(label);

        amountField = new TextField();
        amountField.setBounds(400, 200, 200, 50);
        add(amountField);

        logoutButton = new Button("Logout");
        logoutButton.setBounds(600, 50, 100, 25);
        add(logoutButton);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atm.logout();
                new ATM_Machine(atm).setVisible(true);
                setVisible(false); // Hide main menu frame
            }
        });


        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
