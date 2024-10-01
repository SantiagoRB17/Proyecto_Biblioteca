package co.edu.uniquindio.poo;

public class DetallePrestamo {

    private int cantidad;
    private Prestamo prestamo;
    private Libro libro;
    private double subTotal;

    /**
     * Metodo constructor de la clase detallePrestamo
     * 
     * @param cantidad
     * @param prestamo
     * @param libro
     */
    public DetallePrestamo(int cantidad, Prestamo prestamo, Libro libro) {
        this.cantidad = cantidad;
        this.prestamo = prestamo;
        this.libro = libro;
        this.subTotal = calcularSubtotal();
    }

    /**
     * Metodo que permite calcular el subtotal de cada libro
     * @return
     */
    public double calcularSubtotal() {
        return cantidad * libro.getPrecio();
    }

    /**
     * Metodo para obtener la cantidad
     * 
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo que permite modificar la cantidad
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Metodo para obtener el prestamo
     * 
     * @return
     */

    public Prestamo getPrestamo() {
        return prestamo;
    }

    /**
     * Metodo que permite modificar los datos del prestamo
     * 
     * @param prestamo
     */

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    /**
     * Metodo para obtener el libro
     * 
     * @return
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Metodo que permite modificar los datos del libro
     * 
     * @param libro
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Metodo para obtener el subtotal
     * 
     * @return
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * Metodo que permite modificar el subtotal
     * 
     * @param subTotal
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Metodo que premite actualizar las unidades disponibles del libro
     */
    public void actualizarUnidadesLibro() {
        libro.setUnidadesDisponibles(libro.getUnidadesDisponibles() - getCantidad());
        libro.actualizarEstadolibro();

    }

    /**
     * Metodo para actualizar las unidades disponibles despues de la entrega del prestamo
     * @param cantidadPrestada la cantidad prestada del libro
     */
    public void actualizarUnidadesLibroEntregaPrestamo(int cantidadPrestada){
            int actualizarUnidadesLibro= libro.getUnidadesDisponibles()+cantidadPrestada;
            libro.setUnidadesDisponibles(actualizarUnidadesLibro);
    }

    /**
     * Metodo que forma al detallePrestamo y permite mostrar su informacion
     */
    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", libro=" + libro + ", subTotal="
                + subTotal + "]";
    }

}
