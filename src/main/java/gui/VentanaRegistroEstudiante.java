package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegistroEstudiante {
    public VentanaRegistroEstudiante() {
        JFrame frame = new JFrame("Registro Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel nombreLabel = new JLabel("Nombre: ");
        JTextField nombreField = new JTextField(20);

        JLabel apellidoLabel = new JLabel("Apellido: ");
        JTextField apellidoField = new JTextField(20);

        JLabel rutLabel = new JLabel("RUT: ");
        JTextField rutField = new JTextField(20);

        JLabel matriculaLabel = new JLabel("Número de Matrícula: ");
        JTextField matriculaField = new JTextField(20);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes realizar la lógica para registrar al estudiante
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String rut = rutField.getText();
                int matricula = Integer.parseInt(matriculaField.getText());

                // Aquí podrías usar la clase Estudiante para crear una instancia y trabajar con ella
                // Estudiante estudiante = new Estudiante(nombre, apellido, rut, matricula);

                // Lógica adicional según tus requisitos
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(apellidoLabel);
        panel.add(apellidoField);
        panel.add(rutLabel);
        panel.add(rutField);
        panel.add(matriculaLabel);
        panel.add(matriculaField);
        panel.add(registrarButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

