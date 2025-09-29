package com.ies9021.snr.service;

import com.ies9021.snr.dao.AdvertisingDAO;
import com.ies9021.snr.model.Advertising;
import java.util.List;

public class AdvertisingService {

    private final AdvertisingDAO advertisingDao;

    public AdvertisingService(AdvertisingDAO advertisingDao) {
        this.advertisingDao = advertisingDao;
    }

    public int create(Advertising ad) {
        return advertisingDao.create(ad);
    }
    
    public boolean update(Advertising ad) {
        return advertisingDao.update(ad);
    }

    public Advertising findById(int id) {
        return advertisingDao.findById(id);
    }

    public List<Advertising> findAll() {
        return advertisingDao.findAll();
    }
    
    public boolean delete(int id) {
        return advertisingDao.delete(id);
    }
}