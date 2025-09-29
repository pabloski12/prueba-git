package com.ies9021.snr.view;

import com.ies9021.snr.model.Advertising;
import java.awt.Image;
import java.io.File;
import javax.swing.*;
import java.time.format.DateTimeFormatter;

public class AdvertisingDetailsForm extends JFrame {

    private final Advertising ad;
    
    private static final int IMAGE_DISPLAY_SIZE = 300;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AdvertisingDetailsForm(Advertising ad) {
        this.ad = ad;
        
        initComponents();
        
        setTitle("Detalles de Publicidad: " + ad.getCompany());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        
        loadDetails();
        pack();
        setLocationRelativeTo(null);
    }
    
    private void loadDetails() {
        loadImage(ad.getImage_url());
        
        String details = ad.getMessage(); 

        txtDetails.setText(details); 
        txtDetails.setCaretPosition(0); 
    }
    
    private void loadImage(String path) {
    if (path == null || path.isEmpty()) {
        lblImage.setText("<html><center>No hay imagen asociada<br>(URL vacía)</center></html>"); 
        lblImage.setPreferredSize(new java.awt.Dimension(IMAGE_DISPLAY_SIZE, IMAGE_DISPLAY_SIZE / 4));
        return;
    }
    
    String projectDir = System.getProperty("user.dir");
    
    File file = new File(projectDir, path); 
    
    if (!file.exists()) {
        lblImage.setText("<html><center>ERROR: Imagen no encontrada en:<br><b>" + file.getAbsolutePath() + "</b><br>Verifique que el archivo exista.</center></html>"); 
        lblImage.setPreferredSize(new java.awt.Dimension(IMAGE_DISPLAY_SIZE, IMAGE_DISPLAY_SIZE / 4));
        return;
    }

    try {
        ImageIcon originalIcon = new ImageIcon(file.getAbsolutePath());
        
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(
                IMAGE_DISPLAY_SIZE, 
                IMAGE_DISPLAY_SIZE, 
                Image.SCALE_SMOOTH
        );
        
        lblImage.setIcon(new ImageIcon(scaledImage)); 
        lblImage.setText(null); 
        
    } catch (Exception e) {
        lblImage.setText("Error al cargar la imagen: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetails = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDetails.setColumns(20);
        txtDetails.setRows(5);
        jScrollPane1.setViewportView(txtDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea txtDetails;
    // End of variables declaration//GEN-END:variables
}
