import javax.swing.*;

import Frontend.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }

    public Login() {
        mostrarLogin();
    }

    public void mostrarLogin() {
        // Crear el JFrame
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(470, 360);
        frame.setLocationRelativeTo(null);
        // Crear la plantilla 
        Plantilla plantilla = new Plantilla();
         // Crear panel2 (panel naranja)
         JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200)); 
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER)); 

         // Crear el panel azul (panel3)
         JPanel panel3 = plantilla.crearPanelAzul();
  


        // Crear el panel de entrada
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setPreferredSize(new Dimension(245, 180));
        panel.setBackground(PaletaColor.COLORBLANCO);   

        // Crear etiquetas y campos de texto
        JLabel lblNombre = new JLabel("Nombre:");
        CurvearTextArea txtNombre = plantilla.crearTextArea();

        JLabel lblApellido = new JLabel("Apellido:");
        CurvearTextArea txtApellido = plantilla.crearTextArea();

        JLabel lblSis = new JLabel("SIS:");
        JPasswordField txtSis = new JPasswordField(); 

        // Agregar etiquetas y campos al panel
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblApellido);
        panel.add(txtApellido);
        panel.add(lblSis);
        panel.add(txtSis);

         // Agregar el panel de entrada al panel3
         panel3.add(panel, BorderLayout.CENTER);
         // Agregar panel3 al panel2
         panel2.add(panel3, BorderLayout.CENTER);
         // Agregar panel2 al JFrame
         frame.add(panel2, BorderLayout.CENTER);

        // Botón de inicio de sesión
        
        JButton btnIniciarSesion = plantilla.crearBoton("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String sis = new String(txtSis.getPassword()); // Convertir la contraseña del SIS

                if (nombre.isEmpty() || apellido.isEmpty() || sis.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingrese todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificar las credenciales con la base de datos
                boolean loginExitoso = verificarLogin(nombre, apellido, sis);
                if (loginExitoso) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.");
                    frame.dispose();  

                    //Colocar el siguinete metodo
                } else {
                    JOptionPane.showMessageDialog(frame, "Nombre, Apellido o SIS incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel3.add(btnIniciarSesion);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    public boolean verificarLogin(String nombre, String apellido, String sis) {
        try {
            Connection conexion = ConexionBD.getConexion(); 
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "La conexión a la base de datos no se pudo procesar. Intente nuevamente más tarde.", "Error de conexión", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            // Consulta para verificar el nombre, apellido y el SIS en la base de datos
            String query = "SELECT * FROM usuario WHERE nombre = ? AND apellido = ? AND sis = ?";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, sis);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Si se encuentran los datos en la base de datos, el login es exitoso
                return true;
            }
            return false; // Si no se encuentran los datos
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
