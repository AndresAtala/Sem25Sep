package gui;

import Package.CafeteriaController;
import model.data.DBConnector;
import model.data.DBGenerator;
import org.jooq.DSLContext;

import javax.swing.*;

public class VentanaBienvenida {
    public static void main(String[] args) {
        // Configuración de la base de datos
        String nombreBD = "BD"; // Reemplaza con el nombre de tu base de datos
        String usuario = "root"; // Reemplaza con tu nombre de usuario
        String password = ""; // Reemplaza con tu contraseña

        // Establecer la conexión a la base de datos
        DSLContext query = DBConnector.createDSLContext(nombreBD, usuario, password);

        // Iniciar la base de datos y generar las tablas
        DBGenerator.iniciarBD(nombreBD);

        CafeteriaController cafeteriaController = new CafeteriaController(query);

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Bienvenido a la Cafetería");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton botonIngresarCafeteria = new JButton("Ingresar a la cafetería");
            JButton botonSalir = new JButton("Salir");

            botonIngresarCafeteria.addActionListener(e -> {
                VentanaCafeteria ventanaCafeteria = new VentanaCafeteria(cafeteriaController);
                ventanaCafeteria.mostrar();
            });

            botonSalir.addActionListener(e -> System.exit(0));

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(botonIngresarCafeteria);
            panel.add(botonSalir);

            frame.getContentPane().add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
