package model.data.dao;

import model.Carrera;
import org.jooq.Record1;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.Record;
import static org.jooq.impl.DSL.*;
import java.util.ArrayList;
import java.util.List;

public class CarreraDAO {

    public static boolean validarExistenciaCarrera(DSLContext query, String columnaTabla, Object dato) {
        Result<Record> resultados = query.select().from(table("Carrera")).where(field(columnaTabla).eq(dato)).fetch();
        return resultados.size() >= 1;
    }

    public static void agregarCarrera(DSLContext query, Carrera carrera) {
        Table tablaCarrera = table(name("Carrera"));
        query.insertInto(tablaCarrera, field("nombre_carrera"), field("codigo"), field("cantidad_semestres"))
                .values(carrera.getNombre(), carrera.getCodigo(), carrera.getCantidadSemestres()).execute();
    }
    public static Carrera buscarCarrera(DSLContext query, Object codigoCarrera) {
        Result<Record> resultados = query.select().from(table("Carrera")).where(field("codigo").eq(codigoCarrera)).fetch();

        if (resultados.isEmpty()) {
            return null;
        } else {
            Record record = resultados.get(0);
            String nombreCarrera = record.get("nombre_carrera", String.class);
            String codigo = record.get("codigo", String.class);
            int cantidadSemestres = record.get("cantidad_semestres", Integer.class);

            Carrera carrera = new Carrera(nombreCarrera, codigo, cantidadSemestres);
            return carrera;
        }
    }
    public String[] obtenerCodigosCarreras(DSLContext query) {
        Result<Record1<Object>> resultados = query.select(field("codigo")).from(table("Carrera")).fetch();
        List<String> codigos = new ArrayList<>();
        for (Record1<Object> record : resultados) {
            codigos.add(record.component1().toString());
        }
        return codigos.toArray(new String[0]);
    }
}
