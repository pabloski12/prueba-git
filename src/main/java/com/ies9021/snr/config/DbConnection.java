
package com.ies9021.snr.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "root";
    private static final String PASS = "1234";

    /*Este método devuelve una nueva conexión a la base de datos usando las credenciales 
    definidas. Cada vez que lo llamamos se abre una conexión nueva, y es nuestra
    responsabilidad CERRARLA manualmente para liberar recursos.*/
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
