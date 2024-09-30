package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Estudiante extends Persona {

    private boolean estado;
    private Collection<Prestamo> prestamos;

    /**
     * Metodo constructor de la clase estudiante
     * 
     * @param nombre
     * @param cedula
     * @param correo
     * @param telefono
     * @param estado
     */
    public Estudiante(String nombre, String cedula, String correo, int telefono, boolean estado) {
        super(nombre, cedula, correo, telefono);
        this.estado = estado;
        prestamos = new LinkedList<>();
    }

    /**
     * Metodo para obtener el estado del estudiante(activo o inactivo)
     * 
     * @return
     */

    public boolean isEstado() {
        return estado;
    }

    /**
     * Metodo que permite modificar el estado del estudiante
     * 
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Metodo para obtener los prestamos realizados
     * 
     * @return
     */

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Metodo que permite modificar los datos de los prestamos
     * 
     * @param prestamos
     */
    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Metodo que forma al estudiante y permite mostrar su informacion
     */

    @Override
    public String toString() {
        return "Estudiante [estado=" + estado + ", prestamos=" + prestamos + "]";
    }

}
