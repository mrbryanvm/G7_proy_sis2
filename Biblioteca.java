import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> catalogo;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.catalogo = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // Agregar libro al catálogo
    public void agregarLibro(Libro libro) {
        catalogo.add(libro);
    }

    // Listar todos los libros
    public void listarLibros() {
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }

    // Buscar libro por ISBN
    public Libro buscarLibro(String isbn) {
        for (Libro libro : catalogo) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Registrar un préstamo
    public void registrarPrestamo(Usuario usuario, Libro libro) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(usuario, libro, java.time.LocalDate.now(), java.time.LocalDate.now().plusDays(14));
            prestamos.add(prestamo);
            libro.setDisponible(false);
            System.out.println("Préstamo registrado con éxito.");
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    // Registrar devolución
    public void registrarDevolucion(String isbn) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibro().getIsbn().equals(isbn) && !prestamo.isDevuelto()) {
                prestamo.setDevuelto(true);
                prestamo.getLibro().setDisponible(true);
                System.out.println("Libro devuelto con éxito.");
                return;
            }
        }
        System.out.println("No se encontró un préstamo activo para este libro.");
    }

    // Listar préstamos
    public void listarPrestamos() {
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
}
