package com.laborator.proiect.GUI;

import com.laborator.proiect.DataBase.DataBase;
import com.laborator.proiect.DataBase.DatabaseServices;
import com.laborator.proiect.model.CurrentUser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Menu {
    private JTabbedPane tabbedPanel;
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
    private JPanel addConsultationPanel;
    private JComboBox comboBoxMedics;
    private JTable tableMedic;
    private JPanel consultationPanel;

    public Menu(CurrentUser currentUser) throws SQLException, ClassNotFoundException {
        setPanelEnabled(medicInfoPanel, false);
        setPanelEnabled(patientInfoPanel, false);
        Connection connection = DataBase.getMadeConnetion();
        if (!currentUser.getAcc_type().equals("admin")) {
            tabbedPanel.remove(2);
        }

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
            String comboBoxValue = (String) comboBox1.getSelectedItem();

            assert comboBoxValue != null;
            if (comboBoxValue.equals("Medic")) {
                setPanelEnabled(patientInfoPanel, false);
                setPanelEnabled(medicInfoPanel, true);
            } else {
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
                if (username.length() > 5 || password.length() > 5 || clinic.length() > 5) {
                    ResultSet resultSet1;
                    if (password.equals(passwordConfirm)) {
                        try {
                            String checkUserQuery = "SELECT username from `users` where `username` = ?;";
                            PreparedStatement preparedStatement;
                            preparedStatement = DataBase.getConnection().prepareStatement(checkUserQuery);
                            preparedStatement.setString(1, username);
                            resultSet1 = preparedStatement.executeQuery();

                            String getClinicId = "SELECT * from `clinic` where `name` = ?;";
                            preparedStatement = DataBase.getConnection().prepareStatement(getClinicId);
                            preparedStatement.setString(1, clinic);

                            resultSet1 = preparedStatement.executeQuery();
                            resultSet1.next();
                            String clinic_id = resultSet1.getString("clinic_id");

                            String addMedic = "INSERT INTO `users`\n" +
                                    "(`username`,\n" +
                                    "`password`,\n" +
                                    "`clinic_id`,\n" +
                                    "`account_type`)\n" +
                                    "VALUES\n" +
                                    "(?,\n" +
                                    "?,\n" +
                                    "?,\n" +
                                    "?);\n";

                            preparedStatement = DataBase.getConnection().prepareStatement(addMedic);
                            preparedStatement.setString(1, username);
                            preparedStatement.setString(2, password);
                            preparedStatement.setString(3, clinic_id);
                            preparedStatement.setString(4, accountType);

                            if (!resultSet.next()) {
                                if (accountType.equals("Medic")) {
                                    String medicFirst = medicFirstName.getText();
                                    String medicLast = medicLastName.getText();
                                    String medicAdressVal = medicAdress.getText();
                                    String medicDOBVal = medicDOB.getText();        /// TO Change!
                                    String medicTele = medicTelephone.getText();
                                    String medicCNPValue = medicCNP.getText();
                                    String medicEm = medicEmail.getText();
                                    String medicalField = (String) comboBoxMedicField.getSelectedItem();

                                    String addMedicDetails = "INSERT INTO `medicdetails`\n" +
                                            "(`username`,\n" +
                                            "`adress`,\n" +
                                            "`DOB`,\n" +
                                            "`CNP`,\n" +
                                            "`telephone`,\n" +
                                            "`email`,\n" +
                                            "`f_name`,\n" +
                                            "`l_name`,\n" +
                                            "`medical_fiels`)\n" +
                                            "VALUES\n" +
                                            "(?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?);\n";

                                    PreparedStatement preparedStatementMedic = DataBase.getConnection().prepareStatement(addMedicDetails);
                                    preparedStatementMedic.setString(1, username);
                                    preparedStatementMedic.setString(2, medicAdressVal);
                                    preparedStatementMedic.setString(3, medicDOBVal);
                                    preparedStatementMedic.setString(4, medicCNPValue);
                                    preparedStatementMedic.setString(5, medicTele);
                                    preparedStatementMedic.setString(6, medicEm);
                                    preparedStatementMedic.setString(7, medicFirst);
                                    preparedStatementMedic.setString(8, medicLast);
                                    preparedStatementMedic.setString(9, medicalField);

                                    preparedStatementMedic.executeUpdate();
                                    preparedStatement.executeUpdate();
                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Register", 2);


                                } else if (accountType.equals("Patient")) {
                                    String patientFirst = patientFirstName.getText();
                                    String patientLast = patientLastName.getText();
                                    String fatherFirstN = patientFathFN.getText();
                                    String Adress = patientAdress.getText();
                                    String DOB = patientDOB.getText();
                                    String CNP = patientCNP.getText();
                                    String telephone = patientTeleph.getText();
                                    String height = patientHeight.getText();
                                    String weight = patientWeight.getText();
                                    String email = patientEmail.getText();

                                    String addPatientDetails = "INSERT INTO `patientdetails`\n" +
                                            "(`username`,\n" +
                                            "`adress`,\n" +
                                            "`weight`,\n" +
                                            "`height`,\n" +
                                            "`DOB`,\n" +
                                            "`f_name`,\n" +
                                            "`l_name`,\n" +
                                            "`CNP`,\n" +
                                            "`telephone`,\n" +
                                            "`email`,\n" +
                                            "`father_f_name`" +
                                            ")\n" +
                                            "VALUES\n" +
                                            "(?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?,\n" +
                                            "?\n" +
                                            ");\n";
                                    PreparedStatement preparedStatementPatient = DataBase.getConnection().prepareStatement(addPatientDetails);
                                    preparedStatementPatient.setString(1, username);
                                    preparedStatementPatient.setString(2, Adress);
                                    preparedStatementPatient.setString(3, weight);
                                    preparedStatementPatient.setString(4, height);
                                    preparedStatementPatient.setString(5, DOB);
                                    preparedStatementPatient.setString(6, patientFirst);
                                    preparedStatementPatient.setString(7, patientLast);
                                    preparedStatementPatient.setString(8, CNP);
                                    preparedStatementPatient.setString(9, telephone);
                                    preparedStatementPatient.setString(10, email);
                                    preparedStatementPatient.setString(11, fatherFirstN);

                                    preparedStatementPatient.executeUpdate();
                                    preparedStatement.executeUpdate();

                                    JOptionPane.showMessageDialog(null, "SUCCESS", "Register", 2);

                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR", "Register Error", 2);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Username Taken", "Register Error", 2);

                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match", "Register Error", 2);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Empty Fields", "Register Error", 2);
                }
            }

        });



        comboBoxMedics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = new DefaultTableModel();
                tableMedic.setModel(model);

                model.addColumn("Date");
                String selectedMedic = comboBoxMedics.getSelectedItem().toString();

                try {
                    String query = "SELECT user_id FROM `users` WHERE `username` = ?;\n";

                    PreparedStatement statementQ =  DataBase.getConnection().prepareStatement(query);
                    statementQ.setString(1,selectedMedic);
                    ResultSet rs = statementQ.executeQuery();
                    String user_id="-1";
                    if (rs.next()) {
                        user_id = rs.getString("user_id");
                    }


                    query = "SELECT * from consultations where `medic_id` = ?;\n";
                    statementQ =  DataBase.getConnection().prepareStatement(query);
                    statementQ.setString(1,user_id);
                    rs = statementQ.executeQuery();

                    while(rs.next()){
                        model.addRow(new Object[]{rs.getString("date")});
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });
        try {
            Statement statementQ = connection.createStatement();
            String query = "SELECT * FROM medicdetails";
            ResultSet rs = statementQ.executeQuery(query);
            if (comboBoxMedics.getItemCount() != 0) {
                comboBoxMedics.removeAllItems();
            }
            while (rs.next()) {
                comboBoxMedics.addItem(rs.getString("username"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
