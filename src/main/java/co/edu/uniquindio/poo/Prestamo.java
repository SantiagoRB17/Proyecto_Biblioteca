package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Prestamo {

    private String codigo;
    private LocalDate fechaPrestamo, fechaEntrega;
    private double total;
    private Bibliotecario bibliotecario;
    private Estudiante estudiante;
    private Collection<DetallePrestamo> detallePrestamos;

    /**
     * Metodo constructor de la clase prestamo
     * 
     * @param codigo
     * @param fechaPrestamo
     * @param fechaEntrega
     * @param bibliotecario
     * @param estudiante
     */
    public Prestamo(String codigo, LocalDate fechaPrestamo, LocalDate fechaEntrega, Bibliotecario bibliotecario,
            Estudiante estudiante) {
        this.codigo = codigo;
        this.fechaEntrega = fechaEntrega;
        this.fechaPrestamo = fechaPrestamo;
        detallePrestamos = new LinkedList<>();
        this.total = calcularTotal();
    }

    /**
     * Metodo que permite sumar el precio de todos los libros para obtener el total
     * 
     * @return
     */
    public double calcularTotal() {
        double total = 0;
        for (DetallePrestamo detallePrestamo : detallePrestamos) {
            total += detallePrestamo.getSubTotal();
        }
        return total;
    }

    /**
     * Metodo para obtener el codigo
     * 
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo que permite modificar el codigo
     * 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para obtener la fecha del prestamo
     * 
     * @return
     */
    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * Metodo que permite modificar la fechaa del prestamo
     * 
     * @param fechaPrestamo
     */
    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * Metodo para obtener la fecha de entrega de los libros
     * 
     * @return
     */
    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Metodo que permite modificar la fecha de entrega de los libros
     * 
     * @param fechaEntrega
     */
    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Metodo para obtener el total
     * 
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     * Metodo que permite modificar el total
     * 
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Metodo para obtener los datos del bibliotecario
     * 
     * @return
     */
    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    /**
     * Metodo que permite modificar los datos del bibliotecario
     * 
     * @param bibliotecario
     */
    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    /**
     * Metodo para obtener los datos del estudiante
     * 
     * @return
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Metodo que permite modificar los datos del estudiante
     * 
     * @param estudiante
     */
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /**
     * Metodo para obtener el detalle prestamo
     * 
     * @return
     */
    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    /**
     * Metodo que permite modificar los datos del detalle prestamo
     * 
     * @param detallePrestamos
     */
    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }

    /**
     * Metodo para agregar un detallePrestamo, con la condicion de que el libro se
     * encuentre disponible
     * 
     * @param detallePrestamo
     * @param libro
     */
    public void agregarDetallePrestamo(DetallePrestamo detallePrestamo, Libro libro) {
        if (detallePrestamo.getPrestamo().getCodigo().equals(getCodigo())) {
            if (estudiante.isEstado()) {
                if (libro.actualizarEstadolibro()) {
                    detallePrestamos.add(detallePrestamo);
                    detallePrestamo.actualizarUnidadesLibro();
                    libro.actualizarEstadolibro();
                }
            }
        }
    }

    /**
     * Metodo que forma al prestamo y permite mostrar su informacion
     */
    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega
                + ", total=" + total + ", bibliotecario=" + bibliotecario + ", estudiante=" + estudiante
                + ", detallePrestamos=" + detallePrestamos + "]";
    }

}
