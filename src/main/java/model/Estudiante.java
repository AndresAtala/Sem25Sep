package model;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String rut;
    private int numeroMatricula;
    private Carrera carrera;

    public Estudiante(String nombre, String apellido, String rut, int numeroMatricula, Carrera carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.numeroMatricula = numeroMatricula;
        this.carrera = carrera;
    }

    public Estudiante(String nombre, String apellido, String rut, int numeroMatricula, String codigoCarrera) {
        this.nombre = "";
        this.apellido = "";
        this.rut = "";
        this.numeroMatricula = 0;
        this.carrera = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }


    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
}
