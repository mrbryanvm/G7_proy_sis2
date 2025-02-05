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



public class registro {
   
    public usuario est;
   // public transient JFrame panel =new JFrame();


public static void main(String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new registro();
        }
    });
}

public registro(){
llenardatos();
}









public void llenardatos() {
    // Crear el JFrame
    JFrame frame = new JFrame("Registro");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(650, 500);
    frame.setLocationRelativeTo(null);

    // Crear la plantilla 
    Plantilla plantilla = new Plantilla();

    // Crear panel2 (panel naranja)
    JPanel panel2 = plantilla.crearPanelNaranja();
    panel2.setPreferredSize(new Dimension(400, 200)); 
    panel2.setLayout(new FlowLayout(FlowLayout.CENTER)); 

    // Crear el panel azul (panel3)
    JPanel panel3 = plantilla.crearPanelAzul();

    // Crear el título
    JLabel lblTitulo = new JLabel("Registro de Estudiantes", JLabel.CENTER);
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
    panel2.add(lblTitulo); // Colocar el título en panel2

    // Crear un panel para los campos de entrada
    JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); // 7 filas, 2 columnas con espaciado

    // Crear etiquetas y campos de texto
    JLabel jlNombre = new JLabel("Nombres:");
    CurvearTextArea txtNombre = plantilla.crearTextArea();

    JLabel lblApellido = new JLabel("Apellidos:");
    CurvearTextArea txtApellido = plantilla.crearTextArea();

    JLabel lblcorreo = new JLabel("Correo:");
    CurvearTextArea txtCorreo = plantilla.crearTextArea();

    JLabel lblci = new JLabel("CI:");
    CurvearTextArea txtCi = plantilla.crearTextArea();

    JLabel lblSis = new JLabel("SIS:");
    CurvearTextArea txtSis = plantilla.crearTextArea();

    JLabel lblTelefono = new JLabel("Telefono:");
    CurvearTextArea txtTelefono = plantilla.crearTextArea();

    // Tipo de usuario
    JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
    String[] tipos = {"Selecciona el tipo de usuario --", "Estudiante", "Maestro"};
    JComboBox<String> comboTipoUsuario = new JComboBox<>(tipos);

    // Agregar etiquetas y campos de texto al panel
    panel.add(jlNombre);
    panel.add(txtNombre);
    panel.add(lblApellido);
    panel.add(txtApellido);
    panel.add(lblcorreo);
    panel.add(txtCorreo);
    panel.add(lblci);
    panel.add(txtCi);
    panel.add(lblSis);
    panel.add(txtSis);
    panel.add(lblTelefono);
    panel.add(txtTelefono);
    panel.add(lblTipoUsuario);
    panel.add(comboTipoUsuario);

    // Agregar el panel de entrada al panel3
    panel3.add(panel, BorderLayout.CENTER);

    // Agregar panel3 al panel2
    panel2.add(panel3, BorderLayout.CENTER);

    // Agregar panel2 al JFrame
    frame.add(panel2, BorderLayout.CENTER);

    // Botón para registrar
    JButton btnRegistrar = plantilla.crearBoton("Registrar");
    btnRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Obtener los datos de los campos de texto
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String correo = txtCorreo.getText();
                int ci = Integer.parseInt(txtCi.getText());
                int sis = Integer.parseInt(txtSis.getText());
                int telefono = Integer.parseInt(txtTelefono.getText());
                String tipoUsuario = comboTipoUsuario.getSelectedItem().toString();

                if (tipoUsuario.equals("Selecciona el tipo de usuario --")) {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona un tipo de usuario", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Crear un objeto estudiante (usuario)
                est = new usuario(nombre, apellido, correo, ci, sis, telefono, tipoUsuario);
                boolean registroExitoso = BD();

                if (registroExitoso) {
                    // Limpiar los campos después del registro
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtCorreo.setText("");
                    txtCi.setText("");
                    txtSis.setText("");
                    txtTelefono.setText("");
                    comboTipoUsuario.setSelectedIndex(0);
    
                    JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                    frame.dispose();
                } else {
                    // Si no fue exitoso
                    JOptionPane.showMessageDialog(frame, "No se pudo completar el registro. Intenta nuevamente más tarde.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Asegúrate de ingresar todos los datos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Agregar el botón en la parte inferior
    panel3.add(btnRegistrar, BorderLayout.SOUTH);

    frame.revalidate();
    frame.repaint();

    // Mostrar la ventana
    frame.setVisible(true);
}


public boolean BD() {
    try {
        Connection conexion = ConexionBD.getConexion(); // Obtén la conexión
        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos. Intente más tarde.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            return false; // Termina el método si no hay conexión
        }

        String query = "INSERT INTO usuario (nombre, apellido, correo, ci, sis, telefono, tipo_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(query);
        stmt.setString(1, est.getNombre());
        stmt.setString(2, est.getApellido());
        stmt.setString(3, est.getCorreo());
        stmt.setInt(4, est.getCi());
        stmt.setInt(5, est.getSis());
        stmt.setInt(6, est.getTelefono());
        stmt.setString(7, est.getTipo_usuario());

        stmt.executeUpdate();
        stmt.close();
        return true;
    } catch (SQLIntegrityConstraintViolationException e) {
        JOptionPane.showMessageDialog(null, "Ya existe un usuario con los mismos datos. Intente con valores diferentes.", "Error de duplicado", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Ocurrió un error con la base de datos. Intente de nuevo.", "Error SQL", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Algo salió mal. Intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return false;
}



}
