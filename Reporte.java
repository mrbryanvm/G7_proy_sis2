import java.util.List;

public class Reporte {
    private Biblioteca biblioteca;

    public Reporte(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    // Generar un reporte de libros prestados
    public void generarReportePrestamos() {
        System.out.println("Reporte de préstamos:");
        biblioteca.listarPrestamos();
    }

    // Generar un reporte de multas pendientes
    public void generarReporteMultas(List<Multa> multas) {
        System.out.println("Reporte de multas pendientes:");
        for (Multa multa : multas) {
            if (!multa.isPagada()) {
                System.out.println(multa);
            }
        }
    }

    // Generar un reporte general del catálogo de libros
    public void generarReporteCatalogo() {
        System.out.println("Reporte de catálogo de libros:");
        biblioteca.listarLibros();
    }
}

