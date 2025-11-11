
package com.mycompany.sistemabiblioteca.model;



public class Socio {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private boolean validado;

    public Socio() {}

    public Socio(int id, String nombre, String apellido, String dni, String email, boolean validado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.validado = validado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isValidado() { return validado; }
    public void setValidado(boolean validado) { this.validado = validado; }
}
