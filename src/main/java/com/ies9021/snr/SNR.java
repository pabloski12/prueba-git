package com.ies9021.snr;

import com.ies9021.snr.config.DbConnection;
import com.ies9021.snr.controller.AdvertisingController;
import com.ies9021.snr.dao.MySqlAdvertisingDao;
import com.ies9021.snr.service.AdvertisingService;
import com.ies9021.snr.view.AdvertisingPrincipalForm;

import java.sql.Connection;
import java.sql.SQLException;

public class SNR {

    public static void main(String[] args) {
        
        try (Connection conn = DbConnection.getConnection()) {
            System.out.println("Conexión a la base de datos establecida correctamente.");
        } catch (SQLException e) {
            System.err.println("ERROR: No se pudo conectar a la base de datos.");
            System.err.println("Verifica tus credenciales en DbConnection.java o que MySQL esté corriendo.");
            return;
        }
        
        MySqlAdvertisingDao advertisingDao = new MySqlAdvertisingDao();
        
        AdvertisingService advertisingService = new AdvertisingService(advertisingDao);
        
        AdvertisingController advertisingController = new AdvertisingController(advertisingService);
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new AdvertisingPrincipalForm(advertisingController).setVisible(true);
            } catch (Exception e) {
                System.err.println("Error al iniciar el formulario principal.");
            }
        });
    }
}