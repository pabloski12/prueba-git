package com.ies9021.snr.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Advertising {

    private Integer id_advertising;
    private String company;
    private String message;
    private String image_url;
    private Date start_date;
    private Date end_date;
    private Integer is_active;
    private Integer id_user_create;
    private Integer id_user_update;
    private Timestamp date_create;
    private Timestamp date_update;

    public Advertising() {}
    

    public Integer getId_advertising() {
        return id_advertising;
    }

    public void setId_advertising(Integer id_advertising) {
        this.id_advertising = id_advertising;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }
    
    public Timestamp getDate_update() {
        return date_update;
    }

    public void setDate_update(Timestamp date_update) {
        this.date_update = date_update;
    }
    

    public Integer getId_user_create() {
        return id_user_create;
    }

    public void setId_user_create(Integer id_user_create) {
        this.id_user_create = id_user_create;
    }

    public Integer getId_user_update() {
        return id_user_update;
    }

    public void setId_user_update(Integer id_user_update) {
        this.id_user_update = id_user_update;
    }

    public Timestamp getDate_create() {
        return date_create;
    }

    public void setDate_create(Timestamp date_create) {
        this.date_create = date_create;
    }
}