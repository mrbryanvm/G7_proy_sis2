import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;

public class RegistroLibro {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new RegistroLibro());
    }

    public RegistroLibro() {
        llenardatos();
    }

    public void llenardatos() {
        JFrame frame = new JFrame("Registro de Libros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = plantilla.crearPanelAzul();

        JLabel lblTitulo = new JLabel("Registro de Libros", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panel2.add(lblTitulo);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre del libro:");
        CurvearTextArea txtNombre = plantilla.crearTextArea();

        JLabel lblAutor = new JLabel("Autor:");
        CurvearTextArea txtAutor = plantilla.crearTextArea();

        JLabel lblEditorial = new JLabel("Editorial:");
        CurvearTextArea txtEditorial = plantilla.crearTextArea();

        JLabel lblAnio = new JLabel("Año de publicación:");
        CurvearTextArea txtAnio = plantilla.crearTextArea();

        JLabel lblIsbn = new JLabel("ISBN:");
        CurvearTextArea txtIsbn = plantilla.crearTextArea();

        JLabel lblDisponible = new JLabel("Disponible:");
        JCheckBox chkDisponible = new JCheckBox("Sí", true);

        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblEditorial);
        panel.add(txtEditorial);
        panel.add(lblAnio);
        panel.add(txtAnio);
        panel.add(lblIsbn);
        panel.add(txtIsbn);
        panel.add(lblDisponible);
        panel.add(chkDisponible);

        panel3.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);

        JButton btnRegistrar = plantilla.crearBoton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String autor = txtAutor.getText();
                    String editorial = txtEditorial.getText();
                    int anio = Integer.parseInt(txtAnio.getText());
                    String isbn = txtIsbn.getText();
                    boolean disponible = chkDisponible.isSelected();

                    boolean registroExitoso = registrarLibro(nombre, autor, editorial, anio, isbn, disponible);
                    if (registroExitoso) {
                        txtNombre.setText("");
                        txtAutor.setText("");
                        txtEditorial.setText("");
                        txtAnio.setText("");
                        txtIsbn.setText("");
                        chkDisponible.setSelected(true);
                        JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "No se pudo registrar el libro. Intenta nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Asegúrate de ingresar todos los datos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel3.add(btnRegistrar, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }




    public boolean registrarLibro(String nombre, String autor, String editorial, int anio, String isbn, boolean disponible) {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String query = "INSERT INTO libro (nombre, autor, editorial, anio, isbn, disponible) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, autor);
            stmt.setString(3, editorial);
            stmt.setInt(4, anio);
            stmt.setString(5, isbn);
            stmt.setBoolean(6, disponible);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}