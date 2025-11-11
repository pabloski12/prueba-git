package com.mycompany.sistemabiblioteca;

import com.mycompany.sistemabiblioteca.util.Conexion;
import view.LoginView;
import java.sql.Connection;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        // 1️⃣ Verificamos conexión con MySQL
        Connection con = Conexion.getConexion();
        if (con != null) {
            System.out.println("✅ Conexión verificada desde Main.");
        } else {
            System.out.println("❌ Error: No se pudo conectar con la base de datos.");
            return; // Detiene la ejecución si no conecta
        }

        // 2️⃣ Mostramos la ventana de inicio de sesión
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
