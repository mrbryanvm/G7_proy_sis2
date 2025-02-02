import java.time.LocalDate;

public class Multa {
    private Usuario usuario;
    private Libro libro;
    private double monto;
    private LocalDate fechaGeneracion;
    private boolean pagada;

    public Multa(Usuario usuario, Libro libro, double monto) {
        this.usuario = usuario;
        this.libro = libro;
        this.monto = monto;
        this.fechaGeneracion = LocalDate.now();
        this.pagada = false;
    }

    // Getters y Setters
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Libro getLibro() { return libro; }
    public void setLibro(Libro libro) { this.libro = libro; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public LocalDate getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDate fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }

    public boolean isPagada() { return pagada; }
    public void pagarMulta() { this.pagada = true; }

    @Override
    public String toString() {
        return "Multa [Usuario: " + usuario.getNombre() + ", Libro: " + libro.getTitulo() +
               ", Monto: " + monto + ", Fecha: " + fechaGeneracion + ", Pagada: " + (pagada ? "Sí" : "No") + "]";
    }
}
