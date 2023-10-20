package model;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String rut;
    private int numeroMatricula;

    // Constructor con parámetros
    public Estudiante(String nombre, String apellido, String rut, int numeroMatricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.numeroMatricula = numeroMatricula;
    }

    // Constructor sin parámetros
    public Estudiante() {
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.numeroMatricula = 0;
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Métodos getter y setter para rut
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    // Métodos getter y setter para número de matrícula
    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
}
