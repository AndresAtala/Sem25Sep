package gui;
import Package.CarreraController;
import javax.swing.*;
import org.jooq.DSLContext;
public class VentanaRegistroCarrera {
    private CarreraController carreraController;
    private DSLContext query;

    public VentanaRegistroCarrera() {
        this.carreraController = new CarreraController(query);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Registro Carrera");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel nombreLabel = new JLabel("Nombre de la Carrera: ");
            JTextField nombreField = new JTextField(20);

            JLabel codigoLabel = new JLabel("Código de la Carrera: ");
            JTextField codigoField = new JTextField(20);

            JLabel semestresLabel = new JLabel("Cantidad de Semestres: ");
            JTextField semestresField = new JTextField(20);

            JButton registrarButton = new JButton("Registrar");
            registrarButton.addActionListener(e -> {
                String nombre = nombreField.getText();
                String codigo = codigoField.getText();
                int semestres = Integer.parseInt(semestresField.getText());
            });

            JButton volverButton = new JButton("Volver");
            volverButton.addActionListener(e -> {
                frame.dispose();
                VentanaBienvenida.main(new String[]{});
            });

            panel.add(nombreLabel);
            panel.add(nombreField);
            panel.add(codigoLabel);
            panel.add(codigoField);
            panel.add(semestresLabel);
            panel.add(semestresField);
            panel.add(registrarButton);
            panel.add(volverButton);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
