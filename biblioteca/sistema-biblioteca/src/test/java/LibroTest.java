import static org.junit.jupiter.api.Assertions.*;
import java.time.Year;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibroTest {
     private Libro libro;

    @BeforeEach
    void setUp() {
        libro = new Libro("El Hobbit", "J.R.R. Tolkien", "Minotauro", 1937, "9780261103283", 5);
    }

    @Test
    void testConstructor() {
        assertEquals("El Hobbit", libro.getNombre());
        assertEquals("J.R.R. Tolkien", libro.getAutor());
        assertEquals("Minotauro", libro.getEditorial());
        assertEquals(1937, libro.getAnio());
        assertEquals("9780261103283", libro.getIsbn());
        assertTrue(libro.isDisponible());
        assertEquals(5, libro.getCantidad());
    }

    @Test
    void testSettersAndGetters() {
        libro.setNombre("1984");
        assertEquals("1984", libro.getNombre());

        libro.setAutor("George Orwell");
        assertEquals("George Orwell", libro.getAutor());

        libro.setEditorial("Debolsillo");
        assertEquals("Debolsillo", libro.getEditorial());

        libro.setAnio(1949);
        assertEquals(1949, libro.getAnio());

        libro.setIsbn("9780451524935");
        assertEquals("9780451524935", libro.getIsbn());

        libro.setCantidad(10);
        assertEquals(10, libro.getCantidad());
        assertTrue(libro.isDisponible());
    }

    @Test
    void testDisponibilidadAutomatica() {
        libro.setCantidad(0);
        assertFalse(libro.isDisponible());

        libro.setCantidad(3);
        assertTrue(libro.isDisponible());
    }

    @Test
    void testPrestarLibro() {
        libro.prestarLibro();
        assertEquals(4, libro.getCantidad());
        assertTrue(libro.isDisponible());

        libro.setCantidad(1);
        libro.prestarLibro();
        assertEquals(0, libro.getCantidad());
        assertFalse(libro.isDisponible());

        Exception exception = assertThrows(IllegalStateException.class, libro::prestarLibro);
        assertEquals("No hay ejemplares disponibles para préstamo.", exception.getMessage());
    }

    @Test
    void testDevolverLibro() {
        libro.setCantidad(0);
        libro.devolverLibro();
        assertEquals(1, libro.getCantidad());
        assertTrue(libro.isDisponible());
    }

    @Test
    void testValidaciones() {
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Libro("", "Autor", "Editorial", 2020, "9781234567890", 2));
        assertEquals("El nombre del libro no puede estar vacío.", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Libro("Libro", "", "Editorial", 2020, "9781234567890", 2));
        assertEquals("El autor no puede estar vacío.", ex2.getMessage());

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> new Libro("Libro", "Autor", "Editorial", 3020, "9781234567890", 2));
        assertEquals("El año debe estar entre 0 y " + Year.now().getValue(), ex3.getMessage());

        Exception ex4 = assertThrows(IllegalArgumentException.class, () -> new Libro("Libro", "Autor", "Editorial", 2020, "1234", 2));
        assertEquals("El ISBN debe contener exactamente 13 dígitos numéricos.", ex4.getMessage());

        Exception ex5 = assertThrows(IllegalArgumentException.class, () -> new Libro("Libro", "Autor", "Editorial", 2020, "9781234567890", -2));
        assertEquals("La cantidad de libros no puede ser negativa.", ex5.getMessage());
    }
}

