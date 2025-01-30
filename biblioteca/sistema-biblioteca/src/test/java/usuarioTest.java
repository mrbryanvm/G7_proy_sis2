import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class usuarioTest {
    @Test
    void testUsuarioCreacionExitosa() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        assertEquals("Juan", usuario.getNombre());
        assertEquals("Perez", usuario.getApellido());
        assertEquals("juan.perez@example.com", usuario.getCorreo());
        assertEquals(123456, usuario.getCi());
        assertEquals(789012776, usuario.getSis());
        assertEquals(76543210, usuario.getTelefono());
        assertEquals("Estudiante", usuario.getTipo_usuario());
    }

    @Test
    void testNombreInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new usuario("", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        });
        assertEquals("Nombre o apellido inválido. Asegúrese de que no estén vacíos o contengan más de dos palabras.", exception.getMessage());
    }

    @Test
    void testCorreoInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new usuario("Juan", "Perez", "correo_invalido", 123456, 789012776, 76543210, "Estudiante");
        });
        assertEquals("Correo electrónico inválido.", exception.getMessage());
    }

    @Test
    void testTelefonoInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 123, "Estudiante");
        });
        assertEquals("Número de teléfono inválido.", exception.getMessage());
    }

    @Test
    void testCIMenorQueCero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new usuario("Juan", "Perez", "juan.perez@example.com", -1, 789012, 76543210, "Estudiante");
        });
        assertEquals("CI inválido.", exception.getMessage());
    }

    @Test
    void testSetNombreValido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        usuario.setnombre("Carlos");
        assertEquals("Carlos", usuario.getNombre());
    }

    @Test
    void testSetNombreInvalido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.setnombre("");
        });
        assertEquals("Nombre inválido.", exception.getMessage());
    }

    @Test
    void testSetCorreoValido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        usuario.setcorreo("carlos.lopez@example.com");
        assertEquals("carlos.lopez@example.com", usuario.getCorreo());
    }

    @Test
    void testSetCorreoInvalido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.setcorreo("correo_invalido");
        });
        assertEquals("Correo electrónico inválido.", exception.getMessage());
    }

    @Test
    void testSetTelefonoValido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        usuario.settelefono(87654321);
        assertEquals(87654321, usuario.getTelefono());
    }

    @Test
    void testSetTelefonoInvalido() {
        usuario usuario = new usuario("Juan", "Perez", "juan.perez@example.com", 123456, 789012776, 76543210, "Estudiante");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            usuario.settelefono(123);
        });
        assertEquals("Número de teléfono inválido.", exception.getMessage());
    }
}
