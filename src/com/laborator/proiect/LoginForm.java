package com.laborator.proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginForm extends JPanel implements ActionListener, KeyListener {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JLabel warningLabel;
    private JButton confirmButton;
    private JButton cancelButton;
    private JPanel loginPanel;

    public LoginForm() {
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        warningLabel = new JLabel();
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        confirmButton = new JButton("Confirm");
        cancelButton = new JButton("Cancel");

        confirmButton.setActionCommand("button-confirm");
        cancelButton.setActionCommand("button-cancel");
        usernameTextField.setActionCommand("user-text-validation");
        passwordTextField.setActionCommand("pass-text-validation");

        confirmButton.addActionListener(e -> {

        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        loginPanel = new JPanel();
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoginForm loginForm = new LoginForm();
        loginForm.setOpaque(true);
        frame.setContentPane(loginForm);

        frame.setPreferredSize(new Dimension(640, 480));

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}