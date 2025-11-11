
package com.mycompany.sistemabiblioteca.model;



public class DetalleReserva {
    private int idReserva;
    private int idEjemplar;

    public DetalleReserva() {}

    public DetalleReserva(int idReserva, int idEjemplar) {
        this.idReserva = idReserva;
        this.idEjemplar = idEjemplar;
    }

    // Getters y Setters
    public int getIdReserva() { return idReserva; }
    public void setIdReserva(int idReserva) { this.idReserva = idReserva; }

    public int getIdEjemplar() { return idEjemplar; }
    public void setIdEjemplar(int idEjemplar) { this.idEjemplar = idEjemplar; }
}
