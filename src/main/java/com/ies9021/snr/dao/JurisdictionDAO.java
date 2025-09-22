/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ies9021.snr.dao;

import com.ies9021.snr.config.DbConnection;
import com.ies9021.snr.model.Jurisdiction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JurisdictionDAO {
    
    public void createJurisdiction(int id_jurisdiction, String name, String type,
                                   int id_user_create, int id_user_update) {
        String query = "INSERT INTO jurisdiction (id_jurisdiction,name,type,id_user_create,id_user_update,date_update,date_create) VALUES (?,?,?,?,?,?,?)";
        Date now = new Date(System.currentTimeMillis());
        
        try (Connection con = DbConnection.conectar();
             PreparedStatement psCreator = con.prepareStatement(query)) {
            
            psCreator.setInt(1, id_jurisdiction);
            psCreator.setString(2, name);
            psCreator.setString(3, type);
            psCreator.setInt(4, id_user_create);
            psCreator.setInt(5, id_user_update);
            psCreator.setDate(6, now);
            psCreator.setDate(7, now);

            psCreator.executeUpdate();
            System.out.println("Successful Creation");
            System.out.println("------------------------------------------------------------------------");

        } catch (SQLException ex) {
            System.out.println("An Error Occurred While Creating");
            ex.printStackTrace();
        }
    }
    
    public List<Jurisdiction> readJurisdiction() {
        String query = "SELECT * FROM jurisdiction";
        List<Jurisdiction> listJurisdiction = new ArrayList<>();
        
        try (Connection con = DbConnection.conectar();
             PreparedStatement psReader = con.prepareStatement(query);
             ResultSet rs = psReader.executeQuery()) {
            
            while (rs.next()) {
                listJurisdiction.add(new Jurisdiction(
                    rs.getInt("id_jurisdiction"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getInt("id_user_create"),
                    rs.getInt("id_user_update"),
                    rs.getDate("date_update"),
                    rs.getDate("date_create")
                ));
            }
            
            System.out.println("Successful Reading");
            System.out.println("------------------------------------------------------------------------");
            
        } catch (SQLException ex) {
            System.out.println("An Error Occurred While Reading");
            ex.printStackTrace();
        }
        return listJurisdiction;
    }
    
    public void updateJurisdiction(int id_jurisdiction, String name, String type,
                                   int id_user_update) {
        String query = "UPDATE jurisdiction SET type=?, name=?, id_user_update=?, date_update=? WHERE id_jurisdiction=?";
        Date now = new Date(System.currentTimeMillis());
        
        try (Connection con = DbConnection.conectar();
             PreparedStatement psUpdater = con.prepareStatement(query)) {
            
            psUpdater.setString(1, type);
            psUpdater.setString(2, name);
            psUpdater.setInt(3, id_user_update);
            psUpdater.setDate(4, now);
            psUpdater.setInt(5, id_jurisdiction);

            psUpdater.executeUpdate();
            System.out.println("Successful Update");
            System.out.println("------------------------------------------------------------------------");
            
        } catch (SQLException ex) {
            System.out.println("An Error Occurred While Updating");
            ex.printStackTrace();
        }
    }
    
    public void deleteJurisdiction(int id_jurisdiction) {
        String query = "DELETE FROM jurisdiction WHERE id_jurisdiction=?";
        
        try (Connection con = DbConnection.conectar();
             PreparedStatement psDeleter = con.prepareStatement(query)) {
            
            psDeleter.setInt(1, id_jurisdiction);

            psDeleter.executeUpdate();
            System.out.println("Successful Deletion");
            System.out.println("------------------------------------------------------------------------");
            
        } catch (SQLException ex) {
            System.out.println("An Error Occurred While Deleting");
            ex.printStackTrace();
        }
    }
}
