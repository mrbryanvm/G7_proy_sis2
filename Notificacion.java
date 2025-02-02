public class Notificacion {
    private Usuario usuario;
    private String mensaje;
    private boolean leida;

    public Notificacion(Usuario usuario, String mensaje) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.leida = false;
    }

    // Marcar notificación como leída
    public void marcarComoLeida() {
        this.leida = true;
    }

    // Getters y Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public boolean isLeida() { return leida; }

    @Override
    public String toString() {
        return "Notificación [Usuario: " + usuario.getNombre() + ", Mensaje: " + mensaje +
               ", Estado: " + (leida ? "Leída" : "No Leída") + "]";
    }
}
