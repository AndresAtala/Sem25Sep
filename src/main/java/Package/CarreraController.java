package Package;

import model.Carrera;
import model.data.dao.CarreraDAO;
import org.jooq.DSLContext;

public class CarreraController {
    private CarreraDAO carreraDAO;
    private DSLContext query;
    public CarreraController(DSLContext query) {
        this.carreraDAO = new CarreraDAO();
        this.query = query;
    }

    public String[] obtenerCodigosCarreras() {
        return carreraDAO.obtenerCodigosCarreras(query);
    }

    public void agregarCarrera(String nombre, String codigo, int cantidadSemestres) {
        Carrera nuevaCarrera = new Carrera(nombre, codigo, cantidadSemestres);
        carreraDAO.agregarCarrera(query, nuevaCarrera);
    }

    public Carrera buscarCarrera(String codigoCarrera) {
        return carreraDAO.buscarCarrera(query, codigoCarrera);
    }
}
