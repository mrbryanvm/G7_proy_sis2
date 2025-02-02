import java.util.ArrayList;
import java.util.List;

public class ListaRoja {
    private List<Usuario> usuariosRestringidos;

    public ListaRoja() {
        this.usuariosRestringidos = new ArrayList<>();
    }

    // Agregar usuario a la lista roja
    public void agregarUsuario(Usuario usuario) {
        if (!usuariosRestringidos.contains(usuario)) {
            usuariosRestringidos.add(usuario);
            System.out.println("Usuario agregado a la lista roja: " + usuario.getNombre());
        } else {
            System.out.println("El usuario ya está en la lista roja.");
        }
    }

    // Verificar si un usuario está en la lista roja
    public boolean estaEnListaRoja(Usuario usuario) {
        return usuariosRestringidos.contains(usuario);
    }

    // Remover usuario de la lista roja
    public void removerUsuario(Usuario usuario) {
        if (usuariosRestringidos.contains(usuario)) {
            usuariosRestringidos.remove(usuario);
            System.out.println("Usuario removido de la lista roja: " + usuario.getNombre());
        }
    }

    // Listar usuarios en la lista roja
    public void listarUsuariosRestringidos() {
        System.out.println("Usuarios en la lista roja:");
        for (Usuario usuario : usuariosRestringidos) {
            System.out.println(usuario);
        }
    }
}
