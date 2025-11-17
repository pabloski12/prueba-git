package com.ies9021.snr.controller;

import com.ies9021.snr.model.User;
import com.ies9021.snr.model.Gender;
import com.ies9021.snr.service.UserService;
import com.ies9021.snr.service.GenderService;
import java.util.List;

public class UserController {

    private UserService userService;
    private GenderService genderService;

    public UserController() {
        this.userService = new UserService();
        this.genderService = new GenderService();
    }

    // MÉTODOS PARA LA INTERFAZ GRÁFICA
    public List<User> obtenerTodosUsuarios() {
        return userService.getAllUsers();
    }

    public List<Gender> obtenerTodosGeneros() {
        return genderService.listarGenders();
    }

    public boolean crearUsuario(User user) {
        return userService.createUser(user);
    }

    public boolean actualizarUsuario(User user) {
        return userService.updateUser(user);
    }

    public boolean eliminarUsuario(int idUser) {
        return userService.deleteUser(idUser);
    }

    public User obtenerUsuarioPorId(int idUser) {
        return userService.getUserById(idUser);
    }

    // TUS MÉTODOS ORIGINALES
    public void showAllUsers() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            System.out.println("⚠️ No hay usuarios cargados en el sistema.");
        } else {
            System.out.println("📋 Lista de usuarios:");
            for (User u : users) {
                System.out.println("ID: " + u.getIdUser() +
                                   " | Nombre: " + u.getName() +
                                   " | Email: " + u.getEmail() +
                                   " | DNI: " + u.getDni());
            }
        }
    }

    public void createUser(String name, String lastName, String dni, String email, 
                           String password, int idGender, String locationUser, 
                           int idTypeUser, int idUserCreate) {
        User newUser = new User();

        newUser.setName(name);
        newUser.setLastName(lastName);
        newUser.setDni(dni);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setIdGender(idGender);
        newUser.setLocationUser(locationUser);
        newUser.setIdTypeUser(idTypeUser);
        newUser.setIdUserCreate(idUserCreate);

        boolean created = userService.createUser(newUser);

        if (created) {
            System.out.println("✅ Usuario registrado exitosamente.");
        } else {
            System.out.println("❌ No se pudo registrar el usuario.");
        }
    }
}
