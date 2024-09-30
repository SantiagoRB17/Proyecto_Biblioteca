package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private Collection<Libro> libros;
    private Collection<Estudiante> estudiantes;

    public Biblioteca(String nombre, double totalDineroRecaudo) {
        this.nombre = nombre;
        this.totalDineroRecaudo = totalDineroRecaudo;
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        estudiantes = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalDineroRecaudo() {
        return totalDineroRecaudo;
    }

    public void setTotalDineroRecaudo(double totalDineroRecaudo) {
        this.totalDineroRecaudo = totalDineroRecaudo;
    }

    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Collection<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Collection<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    /**
     * Metodo que permite consultar un prestamo dado su codigo
     * 
     * @param codigo
     */
    public void consultarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                mostrarPrestamo(prestamo);
                break;
            }
        }
    }

    /**
     * Metodo que permite mostrar el prestamo consultado
     * 
     * @param prestamo
     */
    public void mostrarPrestamo(Prestamo prestamo) {
        System.out.println(prestamo);
    }

    /**
     * Metodo que permite saber cual es el estudiante con mas prestamos
     */
    public void estudianteMasPrestamos() {
        Estudiante estudianteMaxPrestamos = null;
        int maxPrestamos = 0;

        for (Estudiante estudiante : estudiantes) {
            int comparador = estudiante.getPrestamos().size();
            if (comparador > maxPrestamos) {
                maxPrestamos = comparador;
                estudianteMaxPrestamos = estudiante;
            }
        }
        mostarEstudianteMasPrestamos(estudianteMaxPrestamos);
    }

    /**
     * Metodo que permite mostrar al estudiante con mas prestamos
     * 
     * @param estudiante
     */
    public void mostarEstudianteMasPrestamos(Estudiante estudiante) {
        if (estudiante != null) {
            System.out.println("Estudiante con más préstamos: " + estudiante);
        } else {
            System.out.println("No hay estudiantes.");
        }
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }

}
