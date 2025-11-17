package com.ies9021.snr.service;

import com.ies9021.snr.dao.UserDAO;
import com.ies9021.snr.model.User;
import java.util.List;

public class UserService {

    private UserDAO userDAO;

    // Constructor para testing (JUNIT)
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Constructor normal (app real)
    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean createUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) return false;
        if (user.getEmail() == null || user.getEmail().isEmpty()) return false;
        if (user.getPassword() == null || user.getPassword().isEmpty()) return false;
        if (user.getDni() == null || user.getDni().isEmpty()) return false;

        return userDAO.insertUser(user);
    }

    public boolean updateUser(User user) {
        if (user.getIdUser() <= 0) return false;
        if (user.getName() == null || user.getName().isEmpty()) return false;

        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int idUser) {
        if (idUser <= 0) return false;

        return userDAO.deleteUser(idUser);
    }

    public User getUserById(int idUser) {
        return userDAO.getUserById(idUser);
    }
}
