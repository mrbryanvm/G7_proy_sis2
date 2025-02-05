import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;

public class registro_Administradores {
    private Administrador admin;
    private String contra;

    public static void main(String[] args) {
        new registro_Administradores();
    }

    public registro_Administradores() {
        llenardatos();
    }

    public void llenardatos() {
        JFrame frame = new JFrame("Registro");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(750, 500);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = plantilla.crearPanelAzul();
        JLabel lblTitulo = new JLabel("Registro de Administradores", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panel2.add(lblTitulo);

        JPanel panel = new JPanel(new GridLayout(10, 2, 10, 10));
        panel.setPreferredSize(new Dimension(400, 400));

        JLabel jlNombre = new JLabel("Nombres:");
        CurvearTextArea txtNombre = plantilla.crearTextArea();
        JLabel lblApellido = new JLabel("Apellidos:");
        CurvearTextArea txtApellido = plantilla.crearTextArea();
        JLabel lblCi = new JLabel("C.I:");
        CurvearTextArea txtCi = plantilla.crearTextArea();
        JLabel lblTelefono = new JLabel("Telefono:");
        CurvearTextArea txtTelefono = plantilla.crearTextArea();
        JLabel lblCorreo = new JLabel("Correo:");
        CurvearTextArea txtCorreo = plantilla.crearTextArea();
        JLabel lblDireccion = new JLabel("Dirección:");
        CurvearTextArea txtDireccion = plantilla.crearTextArea();
        JLabel lblContrasena =new JLabel("<html>Contrasena asignada<br>por el Sistema (No se olvide)</html>");
        contra=generarContrasena();
        JLabel contrasenalbl =new JLabel(contra);

        panel.add(jlNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblCi);
        panel.add(txtCi);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(lblCorreo);
        panel.add(txtCorreo);
        panel.add(lblDireccion);
        panel.add(txtDireccion);
        panel.add(lblContrasena);
        panel.add(contrasenalbl);

        panel3.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);

        JButton btnRegistrar = plantilla.crearBoton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    int ci = Integer.parseInt(txtCi.getText());
                    int telefono = Integer.parseInt(txtTelefono.getText());
                    String correo = txtCorreo.getText();
                    String direccion = txtDireccion.getText();

                    admin = new Administrador(nombre, apellido, ci, telefono, correo, direccion);
                    admin.setContrasena(contra);
                    boolean registroExitoso = BD();

                    if (registroExitoso) {
                        txtNombre.setText("");
                        txtApellido.setText("");
                        txtCi.setText("");
                        txtTelefono.setText("");
                        txtCorreo.setText("");
                        txtDireccion.setText("");
                        JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "No se pudo completar el registro. Intenta nuevamente más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
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

   public boolean BD() {
    try {
        Connection conexion = ConexionBD.getConexion();
        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos. Intente más tarde.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String query = "INSERT INTO administrador (nombre, apellido, contrasena, ci, telefono, correo, direccion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(query);
        
        stmt.setString(1, admin.getNombre());
        stmt.setString(2, admin.getApellido());
        stmt.setString(3, admin.getContrasena());
        stmt.setInt(4, admin.getCi());
        stmt.setInt(5, admin.getTelefono());
        stmt.setString(6, admin.getCorreo());
        stmt.setString(7, admin.getDireccion());

        stmt.executeUpdate();
        stmt.close();
        return true;
    } catch (SQLIntegrityConstraintViolationException e) {
        JOptionPane.showMessageDialog(null, "Ya existe un registro con los mismos datos. Intente con valores diferentes.", "Error de duplicado", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error con la base de datos. Intente de nuevo.", "Error SQL", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Algo salió mal. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
}

    


    public String generarContrasena() {
        int i = (int) (Math.random() * 9000000) + 1000000;
        return "umss_" + i;
    }
}
