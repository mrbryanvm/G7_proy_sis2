import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;


public class registro_Administradores{
    private Administrador admin;

public static void main(String[] args) {
    new registro_Administradores();
}

public registro_Administradores(){
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

    JLabel lblTelefono = new JLabel("Telefono:");
    CurvearTextArea txtTelefono = plantilla.crearTextArea();


    // Agregar etiquetas y campos de texto al panel
    panel.add(jlNombre);
    panel.add(txtNombre);
    panel.add(lblApellido);
    panel.add(txtApellido);
    panel.add(lblTelefono);
    panel.add(txtTelefono);


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
                int telefono = Integer.parseInt(txtTelefono.getText());


                // Crear un objeto estudiante (usuario)
                admin = new Administrador(nombre, apellido,telefono);
                String contra=admin.GenerarContrasena();
                admin.setContrasena(contra);
                boolean registroExitoso = BD();

                if (registroExitoso) {
                    // Limpiar los campos después del registro
                    txtNombre.setText("");
                    txtApellido.setText("");
                    
                    txtTelefono.setText("");
    
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


public boolean BD(){

 try {
            Connection conexion = ConexionBD.getConexion(); // Obtén la conexión
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "La conexión a la base de datos no se pudo procesar. Intente nuevamente más tarde.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
                return false; // Termina el método si no hay conexión
            }
            String query = "INSERT INTO administrador (nombre,apellido,telefono,contrasena) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, est.getNombre());
            stmt.setString(2, est.getApellido());
            stmt.setString(3, est.getCorreo());
            stmt.setInt(4, est.getCi());
            stmt.setInt(5, est.getSis());
            stmt.setInt(6, est.getTelefono());
            stmt.setString(7, est.getTipo_usuario());

            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

}





}   