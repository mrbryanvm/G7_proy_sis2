import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrestamos extends JPanel {
    private Biblioteca biblioteca;
    private JTextField txtIdUsuario, txtIsbnLibro;

    public PanelPrestamos(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        inicializarUI();
    }

    private void inicializarUI() {
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("ID del Usuario:"));
        txtIdUsuario = new JTextField();
        add(txtIdUsuario);

        add(new JLabel("ISBN del Libro:"));
        txtIsbnLibro = new JTextField();
        add(txtIsbnLibro);

        JButton btnPrestar = new JButton("Prestar Libro");
        JButton btnDevolver = new JButton("Devolver Libro");
        add(btnPrestar);
        add(btnDevolver);

        btnPrestar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prestarLibro();
            }
        });

        btnDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                devolverLibro();
            }
        });
    }

    private void prestarLibro() {
        String idUsuario = txtIdUsuario.getText();
        String isbnLibro = txtIsbnLibro.getText();

        Libro libro = biblioteca.buscarLibro(isbnLibro);
        if (libro != null && libro.isDisponible()) {
            Usuario usuario = new Usuario(idUsuario, "Usuario", "correo@ejemplo.com", "Estudiante"); // Simulación
            biblioteca.registrarPrestamo(usuario, libro);
            JOptionPane.showMessageDialog(this, "Libro prestado con éxito.");
        } else {
            JOptionPane.showMessageDialog(this, "El libro no está disponible.");
        }
    }

    private void devolverLibro() {
        String isbnLibro = txtIsbnLibro.getText();
        biblioteca.registrarDevolucion(isbnLibro);
        JOptionPane.showMessageDialog(this, "Devolución procesada.");
    }
}
