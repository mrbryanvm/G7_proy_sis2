public class Usuario {
    private String id;
    private String nombre;
    private String correo;
    private String tipoUsuario; // Estudiante, Profesor, Bibliotecario, etc.
    
    public Usuario(String id, String nombre, String correo, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    @Override
    public String toString() {
        return "Usuario [ID: " + id + ", Nombre: " + nombre + ", Correo: " + correo + ", Tipo: " + tipoUsuario + "]";
    }
}
