package com.ies9021.snr.model;

public class Gender {

    private int idGender;
    private String nameGender;

    public Gender() {}

    public Gender(int idGender, String nameGender) {
        this.idGender = idGender;
        this.nameGender = nameGender;
    }

    // Getters y Setters
    public int getIdGender() { return idGender; }
    public void setIdGender(int idGender) { this.idGender = idGender; }

    public String getNameGender() { return nameGender; }
    public void setNameGender(String nameGender) { this.nameGender = nameGender; }

    @Override
    public String toString() {
        return "Gender{" +
                "idGender=" + idGender +
                ", nameGender='" + nameGender + '\'' +
                '}';
    }
}
