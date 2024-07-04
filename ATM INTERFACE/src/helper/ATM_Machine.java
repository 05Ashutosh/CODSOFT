package helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATM_Machine extends Frame {
    private Label atmLabel, usernameLabel, passwordLabel;
    private ATM atm;
    private TextField username, password;
    private Button loginButton, createAccountButton;

    public ATM_Machine(ATM atm) {
        this.atm = atm;
        atm.setAtmGUI(this);

        setTitle("ATM Machine");
        setSize(750, 500);
        setLayout(null);

        atmLabel = new Label("ATM Machine", Label.CENTER);
        atmLabel.setBounds(75, 50, 600, 50);
        add(atmLabel);

        usernameLabel = new Label("Username");
        usernameLabel.setBounds(150, 150, 150, 50);
        add(usernameLabel);

        passwordLabel = new Label("Password");
        passwordLabel.setBounds(150, 250, 150, 50);
        add(passwordLabel);

        username = new TextField();
        username.setBounds(400, 150, 200, 50);
        add(username);

        password = new TextField();
        password.setBounds(400, 250, 200, 50);
        add(password);

        loginButton = new Button("Login");
        loginButton.setBounds(300, 350, 100, 25);
        add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText = password.getText();
                if (atm.login(usernameText, passwordText)) {
                    displayMessage("Login successful.");
                    new Transation(atm).setVisible(true);
                    setVisible(false); // Hide login frame
                } else {
                    displayMessage("Username or password is incorrect.");
                }
            }
        });

        createAccountButton = new Button("Create Account");
        createAccountButton.setBounds(450, 400, 100, 25);
        add(createAccountButton);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateAccount(atm).setVisible(true);
                setVisible(false); // Hide login frame
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


}
