
package com.mycompany.sistemabiblioteca.model;



public class Ejemplar {
    private int id;
    private String codigo;
    private int idLibro;
    private boolean disponible;

    public Ejemplar() {}

    public Ejemplar(int id, String codigo, int idLibro, boolean disponible) {
        this.id = id;
        this.codigo = codigo;
        this.idLibro = idLibro;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public int getIdLibro() { return idLibro; }
    public void setIdLibro(int idLibro) { this.idLibro = idLibro; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
