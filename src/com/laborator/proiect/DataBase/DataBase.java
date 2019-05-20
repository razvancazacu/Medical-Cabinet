package com.laborator.proiect.DataBase;
import java.sql.*;

public class DataBase {

    private static Connection connection;
    public static Connection getMadeConnetion (){return connection;}
    public static Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/pao-db?useSSL=true&requireSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url, "root", "SQL_mds_project");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from `users`");
//            System.out.println(statement.executeQuery("select * from `users`"));
            while(resultSet.next()) {
//                System.out.println(resultSet.getString(1)+ resultSet.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void deleteUser(String name){
        try {
            PreparedStatement statement = connection.prepareStatement(DatabaseServices.deleteUser);
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}