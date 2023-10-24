package model.data.dao;

import model.Carrera;
import model.Estudiante;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.Field;
import static org.jooq.impl.DSL.*;

import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public void agregarEstudiante(DSLContext query, Estudiante estudiante, String codigoCarrera) {
        Table tablaEstudiante = table(name("Estudiante"));
        Field[] columnas = tablaEstudiante.fields("rut", "nombre", "matricula", "codigo_carrera");
        query.insertInto(tablaEstudiante, columnas[0], columnas[1], columnas[2], columnas[3])
                .values(estudiante.getRut(), estudiante.getNombre(), estudiante.getNumeroMatricula(),
                        codigoCarrera).execute();
    }

    public void modificarEstudiante(DSLContext query, String rut, String columnaTabla, Object dato) {
        query.update(table("Estudiante")).set(field(columnaTabla), dato)
                .where(field("rut").eq(rut)).execute();
    }

    public List<Estudiante> obtenerEstudiantes(DSLContext query) {
        Result<Record> resultados = query.select().from(table("Estudiante")).fetch();
        return obtenerListaEstudiantes(query, resultados);
    }

    private List<Estudiante> obtenerListaEstudiantes(DSLContext query, Result<Record> resultados) {
        List<Estudiante> estudiantes = new ArrayList<>();
        for (Record record : resultados) {
            String rut = record.get("rut", String.class);
            String nombre = record.get("nombre", String.class);
            String matricula = record.get("numeroMatricula", String.class);
            Carrera carrera = CarreraDAO.buscarCarrera(query, record.get("codigo_carrera"));
            estudiantes.add(new Estudiante(nombre, "", rut, Integer.parseInt(matricula), carrera));
        }
        return estudiantes;
    }

    public String[][] obtenerEstudiantesCursoNombre(DSLContext query, String nombre, String codigo) {
        Table estudiante = table("Estudiante");
        Table carrera = table("Carrera");
        Result<Record> resultados =
                query.select().from(estudiante).join(carrera).on(field("codigo").eq(field("codigo_carrera")))
                        .where(field("nombre").eq(nombre)).and(field("codigo_carrera").eq(codigo)).fetch();
        return exportarDatos(resultados);
    }

    private String[][] exportarDatos(Result<Record> resultados) {
        String[][] datosResultado = new String[resultados.size()][4];
        for (int registro = 0; registro < resultados.size(); registro++) {
            datosResultado[registro][0] = resultados.get(registro).get("nombre", String.class);
            datosResultado[registro][1] = resultados.get(registro).get("numeroMatricula", String.class);
            datosResultado[registro][2] = resultados.get(registro).get("nombre_carrera", String.class);
            datosResultado[registro][3] = resultados.get(registro).get("codigo", String.class);
        }
        return datosResultado;
    }

    public boolean validarExistenciaRegistro(DSLContext query, String tabla, String columnaTabla, Object dato) {
        Result<Record> resultados = query.select().from(table(tabla)).where(field(columnaTabla).eq(dato)).fetch();
        return resultados.size() >= 1;
    }

    public void eliminarRegistro(DSLContext query, String tabla, String columna, String valor) {
        query.deleteFrom(table(tabla)).where(field(columna).eq(valor)).execute();
    }
}

