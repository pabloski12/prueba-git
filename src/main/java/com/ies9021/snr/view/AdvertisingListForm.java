package com.ies9021.snr.view;

import com.ies9021.snr.controller.AdvertisingController;
import com.ies9021.snr.model.Advertising; 
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.WindowConstants;

public final class AdvertisingListForm extends javax.swing.JFrame {

    private final AdvertisingController controller;
    private DefaultTableModel tableModel; 
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdvertisingListForm.class.getName());

    public AdvertisingListForm(AdvertisingController controller) {
    this.controller = controller;
    initComponents();
    setTitle("Listado de Publicidades");
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
    btnNuevo1.addActionListener(this::btnNuevoActionPerformed);
    
    btnEditar.addActionListener(this::btnEditarActionPerformed);
    btnEliminar.addActionListener(this::btnEliminarActionPerformed);
    
    initializeTable();
    loadData();
}
    
    public AdvertisingListForm() {
        this.controller = null;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVerPublicidad = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnNuevo1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVerPublicidad.setText("Ver Publicidad");
        btnVerPublicidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPublicidadActionPerformed(evt);
            }
        });

        btnEliminar.setText("Borrar");

        btnEditar.setText("Editar");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jScrollPane1);

        btnNuevo1.setText("Nuevo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVerPublicidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVerPublicidad, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerPublicidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPublicidadActionPerformed
        int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow < 0) {
        JOptionPane.showMessageDialog(this, 
            "Debe seleccionar una fila para ver la publicidad.", 
            "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Integer id = (Integer) tableModel.getValueAt(selectedRow, 0); 
    
    try {
        Advertising ad = controller.findById(id);
        
        if (ad != null) {
            AdvertisingDetailsForm detailsForm = new AdvertisingDetailsForm(ad);
            detailsForm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Error: Publicidad no encontrada.", "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    } catch (HeadlessException e) {
        JOptionPane.showMessageDialog(this, "Error al acceder a los datos: " + e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnVerPublicidadActionPerformed
private void initializeTable() {
    String[] columnNames = {"ID", "Compañía", "Mensaje", "Fecha Inicio", "Fecha Fin", "Activo"};
    tableModel = new DefaultTableModel(columnNames, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    jTable1.setModel(tableModel); 
}

public void loadData() { 
    tableModel.setRowCount(0); 
    
    if (controller == null) return;
    
    try {
        List<Advertising> ads = controller.findAll();
        
        for (Advertising ad : ads) {
            tableModel.addRow(new Object[]{
                ad.getId_advertising(),
                ad.getCompany(),
                ad.getMessage(),
                ad.getStart_date(), 
                ad.getEnd_date(),
                ad.getIs_active() == 1 ? "Sí" : "No"
            });
        }
    } catch (Exception e) {
        logger.log(java.util.logging.Level.SEVERE, "Error al cargar datos", e);
        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage(), "Error de BD", JOptionPane.ERROR_MESSAGE);
    }
}

private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {                                         
    AdvertisingCreateForm createForm = new AdvertisingCreateForm(controller);
    
    createForm.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            loadData(); 
        }
    }); 
    
    createForm.setVisible(true);
}                                        

private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {                                        
    int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow != -1) {
        try {
            Integer idToEdit = (Integer) tableModel.getValueAt(selectedRow, 0); 
            
            AdvertisingCreateForm editForm = new AdvertisingCreateForm(controller, idToEdit);
            
            editForm.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosed(java.awt.event.WindowEvent e) {
                    loadData(); 
                }
            });
            
            editForm.setVisible(true);
            
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID de la fila seleccionada. Asegure que la primera columna contenga el ID.", "Error de Datos", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}                                       

private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                          
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    Integer id = (Integer) tableModel.getValueAt(selectedRow, 0); 

    int confirm = JOptionPane.showConfirmDialog(this, 
        "¿Seguro que desea eliminar la publicidad #" + id + "?", 
        "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            if (controller.delete(id)) { 
                JOptionPane.showMessageDialog(this, "Publicidad eliminada con éxito.");
                loadData(); 
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se pudo eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
             JOptionPane.showMessageDialog(this, "Error de BD: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}                               

    /**
   
     * @param args */
public static void main(String args[]) {
java.awt.EventQueue.invokeLater(() -> new AdvertisingPrincipalForm().setVisible(true));
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnVerPublicidad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
