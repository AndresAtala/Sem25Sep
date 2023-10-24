package model;

import java.util.ArrayList;

public class Carrera {
    private String nombre;
    private String codigo;
    private int cantidadSemestres;
    private ArrayList<Estudiante> estudiantes;

    public Carrera() {
        this.nombre = "";
        this.codigo = "";
        this.cantidadSemestres = 0;
        this.estudiantes = new ArrayList<>();
    }

    public Carrera(String nombre, String codigo, int cantidadSemestres) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.cantidadSemestres = cantidadSemestres;
        this.estudiantes = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidadSemestres() {
        return cantidadSemestres;
    }

    public void setCantidadSemestres(int cantidadSemestres) {
        this.cantidadSemestres = cantidadSemestres;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }


    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }

    public Estudiante buscarEstudiantePorRut(String rut) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getRut().equals(rut)) {
                return estudiante;
            }
        }
        return null;
    }

    public void modificarEstudiante(String rut, Estudiante estudianteModificado) {
        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            if (estudiante.getRut().equals(rut)) {
                estudiantes.set(i, estudianteModificado);
                break;
            }
        }
    }
}
