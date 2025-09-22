/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ies9021.snr.controller;

import com.ies9021.snr.dto.JurisdictionDTO;
import com.ies9021.snr.service.JurisdictionService;
import com.ies9021.snr.view.JurisdictionForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class JurisdictionController {

    private final JurisdictionForm form;
    private final JurisdictionService service;

    public JurisdictionController(JurisdictionForm form) {
        this.form = form;
        this.service = new JurisdictionService();
        initController();
        loadTableData();
    }

    private void initController() {
        form.getBtnAdd().addActionListener(e -> addJurisdiction());
        form.getBtnUpdate().addActionListener(e -> updateJurisdiction());
        form.getBtnDelete().addActionListener(e -> deleteJurisdiction());
        form.getBtnClear().addActionListener(e -> form.clearFields());
    }

    // ===== Carga los datos en la tabla =====
    private void loadTableData() {
        DefaultTableModel model = (DefaultTableModel) form.getTable().getModel();
        model.setRowCount(0); // limpia tabla

        List<JurisdictionDTO> list = service.getAllJurisdictions();
        for (JurisdictionDTO dto : list) {
            model.addRow(new Object[]{
                    dto.getIdJurisdiction(),
                    dto.getType(),
                    dto.getName()
            });
        }
    }

    // ===== CRUD =====
    private void addJurisdiction() {
        try {
            JurisdictionDTO dto = new JurisdictionDTO();
            dto.setIdJurisdiction(Integer.parseInt(form.getTxtId().getText()));
            dto.setType(form.getTxtType().getText());
            dto.setName(form.getTxtName().getText());
            // Para ejemplo, se usa 1 como usuario creador y actualizador
            dto.setIdUserCreate(1);
            dto.setIdUserUpdate(1);

            service.createJurisdiction(dto);
            JOptionPane.showMessageDialog(form, "Jurisdiction agregada correctamente.");
            form.clearFields();
            loadTableData();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Error al agregar: " + ex.getMessage());
        }
    }

    private void updateJurisdiction() {
        try {
            JurisdictionDTO dto = new JurisdictionDTO();
            dto.setIdJurisdiction(Integer.parseInt(form.getTxtId().getText()));
            dto.setType(form.getTxtType().getText());
            dto.setName(form.getTxtName().getText());
            dto.setIdUserUpdate(1); // usuario que actualiza

            service.updateJurisdiction(dto);
            JOptionPane.showMessageDialog(form, "Jurisdiction actualizada correctamente.");
            form.clearFields();
            loadTableData();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Error al actualizar: " + ex.getMessage());
        }
    }

    private void deleteJurisdiction() {
        try {
            int id = Integer.parseInt(form.getTxtId().getText());
            int confirm = JOptionPane.showConfirmDialog(form,
                    "¿Está seguro que desea eliminar esta jurisdicción?", "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                service.deleteJurisdiction(id);
                JOptionPane.showMessageDialog(form, "Jurisdiction eliminada correctamente.");
                form.clearFields();
                loadTableData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(form, "Error al eliminar: " + ex.getMessage());
        }
    }
}

