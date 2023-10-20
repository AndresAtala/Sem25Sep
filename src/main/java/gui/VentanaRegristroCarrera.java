package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaRegristroCarrera {
    public VentanaRegristroCarrera() {
        JFrame frame = new JFrame("Registro Carrera");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel nombreLabel = new JLabel("Nombre de la Carrera: ");
        JTextField nombreField = new JTextField(20);

        JLabel codigoLabel = new JLabel("Código de la Carrera: ");
        JTextField codigoField = new JTextField(20);

        JLabel semestresLabel = new JLabel("Cantidad de Semestres: ");
        JTextField semestresField = new JTextField(20);

        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes realizar la lógica para registrar la carrera
                String nombre = nombreField.getText();
                String codigo = codigoField.getText();
                int semestres = Integer.parseInt(semestresField.getText());

                // Aquí podrías usar la clase Carrera para crear una instancia y trabajar con ella
                // Carrera carrera = new Carrera(nombre, codigo, semestres);

                // Lógica adicional según tus requisitos
            }
        });

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(codigoLabel);
        panel.add(codigoField);
        panel.add(semestresLabel);
        panel.add(semestresField);
        panel.add(registrarButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
