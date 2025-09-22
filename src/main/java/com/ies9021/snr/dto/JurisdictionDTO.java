/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ies9021.snr.dto;

import java.sql.Date;

public class JurisdictionDTO {
    private int idJurisdiction;
    private String type;
    private String name;
    private int idUserCreate;
    private int idUserUpdate;
    private Date dateUpdate;
    private Date dateCreate;

    public JurisdictionDTO() {}

    public JurisdictionDTO(int idJurisdiction, String type, String name, int idUserCreate, int idUserUpdate, Date dateUpdate, Date dateCreate) {
        this.idJurisdiction = idJurisdiction;
        this.type = type;
        this.name = name;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateUpdate = dateUpdate;
        this.dateCreate = dateCreate;
    }

    public int getIdJurisdiction() { return idJurisdiction; }
    public void setIdJurisdiction(int idJurisdiction) { this.idJurisdiction = idJurisdiction; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(int idUserCreate) { this.idUserCreate = idUserCreate; }

    public int getIdUserUpdate() { return idUserUpdate; }
    public void setIdUserUpdate(int idUserUpdate) { this.idUserUpdate = idUserUpdate; }

    public Date getDateUpdate() { return dateUpdate; }
    public void setDateUpdate(Date dateUpdate) { this.dateUpdate = dateUpdate; }

    public Date getDateCreate() { return dateCreate; }
    public void setDateCreate(Date dateCreate) { this.dateCreate = dateCreate; }
}
