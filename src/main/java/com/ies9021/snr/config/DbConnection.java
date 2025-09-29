package com.ies9021.snr.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL =
        "jdbc:mysql://ies9021.edu.ar:3306/ies9021_SNR"
      + "?useSSL=false&allowPublicKeyRetrieval=true"
      + "&useUnicode=true&characterEncoding=utf8"
      + "&serverTimezone=UTC";
        
    private static final String USER = "ies9021_userdb";
    private static final String PASS = "Xsw23edc.2025";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}