/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ies9021.snr.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Emanuel
 */
public class JurisdictionForm extends javax.swing.JFrame {
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private JTextField txtId, txtName, txtType, txtEntity;
    private JTable table;
    private DefaultTableModel model;
    private Connection conn;

    public JurisdictionForm() {
        // Config ventana
        setTitle("CRUD Jurisdiction");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Conectar a BD
        connectDB();

        // Panel superior (formularios)
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 5, 5));
        panelForm.add(new JLabel("ID Jurisdiction:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Name:"));
        txtName = new JTextField();
        panelForm.add(txtName);

        panelForm.add(new JLabel("Type:"));
        txtType = new JTextField();
        panelForm.add(txtType);

        panelForm.add(new JLabel("ID Entity:"));
        txtEntity = new JTextField();
        panelForm.add(txtEntity);

        // Panel botones
        JPanel panelButtons = new JPanel();
        JButton btnAdd = new JButton("Agregar");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");
        JButton btnClear = new JButton("Limpiar");
        panelButtons.add(btnAdd);
        panelButtons.add(btnUpdate);
        panelButtons.add(btnDelete);
        panelButtons.add(btnClear);

        // Tabla
        model = new DefaultTableModel(new String[]{"ID", "Name", "Type", "Entity"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        // Layout general
        add(panelForm, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        // Listeners botones
        btnAdd.addActionListener(e -> addJurisdiction());
        btnUpdate.addActionListener(e -> updateJurisdiction());
        btnDelete.addActionListener(e -> deleteJurisdiction());
        btnClear.addActionListener(e -> clearFields());

        // Listener tabla (clic en fila → carga en form)
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                int row = table.getSelectedRow();
                txtId.setText(model.getValueAt(row, 0).toString());
                txtName.setText(model.getValueAt(row, 1).toString());
                txtType.setText(model.getValueAt(row, 2).toString());
                txtEntity.setText(model.getValueAt(row, 3).toString());
            }
        });

        loadData();
    }
 private void connectDB() {
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/reclamos", // Cambia "reclamos" por tu BD
                "root",    // usuario MySQL
                ""         // contraseña MySQL
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error de conexión: " + e.getMessage());
        }
    }

    private void loadData() {
        model.setRowCount(0);
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM jurisdiction");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_jurisdiction"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getInt("id_entity")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos: " + e.getMessage());
        }
    }

    private void addJurisdiction() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO jurisdiction VALUES (?, ?, ?, ?)");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.setString(2, txtName.getText());
            ps.setString(3, txtType.getText());
            ps.setInt(4, Integer.parseInt(txtEntity.getText()));
            ps.executeUpdate();
            loadData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar: " + e.getMessage());
        }
    }

    private void updateJurisdiction() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "UPDATE jurisdiction SET name=?, type=?, id_entity=? WHERE id_jurisdiction=?");
            ps.setString(1, txtName.getText());
            ps.setString(2, txtType.getText());
            ps.setInt(3, Integer.parseInt(txtEntity.getText()));
            ps.setInt(4, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            loadData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar: " + e.getMessage());
        }
    }

    private void deleteJurisdiction() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM jurisdiction WHERE id_jurisdiction=?");
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            loadData();
            clearFields();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtType.setText("");
        txtEntity.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JurisdictionForm().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    public Object getBtnAdd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getBtnUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getBtnDelete() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getBtnClear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTxtId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTxtType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTxtName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTxtUserCreate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getTxtUserUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
