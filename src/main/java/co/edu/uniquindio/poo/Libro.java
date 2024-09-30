package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Libro {

    private String codigo, isbn, autor, titulo, editorial;
    private int unidadesDisponibles;
    private LocalDate fechaPublicacion;
    private boolean estado;
    private int precio;

    /**
     * Metodo constructor de la clase libro
     * 
     * @param codigo
     * @param isbn
     * @param autor
     * @param titulo
     * @param editorial
     * @param unidadesDisponibles
     * @param fechaPublicacion
     * @param precio
     */
    public Libro(String codigo, String isbn, String autor, String titulo, String editorial, int unidadesDisponibles,
            LocalDate fechaPublicacion, int precio) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.editorial = editorial;
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
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
     * Metodo para obtener el isbn
     * 
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Metodo que permite modificar el isbn
     * 
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Metodo para obtener el autor
     * 
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Metodo que permite modificar el autor
     * 
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Metodo para obtener el titulo
     * 
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que permite modificar el libro
     * 
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo para obtener la editorial
     * 
     * @return
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Metodo que permite modificar la editorial
     * 
     * @param editorial
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Metodo para obtener las unidades disponibles
     * 
     * @return
     */
    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    /**
     * Metodo que permite modificar las unidades disponibles
     * 
     * @param unidadesDisponibles
     */
    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    /**
     * Metodo para obtener la fecha de publicacion
     * 
     * @return
     */
    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Metodo que permite modificar la fecha de publicacion
     * 
     * @param fechaPublicacion
     */
    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * Metodo para obtener el estado del libro (disponible o no disponible)
     * 
     * @return
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Metodo que permite modificar el esatdo del libro
     * 
     * @param estado
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Metodo para obtener el precio
     * 
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Metodo que permite modificar el precio
     * 
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * Metodo para cambiar el estado del libro segun sus unidades disponibles
     * 
     * @return
     */
    public boolean actualizarEstadolibro() {
        if (getUnidadesDisponibles() > 0) {
            setEstado(true);
            return true;
        } else {
            setEstado(false);
            return false;
        }
    }

    /**
     * Metodo que forma al libro y permite mostrar su informacion
     */
    @Override
    public String toString() {
        return "Libro [codigo=" + codigo + ", isbn=" + isbn + ", autor=" + autor + ", titulo=" + titulo + ", editorial="
                + editorial + ", unidadesDisponibles=" + unidadesDisponibles + ", fechaPublicacion=" + fechaPublicacion
                + ", precio=" + precio +
                ", estado=" + estado + "]";
    }

}
