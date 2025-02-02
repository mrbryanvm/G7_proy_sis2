import java.time.LocalDate;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        // Crear instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Crear usuarios de prueba
        Usuario usuario1 = new Usuario("U001", "Carlos Pérez", "carlos@umss.edu", "Estudiante");
        Usuario usuario2 = new Usuario("U002", "María López", "maria@umss.edu", "Profesor");

        // Crear libros de prueba
        Libro libro1 = new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", "Editorial XYZ", 1605);
        Libro libro2 = new Libro("978-1-4028-9462-6", "Cien años de soledad", "Gabriel García Márquez", "Editorial ABC", 1967);

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Mostrar libros disponibles
        System.out.println("\n📚 Catálogo de la Biblioteca:");
        biblioteca.listarLibros();

        // Registrar préstamo
        System.out.println("\n📖 Registrando préstamo...");
        biblioteca.registrarPrestamo(usuario1, libro1);

        // Mostrar lista de préstamos
        System.out.println("\n📋 Préstamos registrados:");
        biblioteca.listarPrestamos();

        // Registrar devolución
        System.out.println("\n🔄 Registrando devolución...");
        biblioteca.registrarDevolucion("978-3-16-148410-0");

        // Mostrar libros actualizados
        System.out.println("\n📚 Catálogo después de la devolución:");
        biblioteca.listarLibros();
    }
}
