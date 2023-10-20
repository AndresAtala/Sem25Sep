package gui;

import javax.swing.*;

public class VentanaBusquedaEstudiante {
    public VentanaBusquedaEstudiante() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Búsqueda de Estudiante");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel buscarLabel = new JLabel("Buscar por Nombre o Matrícula: ");
            JTextField buscarField = new JTextField(20);

            JButton buscarButton = new JButton("Buscar");
            buscarButton.addActionListener(e -> {
                String busqueda = buscarField.getText();
                // Aquí puedes agregar la lógica para buscar al estudiante
            });

            JButton volverButton = new JButton("Volver");
            volverButton.addActionListener(e -> {
                frame.dispose();
                VentanaBienvenida.main(new String[]{});
            });

            panel.add(buscarLabel);
            panel.add(buscarField);
            panel.add(buscarButton);
            panel.add(volverButton);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
