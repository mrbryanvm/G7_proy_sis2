import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorTest {
    private Administrador administrador;

    @BeforeEach
    void setUp() {
        administrador = new Administrador("Juan", "Perez", 1234567, 76543210, "juan.perez@gmail.com", "Calle Falsa 123", "Biblioteca Central");
    }

    @Test
    void testConstructor() {
        assertEquals("Juan", administrador.getNombre());
        assertEquals("Perez", administrador.getApellido());
        assertEquals(1234567, administrador.getCi());
        assertEquals(76543210, administrador.getTelefono());
        assertEquals("juan.perez@gmail.com", administrador.getCorreo());
        assertEquals("Calle Falsa 123", administrador.getDireccion());
        assertEquals("Biblioteca Central", administrador.getBibliotecaAsignada());
    }

    @Test
    void testSettersAndGetters() {
        administrador.setNombre("Carlos");
        assertEquals("Carlos", administrador.getNombre());

        administrador.setApellido("Gómez");
        assertEquals("Gómez", administrador.getApellido());

        administrador.setCi(9876543);
        assertEquals(9876543, administrador.getCi());

        administrador.setTelefono(71234567);
        assertEquals(71234567, administrador.getTelefono());

        administrador.setCorreo("carlos.gomez@gmail.com");
        assertEquals("carlos.gomez@gmail.com", administrador.getCorreo());

        administrador.setDireccion("Av. Libertad 456");
        assertEquals("Av. Libertad 456", administrador.getDireccion());

        administrador.setBibliotecaAsignada("Biblioteca Norte");
        assertEquals("Biblioteca Norte", administrador.getBibliotecaAsignada());
    }

    @Test
    void testValidaciones() {
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> new Administrador("", "Apellido", 1234567, 76543210, "email@dominio.com", "Direccion", "Biblioteca"));
        assertEquals("El nombre no puede estar vacío.", ex1.getMessage());

        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "", 1234567, 76543210, "email@dominio.com", "Direccion", "Biblioteca"));
        assertEquals("El apellido no puede estar vacío.", ex2.getMessage());

        Exception ex3 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "Apellido", -1, 76543210, "email@dominio.com", "Direccion", "Biblioteca"));
        assertEquals("El CI debe ser un número positivo.", ex3.getMessage());

        Exception ex4 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "Apellido", 1234567, 123, "email@dominio.com", "Direccion", "Biblioteca"));
        assertEquals("El teléfono debe tener 8 dígitos.", ex4.getMessage());

        Exception ex5 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "Apellido", 1234567, 76543210, "correo_invalido", "Direccion", "Biblioteca"));
        assertEquals("Correo electrónico no válido.", ex5.getMessage());

        Exception ex6 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "Apellido", 1234567, 76543210, "email@dominio.com", "", "Biblioteca"));
        assertEquals("La dirección no puede estar vacía.", ex6.getMessage());

        Exception ex7 = assertThrows(IllegalArgumentException.class, () -> new Administrador("Nombre", "Apellido", 1234567, 76543210, "email@dominio.com", "Direccion", ""));
        assertEquals("La biblioteca asignada no puede estar vacía.", ex7.getMessage());

        Exception ex8 = assertThrows(IllegalArgumentException.class, () -> administrador.setContrasena("123456"));
        assertEquals("La contraseña debe tener al menos 8 caracteres, una mayúscula y un número.", ex8.getMessage());

        Exception ex9 = assertThrows(IllegalArgumentException.class, () -> administrador.setContrasena("abcdefghi"));
        assertEquals("La contraseña debe tener al menos 8 caracteres, una mayúscula y un número.", ex9.getMessage());
    }
}
