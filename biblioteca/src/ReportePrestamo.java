import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import Frontend.Plantilla;

public class ReportePrestamo {
    private JFrame frame;
    private JPanel panel;
    private usuario usuario=SesionUsuario.getUsuarioActual();
    private String nombreLibro;
    private String autor;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public ReportePrestamo(String nombreLibro, String autor, Date fechaPrestamo, Date fechaDevolucion) {
        this.nombreLibro=nombreLibro;
        this.autor=autor;
        this.fechaPrestamo=fechaPrestamo;
        this.fechaDevolucion=fechaDevolucion;
        mostrarReporte();
    }

    private void mostrarReporte() {
        frame = new JFrame("Reporte de Préstamo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea areaReporte = new JTextArea();
        areaReporte.setEditable(false);

        // Crear el reporte
        String reporte = generarReporte();
        areaReporte.setText(reporte);

        JScrollPane scrollPane = new JScrollPane(areaReporte);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botón de imprimir
        JButton btnImprimir = new JButton("Imprimir");
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Imprimiendo reporte...");
                frame.dispose(); // Cerrar el reporte después de imprimir
            }
        });

        panel.add(btnImprimir, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private String generarReporte() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Préstamo\n");
        reporte.append("----------------------------\n");
        reporte.append("Usuario: ").append(usuario.getNombre()).append(" ").append(usuario.getApellido()).append("\n");
        reporte.append("Tipo de Usuario: ").append(usuario.getTipo_usuario()).append("\n");
        reporte.append("Libro: ").append(nombreLibro).append(" - ").append(autor).append("\n");
        reporte.append("Fecha de Préstamo: ").append(fechaPrestamo.toString()).append("\n");
        reporte.append("Fecha de Devolución: ").append(fechaDevolucion.toString()).append("\n");
        reporte.append("----------------------------\n");
        reporte.append("Gracias por usar nuestros servicios.");

        return reporte.toString();
    }
}
