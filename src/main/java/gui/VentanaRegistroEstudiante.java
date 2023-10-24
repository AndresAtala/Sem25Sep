package gui;

import javax.swing.*;

public class VentanaRegistroEstudiante {
    public VentanaRegistroEstudiante() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Registro Estudiante");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel nombreLabel = new JLabel("Nombre: ");
            JTextField nombreField = new JTextField(20);

            JLabel apellidoLabel = new JLabel("Apellido: ");
            JTextField apellidoField = new JTextField(20);

            JLabel rutLabel = new JLabel("RUT: ");
            JTextField rutField = new JTextField(20);

            JLabel matriculaLabel = new JLabel("Número de Matrícula: ");
            JTextField matriculaField = new JTextField(20);

            JButton registrarButton = new JButton("Registrar");
            registrarButton.addActionListener(e -> {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String rut = rutField.getText();
                int matricula = Integer.parseInt(matriculaField.getText());
            });

            JButton volverButton = new JButton("Volver");
            volverButton.addActionListener(e -> {
                frame.dispose();
                VentanaBienvenida.main(new String[]{});
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
            panel.add(volverButton);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
