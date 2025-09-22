/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ies9021.snr.service;

import com.ies9021.snr.dao.JurisdictionDAO;
import com.ies9021.snr.dto.JurisdictionDTO;
import java.util.List;

public class JurisdictionService {
    private JurisdictionDAO dao;

    public JurisdictionService() {
        dao = new JurisdictionDAO();
    }

    public void createJurisdiction(JurisdictionDTO dto) {
        dao.createJurisdiction(dto.getIdJurisdiction(), dto.getName(), dto.getType(),
                dto.getIdUserCreate(), dto.getIdUserUpdate());
    }

    public List<JurisdictionDTO> getAllJurisdictions() {
        return dao.readJurisdiction().stream().map(j -> 
            new JurisdictionDTO(j.getId_jurisdiction(), j.getName(), j.getType(), 
                                j.getId_user_create(), j.getId_user_update(),
                                j.getDate_update(), j.getDate_create()))
            .toList();
    }

    public void updateJurisdiction(JurisdictionDTO dto) {
        dao.updateJurisdiction(dto.getIdJurisdiction(), dto.getName(), dto.getType(),
                dto.getIdUserUpdate());
    }

    public void deleteJurisdiction(int id) {
        dao.deleteJurisdiction(id);
    }
}

