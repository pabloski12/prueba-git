package com.ies9021.snr.dao;

import com.ies9021.snr.model.User;
import com.ies9021.snr.config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // INSERT
    public boolean insertUser(User u) {
        String sql = "INSERT INTO usuarios (nombre, email, password, dni, genero) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getDni());
            ps.setInt(5, u.getIdGender());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error insertUser(): " + e.getMessage());
            return false;
        }
    }

    // UPDATE
    public boolean updateUser(User u) {
        String sql = "UPDATE usuarios SET nombre=?, email=?, password=?, dni=?, genero=? WHERE idUser=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getDni());
            ps.setInt(5, u.getIdGender());
            ps.setInt(6, u.getIdUser());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updateUser(): " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean deleteUser(int idUser) {
        String sql = "DELETE FROM usuarios WHERE idUser=?";

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleteUser(): " + e.getMessage());
            return false;
        }
    }

    // GET BY ID
    public User getUserById(int idUser) {
        String sql = "SELECT * FROM usuarios WHERE idUser=?";
        User u = null;

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setDni(rs.getString("dni"));
                u.setIdGender(rs.getInt("genero"));
            }

        } catch (SQLException e) {
            System.out.println("Error getUserById(): " + e.getMessage());
        }

        return u;
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM usuarios";
        List<User> lista = new ArrayList<>();

        try (Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setName(rs.getString("nombre"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("password"));
                u.setDni(rs.getString("dni"));
                u.setIdGender(rs.getInt("genero"));

                lista.add(u);
            }

        } catch (SQLException e) {
            System.out.println("Error getAllUsers(): " + e.getMessage());
        }

        return lista;
    }
}
