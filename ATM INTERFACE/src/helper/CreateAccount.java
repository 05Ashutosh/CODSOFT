package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAccount extends Frame {
    private ATM atm;
    private TextField username, password, initialDeposit;
    private Button createAccountButton;
    private Label title, userLabel, passLabel, initialDepositLabel;

    public CreateAccount(ATM atm) {
        this.atm = atm;

        setTitle("Create Account");
        setSize(750, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        title = new Label("CREATE ACCOUNT", Label.CENTER);
        title.setBounds(50, 50, 650, 50);
        add(title);

        userLabel = new Label("Username:");
        userLabel.setBounds(150, 130, 100, 40);
        add(userLabel);

        username = new TextField();
        username.setBounds(300, 130, 200, 40);
        add(username);

        passLabel = new Label("Password:");
        passLabel.setBounds(150, 220, 100, 40);
        add(passLabel);

        password = new TextField();
        password.setEchoChar('*');
        password.setBounds(300, 220, 200, 40);
        add(password);

        initialDepositLabel = new Label("Initial Deposit:");
        initialDepositLabel.setBounds(150, 300, 100, 40);
        add(initialDepositLabel);

        initialDeposit = new TextField();
        initialDeposit.setBounds(300, 300, 200, 40);
        add(initialDeposit);

        createAccountButton = new Button("Create Account");
        createAccountButton.setBounds(300, 400, 150, 40);
        add(createAccountButton);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String usernameText = username.getText();
                    String passwordText = password.getText();
                    double initialDepositAmount = Double.parseDouble(initialDeposit.getText());
                    atm.createAccount(usernameText, passwordText, initialDepositAmount);
                    displayMessage("Account created successfully.");
                    new ATM_Machine(atm).setVisible(true);
                    setVisible(false); // Hide create account frame
                } catch (NumberFormatException ex) {
                    displayMessage("Invalid initial deposit amount. Please enter a valid number.");
                }
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
