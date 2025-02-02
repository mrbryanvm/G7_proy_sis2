public class Administrador extends Usuario {
    public Administrador(String id, String nombre, String correo) {
        super(id, nombre, correo, "Administrador");
    }

    // Métodos específicos del administrador
    public void gestionarUsuarios() {
        System.out.println("Gestionando usuarios en el sistema...");
    }

    public void generarReportes() {
        System.out.println("Generando reportes de la biblioteca...");
    }

    public void administrarCatalogo() {
        System.out.println("Administrando el catálogo de libros...");
    }

    @Override
    public String toString() {
        return "Administrador [ID: " + getId() + ", Nombre: " + getNombre() + ", Correo: " + getCorreo() + "]";
    }
}
