package com.laborator.proiect.GUI;

import com.laborator.proiect.DataBase.DataBase;
import com.laborator.proiect.DataBase.DatabaseServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class Menu {
    private JTabbedPane tabbedPane1;
    private JPanel menuPanel;
    private JPanel registerPanel;
    private JTextField usernameText;

    private JPasswordField passField;
    private JPasswordField passConfirmField;
    private JComboBox comboBox1;
    private JButton confirmButton;
    private JComboBox comboBoxClinic;
    private JPanel informationPanel;
    private JTextField medicAdress;
    private JTextField medicCNP;
    private JTextField medicTelephone;
    private JTextField medicEmail;
    private JTextField medicFirstName;
    private JComboBox comboBoxMedicField;
    private JTabbedPane medicPatientTabPannel;
    private JPanel medicInfoPanel;
    private JPanel patientInfoPanel;
    private JTextField medicLastName;
    private JTextField patientFirstName;
    private JTextField patientLastName;
    private JTextField patientFathFN;
    private JTextField patientAdress;
    private JTextField patientDOB;
    private JTextField patientCNP;
    private JTextField patientTeleph;
    private JTextField patientWeight;
    private JTextField patientHeight;
    private JTextField patientEmail;
    private JTextField medicDOB;

    public Menu(String username, String account_type) throws SQLException, ClassNotFoundException {
        setPanelEnabled(medicInfoPanel, false);
        setPanelEnabled(patientInfoPanel, false);
        Connection connection = DataBase.getMadeConnetion();

        /*
        Conectare la baza de date si extragerea clinicilor disponibile pentru adaugarea de conturi noi.
         */
        // TEMPORAR -- pentru teste
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/pao-db?useSSL=true&requireSSL=false&serverTimezone=UTC";
        connection = DriverManager.getConnection(url, "root", "SQL_mds_project");
        // TEMPORAR
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(DatabaseServices.getClinics);

        String[] clinicStrings = new String[10];
        int numberOfItems = 0;
        while (resultSet.next()) {
            String newItem = resultSet.getString(1);
            clinicStrings[numberOfItems++] = newItem;
            comboBoxClinic.addItem(newItem);
        }
        comboBoxClinic.setSelectedIndex(0);


        comboBox1.addActionListener(e -> {
            System.out.println("combo changed");
            String comboBoxValue = (String) comboBox1.getSelectedItem();

            assert comboBoxValue != null;
            if (comboBoxValue.equals("Medic")) {
                System.out.println("medic");
                setPanelEnabled(patientInfoPanel, false);
                setPanelEnabled(medicInfoPanel, true);
            } else {
                System.out.println("patient");
                setPanelEnabled(patientInfoPanel, true);
                setPanelEnabled(medicInfoPanel, false);
            }


        });


        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String username = usernameText.getText();
                String password = String.valueOf(passField.getPassword());
                String passwordConfirm = String.valueOf(passConfirmField.getPassword());
                String accountType = (String) comboBox1.getSelectedItem();
                String clinic = (String) comboBoxClinic.getSelectedItem();

                ResultSet resultSet1;

                System.out.println(accountType + " asdaasdads");

                try {
                    String checkUserQuery = "SELECT username from `users` where `username` = ?;";
                    PreparedStatement preparedStatement ;
                    preparedStatement = DataBase.getConnection().prepareStatement(checkUserQuery);
                    preparedStatement.setString(1,username);
                    resultSet1 = preparedStatement.executeQuery();

                    if(resultSet.next()){
                        if (accountType.equals("Medic")) {
                            String medicFirst = medicFirstName.getText();
                            String medicLast = medicLastName.getText();
                            String medicAdressVal = medicAdress.getText();
                            String medicDOBVal = medicDOB.getText();        /// TO Change!
                            String medicTele = medicTelephone.getText();
                            String medicCNPValue = medicCNP.getText();
                            String medicEm = medicEmail.getText();
                            String medicalField = (String) comboBoxMedicField.getSelectedItem();

                        } else if (accountType.equals("Patient")) {

                        } else {
                        }
                        JOptionPane.showMessageDialog(null, "ERROR", "Register Error", 2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Username Taken", "Register Error", 2);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }



            }
        });
    }

    private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);

        Component[] components = panel.getComponents();

        for (Component component : components) {
            if (component instanceof JPanel) {
                setPanelEnabled((JPanel) component, isEnabled);
            }
            component.setEnabled(isEnabled);
        }
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}
