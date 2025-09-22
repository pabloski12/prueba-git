/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ies9021.snr.model;

import java.sql.Date;


public class Jurisdiction {
    private int id_jurisdiction;
    private String type;
    private String name;
    private int id_user_create;
    private int id_user_update;
    private Date date_update;
    private Date date_create;

    public Jurisdiction() {
    }

    public Jurisdiction(int id_jurisdiction, String type, String name, int id_user_create, int id_user_update, Date date_update, Date date_create) {
        this.id_jurisdiction = id_jurisdiction;
        this.type = type;
        this.name = name;
        this.id_user_create = id_user_create;
        this.id_user_update = id_user_update;
        this.date_update = date_update;
        this.date_create = date_create;
    }

    public int getId_jurisdiction() {
        return id_jurisdiction;
    }

    public void setId_jurisdiction(int id_jurisdiction) {
        this.id_jurisdiction = id_jurisdiction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_user_create() {
        return id_user_create;
    }

    public void setId_user_create(int id_user_create) {
        this.id_user_create = id_user_create;
    }

    public int getId_user_update() {
        return id_user_update;
    }

    public void setId_user_update(int id_user_update) {
        this.id_user_update = id_user_update;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

    public Date getDate_create() {
        return date_create;
    }

    public void setDate_create(Date date_create) {
        this.date_create = date_create;
    }
    
    
}
