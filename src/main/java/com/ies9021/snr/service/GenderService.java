package com.ies9021.snr.service;

import com.ies9021.snr.dao.GenderDAO;
import com.ies9021.snr.model.Gender;
import java.util.List;

public class GenderService {
    private final GenderDAO genderDAO;
    
    public GenderService(){
        this.genderDAO = new GenderDAO();
    }
    
    public List<Gender> listarGenders(){
        return genderDAO.getAllGenders();
    }

    // MÉTODO NUEVO QUE FALTABA
    public Gender getGenderById(int id) {
        return genderDAO.getGenderById(id);
    }
}