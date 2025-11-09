package com.ies9021.snr.model;

import java.time.LocalDateTime;

public class User {

    private int idUser;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String password;
    private int idGender; // referencia a Gender
    private String locationUser;
    private int idTypeUser;
    private int idUserCreate;

    public User() {}

    public User(int idUser, String name, String lastName, String dni, String email, String password,
                int idGender, String locationUser, int idTypeUser, int idUserCreate) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
        this.password = password;
        this.idGender = idGender;
        this.locationUser = locationUser;
        this.idTypeUser = idTypeUser;
        this.idUserCreate = idUserCreate;
    }

    // Getters y Setters
    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getIdGender() { return idGender; }
    public void setIdGender(int idGender) { this.idGender = idGender; }

    public String getLocationUser() { return locationUser; }
    public void setLocationUser(String locationUser) { this.locationUser = locationUser; }

    public int getIdTypeUser() { return idTypeUser; }
    public void setIdTypeUser(int idTypeUser) { this.idTypeUser = idTypeUser; }

    public int getIdUserCreate() { return idUserCreate; }
    public void setIdUserCreate(int idUserCreate) { this.idUserCreate = idUserCreate; }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", idGender=" + idGender +
                ", locationUser='" + locationUser + '\'' +
                ", idTypeUser=" + idTypeUser +
                ", idUserCreate=" + idUserCreate +
                '}';
    }

    public void setGenderName(String string) {
    }

    public void getIdUserUpdate() {
    }

    public void setIdUserUpdate(int aInt) {
    }

    public void setDateCreate(LocalDateTime toLocalDateTime) {
    }

    public void setDateUpdate(LocalDateTime toLocalDateTime) {
    }
}
