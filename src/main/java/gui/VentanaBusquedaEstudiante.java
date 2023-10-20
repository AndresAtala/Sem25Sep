package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBusquedaEstudiante {
    public VentanaBusquedaEstudiante() {
        JFrame frame = new JFrame("Búsqueda de Estudiante");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel buscarLabel = new JLabel("Buscar por Nombre o Matrícula: ");
        JTextField buscarField = new JTextField(20);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí puedes realizar la lógica para buscar al estudiante
                String busqueda = buscarField.getText();

                // Lógica de búsqueda basada en el nombre o la matrícula del estudiante
                // Puedes utilizar los métodos de la lista de estudiantes para buscar según tus requisitos
            }
        });

        panel.add(buscarLabel);
        panel.add(buscarField);
        panel.add(buscarButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
