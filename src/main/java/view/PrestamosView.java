/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PrestamosView extends javax.swing.JFrame {
private DefaultTableModel modelo;

    public PrestamosView() {
        initComponents();
        setTitle("Gestión de Préstamos y Reservas");
this.setLocationRelativeTo(null);

String[] columnas = {"ID", "Socio", "Libro", "Fecha Préstamo", "Fecha Devolución", "Estado"};
modelo = new DefaultTableModel(columnas, 0);
tblPrestamos.setModel(modelo);
// Asocia los botones a sus acciones
btnregistrar.addActionListener(e -> registrarPrestamo());
btnverprestamo.addActionListener(e -> verPrestamos());
bnregistrarprest.addActionListener(e -> registrarDevolucion());
btnvolvermenu.addActionListener(e -> volverMenu());


    }
    private void registrarPrestamo() {
    String socio = txtSocio.getText();
    String libro = txtLibro.getText();
    String fechaPrestamo = txtFechaPrestamo.getText().isEmpty() ? java.time.LocalDate.now().toString() : txtFechaPrestamo.getText();
    String fechaDevolucion = txtFechaDevolucion.getText().isEmpty() ? "Pendiente" : txtFechaDevolucion.getText();

    if (socio.isEmpty() || libro.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar el socio y el libro.");
        return;
    }

    int id = modelo.getRowCount() + 1;
    modelo.addRow(new Object[]{id, socio, libro, fechaPrestamo, fechaDevolucion, "Activo"});
    javax.swing.JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente.");

    // Limpia campos
    txtSocio.setText("");
    txtLibro.setText("");
    txtFechaPrestamo.setText("");
    txtFechaDevolucion.setText("");
}

private void verPrestamos() {
    if (modelo.getRowCount() == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "No hay préstamos registrados.");
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Mostrando préstamos activos.");
        // Opcional: podés abrir un diálogo o simplemente dejar la tabla visible
    }
}

private void registrarDevolucion() {
    int fila = tblPrestamos.getSelectedRow();
    if (fila == -1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione un préstamo para registrar su devolución.");
        return;
    }
    modelo.setValueAt("Devuelto", fila, 5); // columna Estado
    modelo.setValueAt(java.time.LocalDate.now().toString(), fila, 4); // columna Fecha Devolución
    javax.swing.JOptionPane.showMessageDialog(this, "Devolución registrada correctamente.");
}

private void volverMenu() {
    new MenuPrincipalView().setVisible(true);
    this.dispose();
}

    private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {                                            
    String socio = JOptionPane.showInputDialog(this, "Ingrese el nombre del socio:");
    String libro = JOptionPane.showInputDialog(this, "Ingrese el título del libro:");

    if (socio == null || socio.isEmpty() || libro == null || libro.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe ingresar el socio y el libro.");
        return;
    }

    int id = modelo.getRowCount() + 1;
    modelo.addRow(new Object[]{id, socio, libro, "2025-11-10", "—", "Activo"});
    JOptionPane.showMessageDialog(this, "Préstamo registrado exitosamente.");
}                                           

private void btnverprestamoActionPerformed(java.awt.event.ActionEvent evt) {                                              
    if (modelo.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No hay préstamos registrados.");
        return;
    }
    JOptionPane.showMessageDialog(this, "Mostrando todos los préstamos activos.");
}                                             

private void bnregistrarprestActionPerformed(java.awt.event.ActionEvent evt) {                                               
    int fila = tblPrestamos.getSelectedRow();
    if (fila == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un préstamo para registrar su devolución.");
        return;
    }

    modelo.setValueAt("Devuelto", fila, 5);
    modelo.setValueAt("2025-11-10", fila, 4);
    JOptionPane.showMessageDialog(this, "Devolución registrada correctamente.");
}                                              

private void btnvolvermenuActionPerformed(java.awt.event.ActionEvent evt) {                                             
    new MenuPrincipalView().setVisible(true);
    this.dispose();
}     


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnverprestamo = new javax.swing.JButton();
        bnregistrarprest = new javax.swing.JButton();
        btnvolvermenu = new javax.swing.JButton();
        btnregistrar = new javax.swing.JButton();
        scrollPrestamos = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        txtFechaPrestamo = new javax.swing.JTextField();
        txtLibro = new javax.swing.JTextField();
        txtFechaDevolucion = new javax.swing.JTextField();
        txtSocio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("GESTION DE PRESTAMOS Y RESERVAS");

        btnverprestamo.setText("VER PRÉSTAMOS ACTIVOS");

        bnregistrarprest.setText("REGISTRAR DEVOLUCIÓN");

        btnvolvermenu.setText("VOLVER AL MENÚ PRINCIPAL");

        btnregistrar.setText("REGISTRAR PRÉSTAMO");

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollPrestamos.setViewportView(tblPrestamos);

        txtSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSocioActionPerformed(evt);
            }
        });

        jLabel2.setText("Socio:");

        jLabel3.setText("Fecha Prestamo:");

        jLabel4.setText("Libro:");

        jLabel5.setText("Fecha de Devolución:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(bnregistrarprest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnregistrar)
                .addGap(49, 49, 49)
                .addComponent(btnverprestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnvolvermenu, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(105, 105, 105))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaDevolucion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bnregistrarprest)
                            .addComponent(btnregistrar)
                            .addComponent(btnverprestamo))
                        .addGap(24, 24, 24)
                        .addComponent(scrollPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvolvermenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSocioActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnregistrarprest;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JButton btnverprestamo;
    private javax.swing.JButton btnvolvermenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scrollPrestamos;
    private javax.swing.JTable tblPrestamos;
    private javax.swing.JTextField txtFechaDevolucion;
    private javax.swing.JTextField txtFechaPrestamo;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtSocio;
    // End of variables declaration//GEN-END:variables
}
