package gui;

import Package.CafeteriaController;
import model.Cafe;

import javax.swing.*;
import java.awt.*;

public class VentanaCafeteria {
    private final CafeteriaController cafeteriaController;
    private final JFrame frame;

    public VentanaCafeteria(CafeteriaController cafeteriaController) {
        this.cafeteriaController = cafeteriaController;

        frame = new JFrame("Cafetería");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Opciones de café:");
        String[] opciones = cafeteriaController.obtenerNombresCafeterias();
        JComboBox<String> comboBox = new JComboBox<>(opciones);

        JButton botonPedirCafe = new JButton("Pedir Café");
        JButton botonAgregarLeche = new JButton("Agregar Leche");
        JButton botonDescontinuarCafe = new JButton("Descontinuar Café");
        JButton botonSalir = new JButton("Salir");

        botonPedirCafe.addActionListener(e -> {
            String selectedCafe = (String) comboBox.getSelectedItem();
            Cafe cafe = cafeteriaController.buscarCafe(selectedCafe);
            if (cafe != null && !cafe.isDiscontinuado()) {
                JOptionPane.showMessageDialog(null, "Café pedido: " + selectedCafe);
            } else {
                JOptionPane.showMessageDialog(null, "El café seleccionado no está disponible.");
            }
        });

        botonAgregarLeche.addActionListener(e -> {
            String selectedCafe = (String) comboBox.getSelectedItem();
            Cafe cafe = cafeteriaController.buscarCafe(selectedCafe);
            if (cafe != null && !cafe.isDiscontinuado()) {
                JOptionPane.showMessageDialog(null, "Leche agregada a: " + selectedCafe);
            } else {
                JOptionPane.showMessageDialog(null, "El café seleccionado no está disponible.");
            }
        });

        botonDescontinuarCafe.addActionListener(e -> {
            String selectedCafe = (String) comboBox.getSelectedItem();
            Cafe cafe = cafeteriaController.buscarCafe(selectedCafe);
            if (cafe != null) {
                cafeteriaController.descontinuarCafe(selectedCafe);
                JOptionPane.showMessageDialog(null, "Café descontinuado: " + selectedCafe);
            } else {
                JOptionPane.showMessageDialog(null, "El café seleccionado no existe.");
            }
        });

        botonSalir.addActionListener(e -> frame.dispose());

        frame.add(label);
        frame.add(comboBox);
        frame.add(botonPedirCafe);
        frame.add(botonAgregarLeche);
        frame.add(botonDescontinuarCafe);
        frame.add(botonSalir);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}
