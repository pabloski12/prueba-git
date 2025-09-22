
package com.ies9021.snr.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL = "jdbc:mysql://ies9021.edu.ar:3306/ies9021_SNR";
    private static final String USER = "ies9021_userdb";
    private static final String PASS = "Xsw23edc.2025";

    /*Este método devuelve una nueva conexión a la base de datos usando las credenciales 
    definidas. Cada vez que lo llamamos se abre una conexión nueva, y es nuestra
    responsabilidad CERRARLA manualmente para liberar recursos.*/
    public static Connection conectar() {

        Connection con =null;

        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("conectado");

        }catch(SQLException e){
            System.out.println("Conexion fallida");
            e.printStackTrace();

        }

      return con;

    }
}
