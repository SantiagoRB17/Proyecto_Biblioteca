package co.edu.uniquindio.poo;

import java.time.LocalDate;

/**
 * Metodo main
 *
 */
public class App {
    public static void main(String[] args) {
        //Crear una biblioteca
        Biblioteca biblioteca = new Biblioteca("San Jose");

        //Crea dos bibliotecarios
        Bibliotecario bibliotecario1 = new Bibliotecario("Martin", "123456", "martin@gamil.com", 3122832, 200000,null);

        Bibliotecario bibliotecario2 = new Bibliotecario("Jose", "123478", "Jose@gamil.com", 300451782, 200000,null);

        //Agregar el Bibliotecario a la Biblioteca
        biblioteca.agregarBibliotecario(bibliotecario1);
        biblioteca.agregarBibliotecario(bibliotecario2);

        //Crear libros
        Libro libro1 = new Libro("1", "12726392", "Gabriel garcia marquez", "Cien Años de Soledad", "Editorial Sudamericana", 10, null, 1000);

        Libro libro2 = new Libro("2", "823823", "Gabriel garcia marquez", "Cronica de una muerte anunciada", "La oveja negra", 5, null, 1000);

        //Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        //Crea 2 estudiantes
        Estudiante estudiante1 = new Estudiante("Santiago", "3821722", "Santiago@gamil.com", 326237283, true);

        Estudiante estudiante2 = new Estudiante("Veronica", "212919283", "veronica@gmail.com", 12329872, true);

        //Registrar estudiante en la biblioteca
        biblioteca.agregarEstudiante(estudiante1);
        biblioteca.agregarEstudiante(estudiante2);

        //Crear prestamos
        LocalDate fechaPrestamo=LocalDate.of(2024, 9, 22);
        LocalDate fechaEntrega=LocalDate.of(2024, 9, 26);
        Prestamo prestamo1 = new Prestamo("1", fechaPrestamo, fechaEntrega, bibliotecario1, estudiante2);

        //Agregar prestamo
        biblioteca.agregarPrestamo(prestamo1);

        //Crear detalle prestamo
        DetallePrestamo detalle1 = new DetallePrestamo(2, prestamo1, libro2);
        
        DetallePrestamo detalle2 = new DetallePrestamo(4, prestamo1, libro1);

        //Agregar detalle prestamo
        prestamo1.agregarDetallePrestamo(detalle1, libro2);
        prestamo1.agregarDetallePrestamo(detalle2, libro1);

        //Calcular subtotal
        detalle1.calcularSubtotal();
        detalle2.calcularSubtotal();

        //Calcular total
        prestamo1.calcularTotal();

        //mostrar prestamo dado su codigo
        biblioteca.consultarPrestamo("1");

        //mostrar libro dado su codigo
        biblioteca.consultarLibro("1");

        //mostrar objetos
        System.out.println(biblioteca.toString());
        System.out.println(detalle1.toString());
        System.out.println(prestamo1.toString());
        
    }
}
