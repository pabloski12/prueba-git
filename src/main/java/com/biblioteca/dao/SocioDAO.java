package com.biblioteca.dao;

import com.mycompany.sistemabiblioteca.model.Socio;
import com.mycompany.sistemabiblioteca.util.Conexion;
import java.sql.*;
import java.util.*;

public class SocioDAO {

    public boolean agregarSocio(Socio socio) {
        String sql = "INSERT INTO socio (nombre, apellido, dni, email, validado) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getApellido());
            ps.setString(3, socio.getDni());
            ps.setString(4, socio.getEmail());
            ps.setBoolean(5, socio.isValidado());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al agregar socio: " + e.getMessage());
            return false;
        }
    }

    public List<Socio> listarSocios() {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT * FROM socio";
        try (Connection con = Conexion.getConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Socio s = new Socio(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("dni"),
                    rs.getString("email"),
                    rs.getBoolean("validado")
                );
                lista.add(s);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar socios: " + e.getMessage());
        }
        return lista;
    }

    public boolean eliminarSocio(int id) {
        String sql = "DELETE FROM socio WHERE id=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar socio: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarSocio(Socio socio) {
        String sql = "UPDATE socio SET nombre=?, apellido=?, dni=?, email=?, validado=? WHERE id=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, socio.getNombre());
            ps.setString(2, socio.getApellido());
            ps.setString(3, socio.getDni());
            ps.setString(4, socio.getEmail());
            ps.setBoolean(5, socio.isValidado());
            ps.setInt(6, socio.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar socio: " + e.getMessage());
            return false;
        }
    }
}
