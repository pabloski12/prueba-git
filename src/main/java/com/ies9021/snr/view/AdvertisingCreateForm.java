package com.ies9021.snr.view;

import com.ies9021.snr.controller.AdvertisingController;
import com.ies9021.snr.model.Advertising;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import java.util.logging.Logger;
    
public class AdvertisingCreateForm extends javax.swing.JFrame {
    
    private static final Logger logger = Logger.getLogger(AdvertisingCreateForm.class.getName());
    
    private final AdvertisingController controller;
    private boolean editMode = false;
    private Integer editingId = null;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private void loadAdvertisingData(int id) {
        Advertising ad = controller.findById(id);
        if (ad != null) {
            txtCompania.setText(ad.getCompany());
            txtMensaje.setText(ad.getMessage());
            txtImagenUrl.setText(ad.getImage_url());
            
            if (ad.getStart_date() != null) {
                txtFechaInicio.setText(ad.getStart_date().toLocalDate().format(DATE_FORMATTER));
            }
            if (ad.getEnd_date() != null) {
                txtFechaFin.setText(ad.getEnd_date().toLocalDate().format(DATE_FORMATTER));
            }
            
            chkActivo.setSelected(ad.getIs_active() == 1);
            btnGuardar.setText("Actualizar");
        } else {
            JOptionPane.showMessageDialog(this, "Error: Publicidad no encontrada.", "Error de Carga", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }

    public AdvertisingCreateForm(AdvertisingController controller) {
        this.controller = controller;
        initComponents();
        setTitle("Nueva Publicidad");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        chkActivo.setSelected(true);
    }

    public AdvertisingCreateForm(AdvertisingController controller, Integer idToEdit) {
    this.controller = controller;
    this.editMode = true;
    this.editingId = idToEdit;
    initComponents();
    setTitle("Editar Publicidad #" + idToEdit);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    
    try {
        loadAdvertisingData(idToEdit); 
    } catch (Exception e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al iniciar formulario de edición", e);
        JOptionPane.showMessageDialog(this, 
                "Error al cargar la publicidad para editar: " + e.getMessage(), 
                "Error Crítico de Carga", 
                JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCompania = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        txtImagenUrl = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        chkActivo = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCompania.setText("Compañía");

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        txtMensaje.setText("Mensaje");
        jScrollPane1.setViewportView(txtMensaje);

        txtImagenUrl.setText("images/(URL de Imagen)");
        txtImagenUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImagenUrlActionPerformed(evt);
            }
        });

        txtFechaInicio.setText("Día/Mes/Año");
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        txtFechaFin.setText("Día/Mes/Año");

        chkActivo.setText("\tActiva");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Compañia");

        jLabel2.setText("Mensaje");

        jLabel3.setText("Imagen");

        jLabel4.setText("Fecha Inicio");

        jLabel5.setText("Fecha Fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCompania, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(chkActivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtImagenUrl, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtImagenUrl)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaInicio)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkActivo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    try {
        String company = txtCompania.getText().trim();
        String message = txtMensaje.getText().trim();
        String imageUrl = txtImagenUrl.getText().trim();
        String startStr = txtFechaInicio.getText().trim();
        String endStr = txtFechaFin.getText().trim();
        int isActive = chkActivo.isSelected() ? 1 : 0;

        if (company.isEmpty() || startStr.isEmpty() || endStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe completar la Compañía y ambas Fechas.", "Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        java.sql.Date startDate = java.sql.Date.valueOf(java.time.LocalDate.parse(startStr, DATE_FORMATTER));
        java.sql.Date endDate = java.sql.Date.valueOf(java.time.LocalDate.parse(endStr, DATE_FORMATTER));
        
        Advertising ad = new Advertising();
        ad.setCompany(company);
        ad.setMessage(message);
        ad.setImage_url(imageUrl);
        ad.setStart_date(startDate);
        ad.setEnd_date(endDate);
        ad.setIs_active(isActive);
        
        int userId = 1; 
        ad.setId_user_update(userId);
        if (!editMode) {
            ad.setId_user_create(userId);
        }

        boolean success = false;
        String action = editMode ? "actualizar" : "crear";

        if (editMode) {
            ad.setId_advertising(editingId);
            success = controller.update(ad);
        } else {
            int newId = controller.create(ad);
            if (newId > 0) {
                success = true;
                this.editingId = newId; 
                this.editMode = true; 
                setTitle("Editar Publicidad #" + newId);
            }
        }

        if (success) {
            JOptionPane.showMessageDialog(this, 
                    "Publicidad " + action + " con éxito.", 
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (editMode) {
             JOptionPane.showMessageDialog(this, "La publicidad no fue modificada (no se detectaron cambios).", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
             JOptionPane.showMessageDialog(this, "Error al crear la publicidad: El ID no fue generado.", "Error de Persistencia", JOptionPane.ERROR_MESSAGE);
        }

    } catch (java.time.format.DateTimeParseException ex) {
        JOptionPane.showMessageDialog(this, "Formato de fecha inválido. Use dd/MM/yyyy.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
    } catch (RuntimeException ex) { 
        logger.log(java.util.logging.Level.SEVERE, "Error de BD/DAO:", ex);
        JOptionPane.showMessageDialog(this, 
            "Error de Base de Datos: No se pudo guardar. Revise la consola para el stack trace completo.", 
            "Error Crítico", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtImagenUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImagenUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImagenUrlActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCompania;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtImagenUrl;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
