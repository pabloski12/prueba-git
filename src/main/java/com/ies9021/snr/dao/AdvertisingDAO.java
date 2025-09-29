package com.ies9021.snr.dao;

import com.ies9021.snr.model.Advertising;
import java.util.List;

public interface AdvertisingDAO {
    
    int create(Advertising ad);
    Advertising findById(int id);
    List<Advertising> findAll();
    boolean update(Advertising ad);
    boolean delete(int id);
}