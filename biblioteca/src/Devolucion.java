import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import Frontend.CurvearTextArea;
import Frontend.Plantilla;

public class Devolucion {
    private String nombre_libro;
    private String autor;
    Date fechaActual = getFechaActual();
    usuario usuario = SesionUsuario.getUsuarioActual();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Devolucion("", ""));
    }

    public Devolucion(String nombre, String autor) {
        this.nombre_libro = nombre;
        this.autor = autor;
        mostrarFormulario();
    }

    private void mostrarFormulario() {
        JFrame frame = new JFrame("Registro de Devoluciones");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = plantilla.crearPanelAzul();

        JLabel lblTitulo = new JLabel("Registro de Devoluciones", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panel2.add(lblTitulo);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel lblUsuario = new JLabel("Nombre del usuario: ");
        JLabel txtUsuario = new JLabel(usuario.getTipo_usuario() + " " + usuario.getNombre() + " " + usuario.getApellido());

        JLabel lblFechaDevolucion = new JLabel("Fecha de devolución (YYYY-MM-DD):");
        JLabel lblFechaDevolucionValor = new JLabel(getFechaActual().toString());

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblFechaDevolucion);
        panel.add(lblFechaDevolucionValor);

        panel3.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);

        JButton btnRegistrar = plantilla.crearBoton("Registrar Devolución");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (verificarPrestamo()) {
                        boolean exito = registrarDevolucion();
                        if (exito) {
                            JOptionPane.showMessageDialog(frame, "Devolución registrada exitosamente.");
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(frame, "No se pudo registrar la devolución.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "No hay préstamo registrado para este libro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Algo salió mal en el registro, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel3.add(btnRegistrar, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    private Date getFechaActual() {
        return new Date(System.currentTimeMillis());
    }

    public boolean registrarDevolucion() {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String deleteQuery = "DELETE FROM prestamo WHERE usuario_sis = ? ";
            PreparedStatement deleteStmt = conexion.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, usuario.getSis());
            int filasAfectadas = deleteStmt.executeUpdate();

            if (filasAfectadas > 0) {
                String updateQuery = "UPDATE libro SET cantidad_disponible = cantidad_disponible + 1 WHERE nombre = ? AND autor = ?";
                PreparedStatement updateStmt = conexion.prepareStatement(updateQuery);
                updateStmt.setString(1, nombre_libro);
                updateStmt.setString(2, autor);
                updateStmt.executeUpdate();


                String insertQuery = "INSERT INTO devolucion (fecha_devuelto, nombre_libro, autor, usuario_sis, tipo_usuario) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStmt = conexion.prepareStatement(insertQuery);
                insertStmt.setDate(1, fechaActual);
                insertStmt.setString(2, nombre_libro);
                insertStmt.setString(3, autor);
                insertStmt.setInt(4, usuario.getSis());
                insertStmt.setString(5, usuario.getTipo_usuario());
                insertStmt.executeUpdate();
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarPrestamo() {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            String selectQuery = "SELECT * FROM prestamo WHERE usuario_sis = ? AND nombre_libro = ? AND autor = ?";
            PreparedStatement stmt = conexion.prepareStatement(selectQuery);
            stmt.setInt(1, usuario.getSis());
            stmt.setString(2, nombre_libro);
            stmt.setString(3, autor);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
