package Package;

import model.Estudiante;
import model.data.dao.EstudianteDAO;
import model.data.dao.CarreraDAO;
import org.jooq.DSLContext;

public class EstudianteController {
    private EstudianteDAO estudianteDAO;
    private CarreraDAO carreraDAO;
    private DSLContext query;

    public EstudianteController(DSLContext query) {
        this.estudianteDAO = new EstudianteDAO();
        this.carreraDAO = new CarreraDAO();
        this.query = query;
    }

    public void agregarEstudiante(String nombre, String apellido, String rut, int numeroMatricula, String codigoCarrera) {
        if (carreraDAO.validarExistenciaCarrera(query, "codigo", codigoCarrera)) {
            Estudiante nuevoEstudiante = new Estudiante(nombre, apellido, rut, numeroMatricula, codigoCarrera);
            estudianteDAO.agregarEstudiante(query, nuevoEstudiante, codigoCarrera);
        } else {

        }
    }

    public void modificarEstudiante(String rut, String columnaTabla, Object dato) {
        estudianteDAO.modificarEstudiante(query, rut, columnaTabla, dato);
    }

    public String[][] obtenerEstudiantesCursoNombre(String nombre, String codigo) {
        return estudianteDAO.obtenerEstudiantesCursoNombre(query, nombre, codigo);
    }

    public boolean validarExistenciaRegistro(String tabla, String columnaTabla, Object dato) {
        return estudianteDAO.validarExistenciaRegistro(query, tabla, columnaTabla, dato);
    }

    public void eliminarRegistro(String tabla, String columna, String valor) {
        estudianteDAO.eliminarRegistro(query, tabla, columna, valor);
    }
}
