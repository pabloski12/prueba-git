package com.ies9021.snr.model;

import java.time.LocalDateTime;

public class User {

    private int idUser;
    private int idTypeUser;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private int idGender;
    private String locationUser;
    private int idUserCreate;
    private int idUserUpdate;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;

    // CONSTRUCTORES
    public User() {
    }

    public User(int idUser, int idTypeUser, String name, String lastName, String dni, String email,
                String password, int idGender, String locationUser, int idUserCreate, int idUserUpdate,
                LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.idUser = idUser;
        this.idTypeUser = idTypeUser;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.idGender = idGender;
        this.locationUser = locationUser;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    // GETTERS Y SETTERS
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getLocationUser() {
        return locationUser;
    }

    public void setLocationUser(String locationUser) {
        this.locationUser = locationUser;
    }

    public int getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(int idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public int getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(int idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
