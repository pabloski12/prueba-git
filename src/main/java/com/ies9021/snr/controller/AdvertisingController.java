package com.ies9021.snr.controller;

import com.ies9021.snr.model.Advertising;
import com.ies9021.snr.service.AdvertisingService;
import java.util.List;

public class AdvertisingController {

    private final AdvertisingService service;

    public AdvertisingController(AdvertisingService service) {
        this.service = service;
    }

    public int create(Advertising ad) {
        System.out.println("Controller: Creando publicidad para " + ad.getCompany());
        return service.create(ad); 
    }

    public boolean update(Advertising ad) {
        System.out.println("Controller: Actualizando publicidad #" + ad.getId_advertising());
        return service.update(ad); 
    }

    public Advertising findById(int id) {
        System.out.println("Controller: Buscando publicidad #" + id);
        return service.findById(id); 
    }
    
    public List<Advertising> findAll() {
        System.out.println("Controller: Obteniendo listado de publicidades.");
        return service.findAll(); 
    }
    
    public boolean delete(int id) {
        System.out.println("Controller: Eliminando publicidad #" + id);
        return service.delete(id); 
    }
}