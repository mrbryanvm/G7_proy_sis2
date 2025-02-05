import javax.swing.*;

import com.mysql.cj.xdevapi.AddResultBuilder;

import Frontend.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private usuario usuario ;
    private Administrador administrador;
    private String tipo;
    private LoginSuccessListener loginSuccessListener;

   

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

        JLabel lblSis = new JLabel("SIS o Contrasena:");
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

                    if (loginSuccessListener != null) {
                        loginSuccessListener.onLoginSuccess(); // Notificar a Home
                    }
                    if(tipo=="administrador"){
                    SesionUsuario.iniciarSesion(administrador);
                    new PerfilAdministrador();}
                    else{
                        SesionUsuario.iniciarSesion(usuario);
                        new Perfil();
                    }
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

        // Primero, busca en la tabla de usuario por nombre, apellido y sis
        String query = "SELECT * FROM usuario WHERE nombre = ? AND apellido = ? AND sis = ?";
        PreparedStatement stmt = conexion.prepareStatement(query);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, sis);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Si se encuentra el usuario en la base de datos
            String nom = rs.getString("nombre");
            String ape = rs.getString("apellido");
            String cor = rs.getString("correo");
            int ci = rs.getInt("ci");
            int si = rs.getInt("sis");
            int tel = rs.getInt("telefono");
            String tu = rs.getString("tipo_usuario");

            usuario = new usuario(nom, ape, cor, ci, si, tel, tu);
            tipo = tu; // Guardamos el tipo de usuario (si es "usuario")
            return true;
        } else {
            // Si no se encuentra en la tabla de usuario, busca en la tabla de administrador
            String query1 = "SELECT * FROM administrador WHERE nombre = ? AND apellido = ? AND contrasena = ?";
            PreparedStatement stmt1 = conexion.prepareStatement(query1);
            stmt1.setString(1, nombre);
            stmt1.setString(2, apellido);
            stmt1.setString(3, sis);  // Aquí se usa el 'sis' como la contrasena para el administrador.
            ResultSet rs1 = stmt1.executeQuery();

            if (rs1.next()) {
                String nom = rs1.getString("nombre");
                String ape = rs1.getString("apellido");
               // String cor = rs1.getString("contrasena");
                int ci = rs1.getInt("ci");  
                int tel = rs1.getInt("telefono");
                String co = rs1.getString("correo");
                String di = rs1.getString("direccion");
    
                administrador = new Administrador(nom, ape,ci, tel, co,di);
                tipo = "administrador";  // Si se encuentra en la tabla administrador, asignamos "administrador"
                return true;
            }
        }
        return false; // Si no se encuentran los datos en ninguna tabla
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error con la base de datos. Intente nuevamente.", "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        return false;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error desconocido. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
}


    public interface LoginSuccessListener {
        void onLoginSuccess();
    }

    public void addLoginSuccessListener(LoginSuccessListener listener) {
        this.loginSuccessListener = listener;
    }
}
