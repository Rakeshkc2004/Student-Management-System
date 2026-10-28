package com.studentmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = System.getenv("DB_PASSWORD");

        if (password == null) {
            throw new SQLException("DB_PASSWORD environment variable is not set");
        }

        return DriverManager.getConnection(url, username, password);
    }
}
