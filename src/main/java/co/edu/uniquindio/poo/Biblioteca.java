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

    /**
     * Metodo constructor de la clase biblioteca
     * 
     * @param nombre
     * @param totalDineroRecaudo
     */
    public Biblioteca(String nombre, double totalDineroRecaudo) {
        this.nombre = nombre;
        this.totalDineroRecaudo = totalDineroRecaudo;
        bibliotecarios = new LinkedList<>();
        prestamos = new LinkedList<>();
        libros = new LinkedList<>();
        estudiantes = new LinkedList<>();
    }

    /**
     * Metodo para obtener el nombre de la biblioteca
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que permite modificar el nombre
     * 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener el total del dinero recaudado de la biblioteca
     * 
     * @return
     */
    public double getTotalDineroRecaudo() {
        return totalDineroRecaudo;
    }

    /**
     * Metodo que permite modificar el total del dinero recaudado
     * 
     * @param totalDineroRecaudo
     */
    public void setTotalDineroRecaudo(double totalDineroRecaudo) {
        this.totalDineroRecaudo = totalDineroRecaudo;
    }

    /**
     * Metodo para obtener a los bibliotecarios pertenecientes a la biblioteca
     * 
     * @return
     */
    public Collection<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    /**
     * Metodo que permite modificar a los bibliotecarios
     * 
     * @param bibliotecarios
     */
    public void setBibliotecarios(Collection<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    /**
     * Metodo para obtener los prestamos realizados de la biblioteca
     * 
     * @return
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Metodo que permite modificar los prestamos
     * 
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Metodo para obtener los libros que tiene la biblioteca
     * 
     * @return
     */
    public Collection<Libro> getLibros() {
        return libros;
    }

    /**
     * Metodo que permite modificar los libros de la biblioteca
     * 
     * @param libros
     */
    public void setLibros(Collection<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Metodo para obtener los estudiantes registrados en la biblioteca
     * 
     * @return
     */
    public Collection<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    /**
     * Metodo que permite modificar a los estudiantes registrados
     * 
     * @param estudiantes
     */
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

    /**
     * Metodo que busca cuantas veces esta un libro en la lista de prestamos
     * 
     * @param nombre Nombre del libro a buscar
     * @return El numero de veces que esta el libro
     */
    public int consultarCantidadPrestamosLibro(String nombre) {
        int contador = 0;
        for (Prestamo prestamo : prestamos) {
            for (DetallePrestamo detallePrestamo : prestamo.getDetallePrestamos()) {
                if (detallePrestamo.getLibro().getTitulo().equals(nombre)) {
                    contador += 1;
                    break;
                }
            }

        }
        return contador;
    }

    /**
     * Metodo que permite mostrar los prestamos realizados por cada empleado
     */
    public void mostrarPrestamoEmpleado() {
        int[] cantidadPrestamosBibliotecarios = new int[bibliotecarios.size()];
        for (Prestamo prestamo : prestamos) {
            int i = 0;
            Bibliotecario bibliotecarioPrestamo = prestamo.getBibliotecario();
            for (Bibliotecario bibliotecario : bibliotecarios) {
                if (bibliotecarioPrestamo.equals(bibliotecario)) {
                    cantidadPrestamosBibliotecarios[i] += 1;
                    break;
                }
                i++;
            }
        }
        int j = 0;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            System.out.println(
                    "Nombre= " + bibliotecario.getNombre() + ", Prestamos= " + cantidadPrestamosBibliotecarios[j]);
        }
        j++;
    }

    /**
     * Metodo que permite concretar la informacion para mostrar el objeto
     */
    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", totalDineroRecaudo=" + totalDineroRecaudo + ", bibliotecarios="
                + bibliotecarios + ", prestamos=" + prestamos + ", libros=" + libros + ", estudiantes=" + estudiantes
                + "]";
    }

}
