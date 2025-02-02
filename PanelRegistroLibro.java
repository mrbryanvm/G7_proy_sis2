import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistroLibro extends JPanel {
    private JTextField txtIsbn, txtTitulo, txtAutor, txtEditorial, txtAnio;
    private Biblioteca biblioteca;

    public PanelRegistroLibro(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        inicializarUI();
    }

    private void inicializarUI() {
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("ISBN:"));
        txtIsbn = new JTextField();
        add(txtIsbn);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel("Editorial:"));
        txtEditorial = new JTextField();
        add(txtEditorial);

        add(new JLabel("Año de Publicación:"));
        txtAnio = new JTextField();
        add(txtAnio);

        JButton btnRegistrar = new JButton("Registrar Libro");
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarLibro();
            }
        });
    }

    private void registrarLibro() {
        try {
            String isbn = txtIsbn.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String editorial = txtEditorial.getText();
            int anio = Integer.parseInt(txtAnio.getText());

            Libro nuevoLibro = new Libro(isbn, titulo, autor, editorial, anio);
            biblioteca.agregarLibro(nuevoLibro);

            JOptionPane.showMessageDialog(this, "Libro registrado con éxito:\n" + nuevoLibro);
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El año debe ser un número válido.");
        }
    }

    private void limpiarCampos() {
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtAnio.setText("");
    }
}
