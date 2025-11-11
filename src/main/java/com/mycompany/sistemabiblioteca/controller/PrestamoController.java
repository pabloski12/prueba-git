package com.mycompany.sistemabiblioteca.controller;

import com.biblioteca.dao.PrestamoDAO;
import com.mycompany.sistemabiblioteca.model.Prestamo;
import java.util.List;

public class PrestamoController {
    private PrestamoDAO prestamoDAO = new PrestamoDAO();

    public boolean registrarPrestamo(Prestamo prestamo) {
        return prestamoDAO.registrarPrestamo(prestamo);
    }

    public boolean registrarDevolucion(int idPrestamo) {
        return prestamoDAO.registrarDevolucion(idPrestamo);
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoDAO.listarPrestamos();
    }
}
