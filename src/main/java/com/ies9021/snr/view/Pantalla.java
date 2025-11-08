package com.ies9021.snr.view;

import com.ies9021.snr.controller.UserController;
import com.ies9021.snr.model.User;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Pantalla extends JFrame {
    private UserController controlador;
    
    // Campos del formulario
    private JTextField txtNombre, txtApellido, txtDni, txtEmail, txtPassword, txtUbicacion;
    private JComboBox<String> comboGenero;
    private JComboBox<Integer> comboTipoUsuario;
    
    // Tabla
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    
    // Botones
    private JButton btnGuardar, btnActualizar, btnEliminar, btnOcultarTabla;
    private JScrollPane scrollTabla;
    private boolean tablaVisible = true;
    
    public Pantalla() {
        this.controlador = new UserController();
        crearInterfaz();
        cargarUsuarios();
    }

    private void crearInterfaz() {
        setTitle("Sistema Nacional de Reclamos - SNR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.WHITE);

        // Panel superior - Formulario
        JPanel panelFormulario = crearPanelFormulario();
        add(panelFormulario, BorderLayout.NORTH);

        // Panel central - Botones
        JPanel panelBotones = crearPanelBotones();
        add(panelBotones, BorderLayout.CENTER);

        // Panel inferior - Tabla
        JPanel panelTabla = crearPanelTabla();
        add(panelTabla, BorderLayout.SOUTH);

        setSize(1000, 700);
        setLocationRelativeTo(null);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Usuario"));
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1: Nombre y DNI
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Nombre"), gbc);
        
        gbc.gridx = 1;
        txtNombre = new JTextField(15);
        panel.add(txtNombre, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("DNI"), gbc);
        
        gbc.gridx = 3;
        txtDni = new JTextField(15);
        panel.add(txtDni, gbc);

        // Fila 2: Apellido y Género
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Apellido"), gbc);
        
        gbc.gridx = 1;
        txtApellido = new JTextField(15);
        panel.add(txtApellido, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Género"), gbc);
        
        gbc.gridx = 3;
        comboGenero = new JComboBox<>(new String[]{"Femenino", "Masculino", "Otro"});
        panel.add(comboGenero, gbc);

        // Fila 3: Email y Ubicación
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Email"), gbc);
        
        gbc.gridx = 1;
        txtEmail = new JTextField(15);
        panel.add(txtEmail, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Ubicación"), gbc);
        
        gbc.gridx = 3;
        txtUbicacion = new JTextField(15);
        panel.add(txtUbicacion, gbc);

        // Fila 4: Contraseña y Tipo Usuario
        gbc.gridx = 0; gbc.gridy = 3;
        panel.add(new JLabel("Contraseña"), gbc);
        
        gbc.gridx = 1;
        txtPassword = new JTextField(15);
        panel.add(txtPassword, gbc);
        
        gbc.gridx = 2;
        panel.add(new JLabel("Tipo Usuario"), gbc);
        
        gbc.gridx = 3;
        comboTipoUsuario = new JComboBox<>(new Integer[]{1, 2, 3});
        panel.add(comboTipoUsuario, gbc);

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panel.setBackground(Color.WHITE);

        // Botón GUARDAR (Verde)
        btnGuardar = new JButton("GUARDAR");
        btnGuardar.setBackground(new Color(0, 150, 0));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardar.setPreferredSize(new Dimension(120, 35));
        btnGuardar.addActionListener(e -> guardarUsuario());
        panel.add(btnGuardar);

        // Botón ACTUALIZAR (Azul)
        btnActualizar = new JButton("ACTUALIZAR");
        btnActualizar.setBackground(new Color(0, 100, 200));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 12));
        btnActualizar.setPreferredSize(new Dimension(120, 35));
        btnActualizar.addActionListener(e -> actualizarUsuario());
        panel.add(btnActualizar);

        // Botón ELIMINAR (Rojo)
        btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setBackground(new Color(200, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
        btnEliminar.setPreferredSize(new Dimension(120, 35));
        btnEliminar.addActionListener(e -> eliminarUsuario());
        panel.add(btnEliminar);

        // Botón OCULTAR TABLA
        btnOcultarTabla = new JButton("Ocultar tabla");
        btnOcultarTabla.setPreferredSize(new Dimension(120, 35));
        btnOcultarTabla.addActionListener(e -> toggleTabla());
        panel.add(btnOcultarTabla);

        return panel;
    }

    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Usuarios"));

        // Columnas
        String[] columnas = {
            "ID", "Tipo de usuario", "Nombre", "Apellido", "DNI", 
            "Email", "Contraseña", "Género", "Ubicación", "Actualizado por",
            "Fecha Actualización", "Creado por", "Fecha Creación"
        };
        
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaUsuarios = new JTable(modeloTabla);
        tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaUsuarios.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarUsuarioSeleccionado();
            }
        });

        // Configuración de TABLA
        tablaUsuarios.setRowHeight(25);
        tablaUsuarios.getTableHeader().setBackground(Color.DARK_GRAY);
        tablaUsuarios.getTableHeader().setForeground(Color.WHITE);
        tablaUsuarios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));

        scrollTabla = new JScrollPane(tablaUsuarios);
        scrollTabla.setPreferredSize(new Dimension(950, 250));
        
        panel.add(scrollTabla, BorderLayout.CENTER);

        return panel;
    }

    private void cargarUsuarios() {
        modeloTabla.setRowCount(0);
        try {
            List<User> usuarios = controlador.obtenerTodosUsuarios();
            
            if (usuarios == null || usuarios.isEmpty()) {
                agregarUsuariosPrueba();
            } else {
                for (User usuario : usuarios) {
                    Object[] fila = {
                        usuario.getIdUser(),
                        usuario.getIdTypeUser(),
                        usuario.getName(),
                        usuario.getLastName(),
                        usuario.getDni(),
                        usuario.getEmail(),
                        "********", // Contraseña censurada
                        getNombreGenero(usuario.getIdGender()),
                        usuario.getLocationUser(),
                        usuario.getIdUserUpdate(),
                        usuario.getDateUpdate() != null ? usuario.getDateUpdate().toString() : "",
                        usuario.getIdUserCreate(),
                        usuario.getDateCreate() != null ? usuario.getDateCreate().toString() : ""
                    };
                    modeloTabla.addRow(fila);
                }
            }
            
            ajustarAnchoColumnas();
            
        } catch (Exception e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
            agregarUsuariosPrueba();
        }
    }

    private String getNombreGenero(int idGender) {
        switch (idGender) {
            case 1: return "Femenino";
            case 2: return "Masculino";
            case 3: return "Otro";
            default: return "No especificado";
        }
    }

    private int getIdGenero(String nombreGenero) {
        switch (nombreGenero) {
            case "Femenino": return 1;
            case "Masculino": return 2;
            case "Otro": return 3;
            default: return 1;
        }
    }

    private void agregarUsuariosPrueba() {
        // Datos de prueba
        Object[] usuario1 = {
            1, 2, "María", "González", "30123456", "maria@example.com",
            "********", "Femenino", "Buenos Aires", 1, "2024-01-20T14:25:00", 1, "2024-01-15T10:30:00"
        };
        
        Object[] usuario2 = {
            2, 1, "Carlos", "López", "35234567", "carlos@empresa.com", 
            "********", "Masculino", "Córdoba", 1, "2024-01-18T11:40:00", 1, "2024-01-16T09:15:00"
        };
        
        Object[] usuario3 = {
            3, 3, "Ana", "Martínez", "28345678", "ana.martinez@mail.com",
            "********", "Otro", "Mendoza", 2, "2024-01-19T08:55:00", 1, "2024-01-17T16:20:00"
        };
        
        modeloTabla.addRow(usuario1);
        modeloTabla.addRow(usuario2);
        modeloTabla.addRow(usuario3);
    }

    private void ajustarAnchoColumnas() {
        if (tablaUsuarios.getColumnCount() >= 13) {
            tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(40);   // ID
            tablaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(80);   // Tipo usuario
            tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(80);   // Nombre
            tablaUsuarios.getColumnModel().getColumn(3).setPreferredWidth(80);   // Apellido
            tablaUsuarios.getColumnModel().getColumn(4).setPreferredWidth(70);   // DNI
            tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(120);  // Email
            tablaUsuarios.getColumnModel().getColumn(6).setPreferredWidth(70);   // Contraseña
            tablaUsuarios.getColumnModel().getColumn(7).setPreferredWidth(70);   // Género
            tablaUsuarios.getColumnModel().getColumn(8).setPreferredWidth(80);   // Ubicación
            tablaUsuarios.getColumnModel().getColumn(9).setPreferredWidth(80);   // Actualizado por
            tablaUsuarios.getColumnModel().getColumn(10).setPreferredWidth(120); // Fecha Actualización
            tablaUsuarios.getColumnModel().getColumn(11).setPreferredWidth(70);  // Creado por
            tablaUsuarios.getColumnModel().getColumn(12).setPreferredWidth(120); // Fecha Creación
        }
    }

    private void cargarUsuarioSeleccionado() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada >= 0) {
            try {
                txtNombre.setText(modeloTabla.getValueAt(filaSeleccionada, 2).toString());
                txtApellido.setText(modeloTabla.getValueAt(filaSeleccionada, 3).toString());
                txtDni.setText(modeloTabla.getValueAt(filaSeleccionada, 4).toString());
                txtEmail.setText(modeloTabla.getValueAt(filaSeleccionada, 5).toString());
                txtPassword.setText(""); // No mostrar contraseña real
                txtUbicacion.setText(modeloTabla.getValueAt(filaSeleccionada, 8).toString());
                comboGenero.setSelectedItem(modeloTabla.getValueAt(filaSeleccionada, 7).toString());
                comboTipoUsuario.setSelectedItem(Integer.parseInt(modeloTabla.getValueAt(filaSeleccionada, 1).toString()));
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "Error al cargar datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarUsuario() {
        try {
            if (!validarFormulario()) return;
            
            User usuario = crearUsuarioDesdeFormulario();
            usuario.setIdUserCreate(1);
            usuario.setIdUserUpdate(1);
            
            boolean exito = controlador.crearUsuario(usuario);
            
            if (exito) {
                JOptionPane.showMessageDialog(this, 
                    "✅ Usuario guardado exitosamente",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);
                limpiarFormulario();
                cargarUsuarios();
            } else {
                JOptionPane.showMessageDialog(this,
                    "❌ Error al guardar el usuario",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                "❌ Error: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Seleccione un usuario de la tabla para actualizar",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idUsuario = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de actualizar el usuario con ID: " + idUsuario + "?",
            "Confirmar Actualización", JOptionPane.YES_NO_OPTION);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                if (!validarFormulario()) return;
                
                User usuario = crearUsuarioDesdeFormulario();
                usuario.setIdUser(idUsuario);
                usuario.setIdUserUpdate(1);
                
                boolean exito = controlador.actualizarUsuario(usuario);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this,
                        "✅ Usuario actualizado exitosamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormulario();
                    cargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this,
                        "❌ Error al actualizar el usuario",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "❌ Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tablaUsuarios.getSelectedRow();
        if (filaSeleccionada < 0) {
            JOptionPane.showMessageDialog(this,
                "⚠️ Seleccione un usuario de la tabla para eliminar",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int idUsuario = (int) modeloTabla.getValueAt(filaSeleccionada, 0);
        String nombreUsuario = txtNombre.getText() + " " + txtApellido.getText();
        
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de ELIMINAR el usuario?\n" +
            "ID: " + idUsuario + "\n" +
            "Nombre: " + nombreUsuario + "\n\n" +
            "⚠️ Esta acción no se puede deshacer.",
            "Confirmar Eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                boolean exito = controlador.eliminarUsuario(idUsuario);
                
                if (exito) {
                    JOptionPane.showMessageDialog(this,
                        "✅ Usuario eliminado exitosamente",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormulario();
                    cargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(this,
                        "❌ Error al eliminar el usuario",
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                    "❌ Error: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void toggleTabla() {
        tablaVisible = !tablaVisible;
        scrollTabla.setVisible(tablaVisible);
        btnOcultarTabla.setText(tablaVisible ? "Ocultar tabla" : "Mostrar tabla");
        revalidate();
        repaint();
    }

    private boolean validarFormulario() {
        if (txtNombre.getText().trim().isEmpty()) {
            mostrarError("El nombre es obligatorio", txtNombre);
            return false;
        }
        if (txtApellido.getText().trim().isEmpty()) {
            mostrarError("El apellido es obligatorio", txtApellido);
            return false;
        }
        if (txtDni.getText().trim().isEmpty()) {
            mostrarError("El DNI es obligatorio", txtDni);
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            mostrarError("El email es obligatorio", txtEmail);
            return false;
        }
        if (txtPassword.getText().trim().isEmpty()) {
            mostrarError("La contraseña es obligatoria", txtPassword);
            return false;
        }
        return true;
    }

    private void mostrarError(String mensaje, JTextField campo) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
        campo.requestFocus();
    }

    private User crearUsuarioDesdeFormulario() {
        User usuario = new User();
        usuario.setIdTypeUser((Integer) comboTipoUsuario.getSelectedItem());
        usuario.setName(txtNombre.getText().trim());
        usuario.setLastName(txtApellido.getText().trim());
        usuario.setDni(txtDni.getText().trim());
        usuario.setEmail(txtEmail.getText().trim());
        usuario.setPassword(txtPassword.getText());
        usuario.setLocationUser(txtUbicacion.getText().trim());
        usuario.setIdGender(getIdGenero((String) comboGenero.getSelectedItem()));
        
        return usuario;
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtUbicacion.setText("");
        comboGenero.setSelectedIndex(0);
        comboTipoUsuario.setSelectedIndex(0);
        tablaUsuarios.clearSelection();
        txtNombre.requestFocus();
    }

}

