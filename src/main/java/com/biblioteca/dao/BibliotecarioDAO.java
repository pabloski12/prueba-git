package com.biblioteca.dao;

import com.mycompany.sistemabiblioteca.util.Conexion;
import java.sql.*;

public class BibliotecarioDAO {
    
    public boolean validarLogin(String usuario, String password) {
        String sql = "SELECT * FROM bibliotecario WHERE usuario = ? AND password = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            return rs.next(); // true si encontró un registro
        } catch (SQLException e) {
            System.out.println("Error al validar login: " + e.getMessage());
            return false;
        }
    }
}
