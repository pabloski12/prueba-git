package com.ies9021.snr.view;

import com.ies9021.snr.controller.AdvertisingController;
import com.ies9021.snr.dao.AdvertisingDAO;
import com.ies9021.snr.dao.MySqlAdvertisingDao;
import com.ies9021.snr.service.AdvertisingService;
import javax.swing.JOptionPane;

public class AdvertisingPrincipalForm extends javax.swing.JFrame {
    
    private final AdvertisingController controller;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdvertisingPrincipalForm.class.getName());

    public AdvertisingPrincipalForm(AdvertisingController controller) {
        this.controller = controller;
        initComponents();
        setTitle("Módulo de Publicidad");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    public AdvertisingPrincipalForm() {
        this.controller = null;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevaPublicidad = new javax.swing.JButton();
        btnListado = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Publicidad");

        btnNuevaPublicidad.setText("Nueva Publicidad");
        btnNuevaPublicidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPublicidadActionPerformed(evt);
            }
        });

        btnListado.setText("Listado");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevaPublicidad, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(btnListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(btnNuevaPublicidad)
                .addGap(18, 18, 18)
                .addComponent(btnListado)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
           if (controller != null) {
            AdvertisingListForm listado = new AdvertisingListForm(controller);
            listado.setLocationRelativeTo(this);
            listado.setVisible(true);
        } else {
            logger.warning("Controller is null. Cannot open AdvertisingListForm.");
        }
    }//GEN-LAST:event_btnListadoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevaPublicidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPublicidadActionPerformed
        if (controller != null) {
        AdvertisingCreateForm pantalla = new AdvertisingCreateForm(controller);
        pantalla.setLocationRelativeTo(this);
        pantalla.setVisible(true);
    } else {
        logger.warning("Controller is null. Cannot open AdvertisingCreateForm.");
    }//GEN-LAST:event_btnNuevaPublicidadActionPerformed
}  
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     AdvertisingController controller = null;

        try {
            AdvertisingDAO dao = new MySqlAdvertisingDao(); 
            AdvertisingService service = new AdvertisingService(dao);
            controller = new AdvertisingController(service);

        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, 
                "ERROR CRÍTICO DE CONEXIÓN A LA BASE DE DATOS:\n" + e.getMessage() + 
                "\n\nLa aplicación se abrirá, pero no podrá cargar ni guardar datos hasta que resuelvas este problema.", 
                "Error de Base de Datos", 
                JOptionPane.ERROR_MESSAGE
            );
        }
        
        final AdvertisingController finalController = controller;
        
        java.awt.EventQueue.invokeLater(() -> {
            new AdvertisingPrincipalForm(finalController).setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListado;
    private javax.swing.JButton btnNuevaPublicidad;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
