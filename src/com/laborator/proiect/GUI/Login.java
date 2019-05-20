package com.laborator.proiect.GUI;

import com.laborator.proiect.DataBase.DataBase;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    private JPanel topPanel;
    private JLabel loginLabel;
    private JTextField usernameTextField;
    private JButton LOGINButton;
    private JButton CANCELButton;
    private JPasswordField passwordField;
    private JPanel mainLoginForm;
    private JPanel loginPanel;
    private JPanel titlePanel;
    private JPanel formPanel;

    public Login(JFrame frameLogin) {


        LOGINButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               login(frameLogin);
            }
        });


        usernameTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (usernameTextField.getText().trim().toLowerCase().equals("username")) {
                    usernameTextField.setText("");
                    usernameTextField.setForeground(Color.black);
                }

                // showing that the textfield it's focused on
                Border usernameTextBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
                usernameTextField.setBorder(usernameTextBorder);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                //checking if the username is empty or still 'username'
                // we'll set the text field to "username"
                if (usernameTextField.getText().trim().toLowerCase().equals("username")
                        || usernameTextField.getText().trim().toLowerCase().equals("")
                ) {
                    usernameTextField.setText("username");
                    usernameTextField.setForeground(new Color(153, 153, 153));
                }
                //removing the border
                usernameTextField.setBorder(null);
            }
        });
        passwordField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                String pass = String.valueOf(passwordField.getPassword());
                if (pass.toLowerCase().equals("password")) {
                    passwordField.setText("");
                    usernameTextField.setForeground(Color.black);
                }

                // showing that the textfield it's focused on
                Border passwordFieldBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.yellow);
                passwordField.setBorder(passwordFieldBorder);
            }

            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                //checking if the password is empty or still 'password'
                // we'll set the text field to "password"

                String pass = String.valueOf(passwordField.getPassword());

                if (pass.toLowerCase().equals("password")
                        || pass.toLowerCase().equals("")
                ) {
                    passwordField.setText("password");
                    passwordField.setForeground(new Color(153, 153, 153));
                }
                //removing the border
                passwordField.setBorder(null);
            }
        });

        CANCELButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });


        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login(frameLogin);
                }
            }
        });
    }

    private void login(JFrame frameLogin) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        // get the username and password
        String username = usernameTextField.getText();
        String password = String.valueOf(passwordField.getPassword());

        // creating a select query to see if the username already exists in the db

        String query = "SELECT * FROM `users` WHERE `username` = ? and `password` = ?";

        try {
            preparedStatement = DataBase.getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String acc_type = resultSet.getString("account_type");
                JFrame frameMenu = new JFrame("Menu");
                try {
                    frameMenu.setContentPane(new Menu(username, acc_type).getMenuPanel());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frameMenu.pack();
                frameMenu.setVisible(true);
                frameMenu.setLocationRelativeTo(null);
                frameLogin.dispose();

            } else {
                // error
                JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error", 2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login(frame).mainLoginForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
