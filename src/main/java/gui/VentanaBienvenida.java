package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBienvenida {
        public static void main(String[] args) {
            VentanaBienvenida ventanaBienvenida = new VentanaBienvenida();
        }

    public VentanaBienvenida() {
        JFrame frame = new JFrame("Bienvenido");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton botonRegistroEstudiante = new JButton("Registro Estudiante");
        JButton botonBusquedaEstudiante = new JButton("Búsqueda Estudiante");
        JButton botonRegistroCarrera = new JButton("Registro Carrera");

        botonRegistroEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                VentanaRegistroEstudiante ventanaRegistroEstudiante = new VentanaRegistroEstudiante();
            }
        });

        botonBusquedaEstudiante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Cerrar la ventana actual
                VentanaBusquedaEstudiante ventanaBusquedaEstudiante = new VentanaBusquedaEstudiante();
            }
        });

        botonRegistroCarrera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                VentanaRegristroCarrera ventanaRegistroCarrera = new VentanaRegristroCarrera();
            }
        });

        JPanel panel = new JPanel();
        panel.add(botonRegistroEstudiante);
        panel.add(botonBusquedaEstudiante);
        panel.add(botonRegistroCarrera);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}


