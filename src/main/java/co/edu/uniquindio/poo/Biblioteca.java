package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private double totalDineroRecaudo;
    private Collection<Bibliotecario> bibliotecarios;
    private Collection<Prestamo> prestamos;
    private LinkedList<Libro> libros;
    private Collection<Estudiante> estudiantes;

    /**
     * Metodo constructor de la clase biblioteca
     * 
     * @param nombre
     * @param totalDineroRecaudo
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.totalDineroRecaudo = calcularTotalDineroRecaudado();
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
    public void setLibros(LinkedList<Libro> libros) {
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
     * Metodo que permite consultar los datos de un prestamo dado su codigo
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
     * Metodo que permite mostrar los datos del prestamo consultado
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
     * Metodo para mostrar los datos del libro consultado dado su codigo
     * @param codigo
     */
    public void consultarLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                mostrarLibro(libro);
                break;
            }
        }
    }

    /**
     * Metodo que permite mostrar los datos del libro consultado
     * @param libro
     */

    public void mostrarLibro(Libro libro) {
        System.out.println(libro);
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
     * Metodo para verificar estudiante
     * 
     * @param cedula
     * @return
     */
    public boolean verficarEstudiante(String cedula) {
        boolean centinela = false;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un Estudiante
     * 
     * @param estudiante
     */
    public void agregarEstudiante(Estudiante estudiante) {
        if (!verficarEstudiante(estudiante.getCedula())) {
            estudiantes.add(estudiante);
        }
    }

    /**
     * Metodo para eliminar un estudiante
     * 
     * @param cedula
     */
    public void eliminarEstudiante(String cedula) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCedula().equals(cedula)) {
                estudiantes.remove(estudiante);
            }
        }
    }

    /**
     * Metodo para verificar bibliotecario
     * 
     * @param cedula
     * @return
     */
    public boolean verficarBibliotecario(String cedula) {
        boolean centinela = false;
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un Bibliotecario
     * 
     * @param biblotecario
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (!verficarEstudiante(bibliotecario.getCedula())) {
            bibliotecarios.add(bibliotecario);
        }
    }

    /**
     * Metodo para eliminar un bibliotecario
     * 
     * @param cedula
     */
    public void eliminarBibliotecario(String cedula) {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            if (bibliotecario.getCedula().equals(cedula)) {
                bibliotecarios.remove(bibliotecario);
            }
        }
    }
   
    /**
     * Metodo que permite verificar el prestamo mediante el codigo
     * @param codigo
     * @return
     */

    public boolean verficarPrestamo(String codigo) {
        boolean centinela = false;
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                centinela = true;
            }
        }
        return centinela;
    }

    /**
     * Metodo para agregar un prestamo
     * @param prestamo
     */

    public void agregarPrestamo(Prestamo prestamo,Bibliotecario bibliotecario, Estudiante estudiante) {
        if (!verficarPrestamo(prestamo.getCodigo())) {
            prestamos.add(prestamo);
            bibliotecario.agregarPrestamoBibliotecario(prestamo);
            estudiante.agregarPrestamoEstudiante(prestamo);
        }
    }

    /**
     * Metodo para eliminar un prestamo mediante el codigo
     * @param codigo
     */

    public void eliminarPrestamo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                prestamos.remove(prestamo);
            }
        }
    }
    

    /**
     * Metodo para reemplazar un libro por otro
     * 
     * @param codigo
     * @param libro
     * @return
     */

    public String reemplazarLibro(String codigo, Libro libro) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getCodigo().equals(codigo)) {
                libros.set(i, libro);
                return "Se reemplazó el libro";
            }
        }
        return "No se encontró el libro";
    }

    /**
     * Metodo que muestra el costo total del prestamo y actualiza las unidades del libro
     * @param prestamo objeto de tipo prestamo al cual se le va mostrar el costo total
     */
     public void entregarPrestamo(Prestamo prestamo){
        LocalDate fechaSalidaPreastamo=prestamo.getFechaPrestamo();
        LocalDate fechaEntregaPrestamo=prestamo.getFechaEntrega();

        double diferenciaDias = ChronoUnit.DAYS.between(fechaSalidaPreastamo, fechaEntregaPrestamo);

        double costoTotal= diferenciaDias*prestamo.getTotal();

        for(DetallePrestamo librodetalle: prestamo.getDetallePrestamos()){
            int cantidadPrestada=librodetalle.getCantidad();
            librodetalle.actualizarUnidadesLibroEntregaPrestamo(cantidadPrestada);
        }
        
        System.out.println("El costo del prestamo es= " + costoTotal);
    }
    
    /**
     * Metodo que permite calcular el total de dinero recaudado por la biblioteca
     * @return total del dinero recaudado
     */
    public double calcularTotalDineroRecaudado(){
        double dineroRecaudado=0;
        for (Prestamo prestamo : prestamos){
        LocalDate fechaSalidaPreastamo=prestamo.getFechaPrestamo();
        LocalDate fechaEntregaPrestamo=prestamo.getFechaEntrega();
        
        double diferenciaDias = ChronoUnit.DAYS.between(fechaSalidaPreastamo, fechaEntregaPrestamo);

        double costoTotal= diferenciaDias*prestamo.getTotal();

        dineroRecaudado+=costoTotal;
        }
        return dineroRecaudado;
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
