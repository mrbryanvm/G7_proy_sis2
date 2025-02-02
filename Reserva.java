import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaReserva;
    private LocalDate fechaExpiracion;
    private boolean activa;

    public Reserva(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = LocalDate.now();
        this.fechaExpiracion = fechaReserva.plusDays(3); // Expira en 3 días si no se retira
        this.activa = true;
    }

    // Getters y Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public LocalDate getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDate fechaReserva) { this.fechaReserva = fechaReserva; }

    public LocalDate getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(LocalDate fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public boolean isActiva() { return activa; }
    public void cancelarReserva() { this.activa = false; }

    @Override
    public String toString() {
        return "Reserva [Usuario: " + usuario.getNombre() + ", Libro: " + libro.getTitulo() +
               ", Fecha de Reserva: " + fechaReserva + ", Expira: " + fechaExpiracion +
               ", Activa: " + (activa ? "Sí" : "No") + "]";
    }
}
