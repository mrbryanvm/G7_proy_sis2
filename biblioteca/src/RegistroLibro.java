import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;

public class RegistroLibro {
    public static void main(String[]args){
        java.awt.EventQueue.invokeLater(() -> new RegistroLibro());
    }

    public RegistroLibro() {
        llenardatos();
    }

    public void llenardatos() {
        JFrame frame = new JFrame("Registro de Libros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = plantilla.crearPanelAzul();

        JLabel lblTitulo = new JLabel("Registro de Libros", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panel2.add(lblTitulo);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        JLabel lblNombre = new JLabel("Nombre del libro:");
        CurvearTextArea txtNombre = plantilla.crearTextArea();

        JLabel lblAutor = new JLabel("Autor:");
        CurvearTextArea txtAutor = plantilla.crearTextArea();

        JLabel lblAnio = new JLabel("Año de publicación:");
        CurvearTextArea txtAnio = plantilla.crearTextArea();

        JLabel lblCantidad = new JLabel("Cantidad disponible:");
        CurvearTextArea txtCantidad = plantilla.crearTextArea();

        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblAnio);
        panel.add(txtAnio);
        panel.add(lblCantidad);
        panel.add(txtCantidad);

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
                    int anio = Integer.parseInt(txtAnio.getText());
                    int cantidad = Integer.parseInt(txtCantidad.getText());

                    boolean registroExitoso = registrarLibro(nombre, autor, anio, cantidad);
                    if (registroExitoso) {
                        txtNombre.setText("");
                        txtAutor.setText("");
                        txtAnio.setText("");
                        txtCantidad.setText("");
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

    public boolean registrarLibro(String nombre, String autor, int anio, int cantidad) {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Verificar si el libro ya existe
            String checkQuery = "SELECT cantidad_disponible FROM libro WHERE nombre = ? AND autor = ?";
            PreparedStatement checkStmt = conexion.prepareStatement(checkQuery);
            checkStmt.setString(1, nombre);
            checkStmt.setString(2, autor);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Si ya existe, actualizar cantidad
                int cantidadActual = rs.getInt("cantidad_disponible");
                String updateQuery = "UPDATE libro SET cantidad_disponible = ? WHERE nombre = ? AND autor = ?";
                PreparedStatement updateStmt = conexion.prepareStatement(updateQuery);
                updateStmt.setInt(1, cantidadActual + cantidad);
                updateStmt.setString(2, nombre);
                updateStmt.setString(3, autor);
                updateStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Libro ya registrado. Se actualizó la cantidad.");
            } else {
                // Si no existe, insertarlo
                String insertQuery = "INSERT INTO libro (nombre, autor, anio, cantidad_disponible) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conexion.prepareStatement(insertQuery);
                insertStmt.setString(1, nombre);
                insertStmt.setString(2, autor);
                insertStmt.setInt(3, anio);
                insertStmt.setInt(4, cantidad);
                insertStmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Libro registrado exitosamente.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
