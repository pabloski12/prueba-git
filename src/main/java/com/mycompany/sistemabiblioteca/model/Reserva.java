
package com.mycompany.sistemabiblioteca.model;



import java.util.Date;

public class Reserva {
    private int id;
    private int idSocio;
    private Date fechaReserva;
    private Date fechaVencimiento;

    public Reserva() {}

    public Reserva(int id, int idSocio, Date fechaReserva, Date fechaVencimiento) {
        this.id = id;
        this.idSocio = idSocio;
        this.fechaReserva = fechaReserva;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdSocio() { return idSocio; }
    public void setIdSocio(int idSocio) { this.idSocio = idSocio; }

    public Date getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(Date fechaReserva) { this.fechaReserva = fechaReserva; }

    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}
