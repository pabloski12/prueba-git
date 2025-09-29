package com.ies9021.snr.dao;

import com.ies9021.snr.model.Advertising;
import com.ies9021.snr.config.DbConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlAdvertisingDao implements AdvertisingDAO {

    private static final Logger logger = Logger.getLogger(MySqlAdvertisingDao.class.getName());

    private static final String SQL_INSERT =
        "INSERT INTO advertising (company, message, image_url, start_date, end_date, is_active, id_user_create, id_user_update, date_create) VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW())";
    
    private static final String SQL_FIND_BY_ID =
        "SELECT id_advertising, company, message, image_url, start_date, end_date, is_active, date_update, id_user_create, id_user_update FROM advertising WHERE id_advertising = ?";
    private static final String SQL_FIND_ALL =
        "SELECT id_advertising, company, message, image_url, start_date, end_date, is_active, date_update, id_user_create, id_user_update FROM advertising ORDER BY id_advertising DESC";
    
    private static final String SQL_UPDATE = 
        "UPDATE advertising SET company=?, message=?, image_url=?, start_date=?, end_date=?, is_active=?, id_user_update=?, date_update = NOW() WHERE id_advertising=?";
    
    private static final String SQL_DELETE =
        "DELETE FROM advertising WHERE id_advertising = ?";


    @Override
    public int create(Advertising ad) {
        int generatedId = -1;
        Connection conn = null;

        try {
            conn = DbConnection.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, ad.getCompany());
            ps.setString(2, ad.getMessage());
            ps.setString(3, ad.getImage_url()); 
            ps.setDate(4, ad.getStart_date()); 
            ps.setDate(5, ad.getEnd_date());
            ps.setInt(6, ad.getIs_active());
            ps.setInt(7, ad.getId_user_create());
            ps.setInt(8, ad.getId_user_update());
            
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        generatedId = rs.getInt(1);
                    }
                }
                conn.commit();
            } else {
                conn.rollback();
            }
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al crear publicidad. SQL State: " + e.getSQLState() + " Error Code: " + e.getErrorCode(), e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "Error al intentar rollback.", ex);
            }
            throw new RuntimeException("Error de BD: no se pudo crear la publicidad. Causa: " + e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "Error al cerrar conexión.", ex);
                }
            }
        }
        return generatedId;
    }
    @Override
    public Advertising findById(int id) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_FIND_BY_ID)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToAdvertising(rs);
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error al buscar publicidad #" + id, e);
            throw new RuntimeException("error de bd: no se pudo buscar la publicidad.", e);
        }
        return null;
    }

    @Override
    public List<Advertising> findAll() {
        List<Advertising> ads = new ArrayList<>();

        try (Connection conn = DbConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(SQL_FIND_ALL)) {

            while (rs.next()) {
                ads.add(mapResultSetToAdvertising(rs));
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error al obtener todas las publicidades.", e);
            throw new RuntimeException("error de bd: no se pudo cargar el listado.", e);
        }
        return ads;
    }

    @Override
    public boolean update(Advertising ad) {
        Connection conn = null;
        
        try {
            conn = DbConnection.getConnection();
            conn.setAutoCommit(false);

            PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
            
            ps.setString(1, ad.getCompany());
            ps.setString(2, ad.getMessage());
            ps.setString(3, ad.getImage_url());
            ps.setDate(4, ad.getStart_date()); 
            ps.setDate(5, ad.getEnd_date());   
            ps.setInt(6, ad.getIs_active());
            ps.setInt(7, ad.getId_user_update());
            ps.setInt(8, ad.getId_advertising());
            
            int affectedRows = ps.executeUpdate();
            
            if (affectedRows > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error al actualizar publicidad #" + ad.getId_advertising() + " SQL State: " + e.getSQLState() + " Error Code: " + e.getErrorCode(), e);
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "error al intentar rollback.", ex);
            }
            throw new RuntimeException("error de bd: no se pudo actualizar la publicidad. Causa: " + e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    logger.log(Level.SEVERE, "error al cerrar conexión.", ex);
                }
            }
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(SQL_DELETE)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "error al eliminar publicidad #" + id, e);
            throw new RuntimeException("error de bd: no se pudo eliminar la publicidad.", e);
        }
    }

    
    private Advertising mapResultSetToAdvertising(ResultSet rs) throws SQLException {
        Advertising ad = new Advertising();
        ad.setId_advertising(rs.getInt("id_advertising"));
        ad.setCompany(rs.getString("company"));
        ad.setMessage(rs.getString("message"));
        
        try {
            ad.setImage_url(rs.getString("image_url"));
        } catch (SQLException ignore) {
        }
        
        ad.setStart_date(rs.getDate("start_date")); 
        ad.setEnd_date(rs.getDate("end_date"));     
        ad.setIs_active(rs.getInt("is_active"));
        ad.setDate_update(rs.getTimestamp("date_update"));
        
        try {
            ad.setId_user_create(rs.getInt("id_user_create"));
            ad.setId_user_update(rs.getInt("id_user_update"));
        } catch (SQLException ignore) {
        }
        
        return ad;
    }
}