package com.biblioteca.dao;

import com.mycompany.sistemabiblioteca.model.Prestamo;
import com.mycompany.sistemabiblioteca.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoDAO {

    public boolean registrarPrestamo(Prestamo prestamo) {
        String sql = "INSERT INTO prestamo (id_socio, id_ejemplar, fecha_prestamo, fecha_devolucion, devuelto) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, prestamo.getIdSocio());
            ps.setInt(2, prestamo.getIdEjemplar());
            ps.setDate(3, new java.sql.Date(prestamo.getFechaPrestamo().getTime()));
            ps.setDate(4, prestamo.getFechaDevolucion() != null ? new java.sql.Date(prestamo.getFechaDevolucion().getTime()) : null);
            ps.setBoolean(5, prestamo.isDevuelto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al registrar préstamo: " + e.getMessage());
            return false;
        }
    }

    public List<Prestamo> listarPrestamos() {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Prestamo p = new Prestamo(
                        rs.getInt("id"),
                        rs.getInt("id_socio"),
                        rs.getInt("id_ejemplar"),
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_devolucion"),
                        rs.getBoolean("devuelto")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar préstamos: " + e.getMessage());
        }
        return lista;
    }

    public boolean registrarDevolucion(int id) {
        String sql = "UPDATE prestamo SET devuelto = 1, fecha_devolucion = CURDATE() WHERE id = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al registrar devolución: " + e.getMessage());
            return false;
        }
    }
}
