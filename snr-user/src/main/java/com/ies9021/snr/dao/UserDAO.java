package com.ies9021.snr.dao;

import com.ies9021.snr.model.User;
import com.ies9021.snr.config.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    
    private Connection connection;

    public UserDAO() {
        try {
            this.connection = DbConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Cierra la conexión
    public void close() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada - UserDAO");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT u.*, g.name_gender FROM users u " +
                     "LEFT JOIN gender_users g ON u.id_gender = g.id_gender " +
                     "ORDER BY u.id_user";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = mapResultSetToUser(rs);
                user.setGenderName(rs.getString("name_gender"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Insertar usuario
    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (id_type_user, name, last_name, dni, email, password, " +
                     "id_gender, location_user, id_user_create, id_user_update, date_create, date_update) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setUserParameters(stmt, user);
           // stmt.setInt(9, user.getIdUserCreate ());
            //stmt.setInt(10, user.getIdUserUpdate ());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar usuario
    public boolean updateUser(User user) {
        String sql = "UPDATE users SET id_type_user=?, name=?, last_name=?, dni=?, email=?, " +
                     "password=?, id_gender=?, location_user=?, id_user_update=?, date_update=NOW() " +
                     "WHERE id_user=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            setUserParameters(stmt, user); 
           // stmt.setInt(9, user.getIdUserUpdate());
            stmt.setInt(10, user.getIdUser());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar usuario
    public boolean deleteUser(int idUser) {
        String sql = "DELETE FROM users WHERE id_user = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener usuario por ID
    public User getUserById(int idUser) {
        String sql = "SELECT u.*, g.name_gender FROM users u " +
                     "LEFT JOIN gender_users g ON u.id_gender = g.id_gender " +
                     "WHERE u.id_user = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idUser);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = mapResultSetToUser(rs);
                user.setGenderName(rs.getString("name_gender"));
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // --- MÉTODOS AUXILIARES ---

    // Setea los parámetros del PreparedStatement
    private void setUserParameters(PreparedStatement stmt, User user) throws SQLException {
        stmt.setInt(1, user.getIdTypeUser());
        stmt.setString(2, user.getName());
        stmt.setString(3, user.getLastName());
        stmt.setString(4, user.getDni());
        stmt.setString(5, user.getEmail());
        stmt.setString(6, user.getPassword());
        stmt.setInt(7, user.getIdGender());
        stmt.setString(8, user.getLocationUser());
    }

    // Mapea los resultados de la consulta a un objeto User
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt("id_user"));
        user.setIdTypeUser(rs.getInt("id_type_user"));
        user.setName(rs.getString("name"));
        user.setLastName(rs.getString("last_name"));
        user.setDni(rs.getString("dni"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setIdGender(rs.getInt("id_gender"));
        user.setLocationUser(rs.getString("location_user"));
        user.setIdUserCreate(rs.getInt("id_user_create"));
        user.setIdUserUpdate(rs.getInt("id_user_update"));
        user.setDateCreate(rs.getTimestamp("date_create").toLocalDateTime());

        Timestamp dateUpdate = rs.getTimestamp("date_update");
        if (dateUpdate != null) {
            user.setDateUpdate(dateUpdate.toLocalDateTime());
        }

        return user;
    }
}
