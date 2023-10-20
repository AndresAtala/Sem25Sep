package gui;

import javax.swing.*;

public class VentanaBienvenida {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bienvenido");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton botonRegistroEstudiante = new JButton("Registro Estudiante");
            JButton botonBusquedaEstudiante = new JButton("Búsqueda Estudiante");
            JButton botonRegistroCarrera = new JButton("Registro Carrera");
            JButton botonSalir = new JButton("Salir");

            botonRegistroEstudiante.addActionListener(e -> {
                frame.dispose();
                VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
            });

            botonBusquedaEstudiante.addActionListener(e -> {
                frame.dispose(); // Cerrar la ventana actual
                VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante();
            });

            botonRegistroCarrera.addActionListener(e -> {
                frame.dispose();
                VentanaRegistroCarrera ventanaRegistroCarrera = new VentanaRegistroCarrera();
            });

            botonSalir.addActionListener(e -> System.exit(0));

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(botonRegistroEstudiante);
            panel.add(botonBusquedaEstudiante);
            panel.add(botonRegistroCarrera);
            panel.add(botonSalir);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
