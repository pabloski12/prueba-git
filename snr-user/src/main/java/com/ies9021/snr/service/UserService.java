package com.ies9021.snr.service;

import com.ies9021.snr.dao.UserDAO;
import com.ies9021.snr.model.User;
import java.util.List;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean createUser(User user) {
        // Validaciones antes de guardar
        if (user.getName() == null || user.getName().isEmpty()) {
            System.out.println("El nombre es obligatorio");
            return false;
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            System.out.println("El email es obligatorio");
            return false;
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            System.out.println("La contraseña es obligatoria");
            return false;
        }

        if (user.getDni() == null || user.getDni().isEmpty()) {
            System.out.println("️ El DNI es obligatorio");
            return false;
        }

        // Si todo está bien, llamo a DAO
        boolean success = userDAO.insertUser(user);

        if (success) {
            System.out.println(" Usuario creado correctamente");
        } else {
            System.out.println(" Error al crear el usuario");
        }

        return success;
    }

    // MÉTODOS NUEVOS QUE FALTABAN
    public boolean updateUser(User user) {
        if (user.getIdUser() == 0) {
            System.out.println("ID de usuario inválido");
            return false;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            System.out.println("El nombre es obligatorio");
            return false;
        }
        
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(int idUser) {
        if (idUser <= 0) {
            System.out.println("ID de usuario inválido");
            return false;
        }
        return userDAO.deleteUser(idUser);
    }

    public User getUserById(int idUser) {
        return userDAO.getUserById(idUser);
    }
}
