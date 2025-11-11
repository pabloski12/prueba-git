package com.biblioteca.dao;

import com.mycompany.sistemabiblioteca.model.Libro;
import com.mycompany.sistemabiblioteca.util.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public boolean insertar(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, categoria, anio_publicacion, editorial) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getCategoria());
            ps.setInt(4, libro.getAnioPublicacion());
            ps.setString(5, libro.getEditorial());
            ps.executeUpdate();
            System.out.println("✅ Libro insertado correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar libro: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM libro WHERE id = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar libro: " + e.getMessage());
            return false;
        }
    }

    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = Conexion.getConexion();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Libro l = new Libro();
                l.setId(rs.getInt("id"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setCategoria(rs.getString("categoria"));
                l.setAnioPublicacion(rs.getInt("anio_publicacion"));
                l.setEditorial(rs.getString("editorial"));
                lista.add(l);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al listar libros: " + e.getMessage());
        }
        return lista;
    }
}
