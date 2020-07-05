package com.paesa.qrgen;

import java.sql.*;

public class Logger {
    final static String DB = System.getenv("DB");
    final static String USER = System.getenv("DB_USER");
    final static String PASS = System.getenv("DB_PASS");

    static Connection conn = null;

    public Logger() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://" + DB + "/qrgen", USER, PASS);
        } catch (final Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void Log(final String data) {
        final String sql = "INSERT INTO Requests (Data) VALUES ('" + data + "')";

        try {
            final Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (final SQLException e) {
            e.printStackTrace();
        }

    }
}