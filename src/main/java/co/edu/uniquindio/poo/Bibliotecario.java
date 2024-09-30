package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class Bibliotecario extends Persona {

    private double salario;
    private LocalDate fechaIngreso;
    private Collection<Prestamo> prestamos;

    /**
     * Metodo constructor de la clase bibliotecario
     * 
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param salario
     * @param fechaIngreso
     */
    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario,
            LocalDate fechaIngreso) {
        super(nombre, cedula, correo, telefono);
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        prestamos = new LinkedList<>();
    }

    /**
     * Metodo que permite obtener el salario del bibliotecario
     * 
     * @return
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Metodo que permite modificar el salario del bibliotecario
     * 
     * @param salario
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Metodo que permite obtener la fecha de ingreso del bibliotecario
     * 
     * @return
     */
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Metodo que permite modificar la fecha de ingreso del bibliotecario
     * 
     * @param fechaIngreso
     */
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Metodo que permite obtener los prestamos realizados
     * 
     * @return
     */
    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Metodo que permite modificar los prestamos realizados
     * 
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Metodo para agregar prestamo al bibliotecario
     * 
     * @param prestamo
     */
    public void agregarPrestamoBibliotecario(Prestamo prestamo) {
        if (prestamo.getBibliotecario().getCedula().equals(getCedula())) {
            prestamos.add(prestamo);
        }
    }

    /**
     * Metodo que forma al bibliotecario y permite mostrar su informacion
     */
    @Override
    public String toString() {
        return "Bibliotecario [salario=" + salario + ", fechaIngreso=" + fechaIngreso + ", prestamos=" + prestamos
                + "]";
    }

}
