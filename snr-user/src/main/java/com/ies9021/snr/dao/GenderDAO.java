package com.ies9021.snr.dao;

import com.ies9021.snr.config.DbConnection;
import com.ies9021.snr.model.Gender;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenderDAO {
    
    private Connection connection;

    public GenderDAO() {
        try {
            this.connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cerrar conexión --------------------------------------------------------------------------------
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada - GenderDAO");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Obtener todos los géneros ----------------------------------------------------------------------
    public List<Gender> getAllGenders() {
        List<Gender> genders = new ArrayList<>();
        String sql = "SELECT * FROM gender_users ORDER BY id_gender";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Gender gender = mapResultSetToGender(rs);
                genders.add(gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return genders;
    }

    // Obtener un género por ID ----------------------------------------------------------------------
    public Gender getGenderById(int idGender) {
        String sql = "SELECT * FROM gender_users WHERE id_gender = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idGender);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapResultSetToGender(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Insertar un género -----------------------------------------------------------------------------
    public boolean insertGender(Gender gender) {
        String sql = "INSERT INTO gender_users (name_gender) VALUES (?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, gender.getNameGender());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar un género ---------------------------------------------------------------------------
    public boolean updateGender(Gender gender) {
        String sql = "UPDATE gender_users SET name_gender = ? WHERE id_gender = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, gender.getNameGender());
            stmt.setInt(2, gender.getIdGender());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar un género -----------------------------------------------------------------------------
    public boolean deleteGender(int idGender) {
        String sql = "DELETE FROM gender_users WHERE id_gender = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idGender);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mapeo del resultado ---------------------------------------------------------------------------
    private Gender mapResultSetToGender(ResultSet rs) throws SQLException {
        Gender gender = new Gender();
        gender.setIdGender(rs.getInt("id_gender"));
        gender.setNameGender(rs.getString("name_gender"));
        return gender;
    }
}
