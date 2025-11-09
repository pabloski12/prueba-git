package com.ies9021.snr;

import com.ies9021.snr.view.Pantalla;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pantalla pantalla = new Pantalla();
            pantalla.setVisible(true);
        });
    }
}