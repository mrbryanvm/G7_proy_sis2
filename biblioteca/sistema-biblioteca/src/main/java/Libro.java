import java.time.Year;

public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private int anio;
    private String isbn;
    private boolean disponible;
    private int cantidad;

    public Libro(String nombre, String autor, String editorial, int anio, String isbn, int cantidad) {
        setNombre(nombre);
        setAutor(autor);
        setEditorial(editorial);
        setAnio(anio);
        setIsbn(isbn);
        setCantidad(cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacío.");
        }
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacía.");
        }
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        int anioActual = Year.now().getValue();
        if (anio < 0 || anio > anioActual) {
            throw new IllegalArgumentException("El año debe estar entre 0 y " + anioActual);
        }
        this.anio = anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || !isbn.matches("\\d{13}")) {
            throw new IllegalArgumentException("El ISBN debe contener exactamente 13 dígitos numéricos.");
        }
        this.isbn = isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de libros no puede ser negativa.");
        }
        this.cantidad = cantidad;
        this.disponible = cantidad > 0; // Se actualiza la disponibilidad automáticamente
    }

    public void prestarLibro() {
        if (cantidad <= 0) {
            throw new IllegalStateException("No hay ejemplares disponibles para préstamo.");
        }
        cantidad--;
        this.disponible = cantidad > 0;
    }

    public void devolverLibro() {
        cantidad++;
        this.disponible = true;
    }
}
