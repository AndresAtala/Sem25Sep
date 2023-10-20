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

    // Getters and setters
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

    // Métodos de gestión de estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        this.estudiantes.add(estudiante);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        this.estudiantes.remove(estudiante);
    }
}
