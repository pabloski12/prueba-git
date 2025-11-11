package com.mycompany.sistemabiblioteca.controller;

import com.biblioteca.dao.SocioDAO;
import com.mycompany.sistemabiblioteca.model.Socio;
import java.util.List;

public class SocioController {
    private SocioDAO socioDAO = new SocioDAO();

    public boolean agregarSocio(Socio socio) {
        return socioDAO.agregarSocio(socio);
    }

    public List<Socio> listarSocios() {
        return socioDAO.listarSocios();
    }

    public boolean eliminarSocio(int id) {
        return socioDAO.eliminarSocio(id);
    }

    public boolean actualizarSocio(Socio socio) {
        return socioDAO.actualizarSocio(socio);
    }
}
