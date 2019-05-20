package com.laborator.proiect.DataBase;

public interface DatabaseServices {

    String insertTable = "INSERT INTO `users`\n" +
            "(`username`,\n" +
            "`email`,\n" +
            "`password`,\n" +
            "`create_time`)\n" +
            "VALUES\n" +
            "(?,\n" +
            "?,\n" +
            "?,\n" +
            "?);";
    String deleteUser = "DELETE FROM `users` WHERE `username` = ?;";
    String getClinics = "SELECT name FROM `clinic`;";
    String getAccountType = "SELECT account_type from `users` WHERE `username` = ?;";
    String checkUsername = "SELECT username from `users` where `username` = ?;";
}
