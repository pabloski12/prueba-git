
package com.mycompany.sistemabiblioteca.model;



import java.util.Date;

public class Prestamo {
    private int id;
    private int idSocio;
    private int idEjemplar;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    public Prestamo() {}

    public Prestamo(int id, int idSocio, int idEjemplar, Date fechaPrestamo, Date fechaDevolucion, boolean devuelto) {
        this.id = id;
        this.idSocio = idSocio;
        this.idEjemplar = idEjemplar;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdSocio() { return idSocio; }
    public void setIdSocio(int idSocio) { this.idSocio = idSocio; }

    public int getIdEjemplar() { return idEjemplar; }
    public void setIdEjemplar(int idEjemplar) { this.idEjemplar = idEjemplar; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public boolean isDevuelto() { return devuelto; }
    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }
}
