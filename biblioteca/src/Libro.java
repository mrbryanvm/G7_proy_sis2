public class Libro {
    private String nombre;
    private String autor;
    private String editorial;
    private int anio;
    private String isbn;
    private boolean disponible;

    // Constructor
    public Libro(String nombre, String autor, String editorial, int anio, String isbn, boolean disponible) {
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.anio = anio;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getAnio() {
        return anio;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}