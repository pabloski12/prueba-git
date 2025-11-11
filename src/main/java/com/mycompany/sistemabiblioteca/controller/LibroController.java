package com.mycompany.sistemabiblioteca.controller;

import com.biblioteca.dao.LibroDAO;
import com.mycompany.sistemabiblioteca.model.Libro;
import java.util.List;

public class LibroController {
    private final LibroDAO libroDAO;

    public LibroController() {
        this.libroDAO = new LibroDAO();
    }

    public boolean agregarLibro(Libro libro) {
        return libroDAO.insertar(libro);
    }

    public List<Libro> listarLibros() {
        return libroDAO.listar();
    }

    public boolean eliminarLibro(int id) {
        return libroDAO.eliminar(id);
    }
}
