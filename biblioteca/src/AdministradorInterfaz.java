import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;


public class AdministradorInterfaz{
    private Administrador admin;

public static void main(String[] args) {
    new AdministradorInterfaz();
}

public AdministradorInterfaz(){
llenardatos();
}

public void llenardatos() {
    // Crear el JFrame
    JFrame frame = new JFrame("Registro");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(850, 600);
    frame.setLocationRelativeTo(null);

    

    // Crear panel2 (panel naranja)
    JPanel panel2 = Plantilla.crearPanelNaranja();
  
   

    // Crear el panel azul (panel3)
    JPanel panel3 = Plantilla.crearPanelAzul();

    // Crear el título
    JLabel lblTitulo = new JLabel("REGISTRO ADIMISTRADOR");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 32));
    lblTitulo.setBounds(280, 30, 430, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); // Colocar el título en panel2

    panel3.setLayout(null);
    panel2.setLayout(null);

    //imagen
    ImageIcon imagenIcono = new ImageIcon( "biblioteca/imagenes/biblio2.jpg" ); 
        Image imagen = imagenIcono.getImage();

        imagen = imagen.getScaledInstance(425, 500, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada = new ImageIcon(imagen);
        JLabel etiquetaImagen = new JLabel(imagenRedimensionada);
        etiquetaImagen.setBounds(425, 0, 425, 500); 
        panel3.add(etiquetaImagen);



    // Crear un panel para los campos de entrada
    JPanel panel = Plantilla.crearPanelBlanco(400, 400);
    panel.setBounds(30, 30, 350, 330);
    panel.setLayout(null);

    // Crear etiquetas y campos de texto
    JLabel jlNombre = new JLabel("Nombres:");
    CurvearTextArea txtNombre = Plantilla.crearTextArea();
    jlNombre.setFont(new Font("Arial", Font.BOLD, 18));
    jlNombre.setForeground(PaletaColor.COLORCELESTE);
    jlNombre.setBounds(30, 20, 100, 30);

    txtNombre.setBounds(140, 20, txtNombre.getPreferredSize().width, txtNombre.getPreferredSize().height);


    JLabel lblApellido = new JLabel("Apellidos:");
    CurvearTextArea txtApellido = Plantilla.crearTextArea();
    lblApellido.setFont(new Font("Arial", Font.BOLD, 18));
    lblApellido.setForeground(PaletaColor.COLORCELESTE);
    lblApellido.setBounds(30, 70, 100, 30);

    txtApellido.setBounds(140, 70, txtApellido.getPreferredSize().width, txtApellido.getPreferredSize().height);



    JLabel lblTelefono = new JLabel("Telefono:");
    CurvearTextArea txtTelefono = Plantilla.crearTextArea();

    lblTelefono.setFont(new Font("Arial", Font.BOLD, 18));
    lblTelefono.setForeground(PaletaColor.COLORCELESTE);
    lblTelefono.setBounds(30, 120, 100, 30);

    txtTelefono.setBounds(140, 120, txtTelefono.getPreferredSize().width, txtTelefono.getPreferredSize().height);


    JLabel lblci = new JLabel("CI:");
    CurvearTextArea txtCi = Plantilla.crearTextArea();
    lblci.setFont(new Font("Arial", Font.BOLD, 18));
    lblci.setForeground(PaletaColor.COLORCELESTE);
    lblci.setBounds(30, 170, 100, 30);

    txtCi.setBounds(140, 170, txtCi.getPreferredSize().width, txtCi.getPreferredSize().height);


    JLabel lblcorreo = new JLabel("Correo:");
    CurvearTextArea txtCorreo = Plantilla.crearTextArea();
    lblcorreo.setFont(new Font("Arial", Font.BOLD, 18));
    lblcorreo.setForeground(PaletaColor.COLORCELESTE);
    lblcorreo.setBounds(30, 220, 100, 30);

    txtCorreo.setBounds(140, 220, txtCorreo.getPreferredSize().width, txtCorreo.getPreferredSize().height);


    JLabel lblcontrasena = new JLabel("Password:");
    CurvearTextArea txtContrasena = Plantilla.crearTextArea();
    lblcontrasena.setFont(new Font("Arial", Font.BOLD, 18));
    lblcontrasena.setForeground(PaletaColor.COLORCELESTE);
    lblcontrasena.setBounds(30, 270, 150, 30);

    txtContrasena.setBounds(140, 270, txtContrasena.getPreferredSize().width, txtContrasena.getPreferredSize().height);







    // Agregar etiquetas y campos de texto al panel
    panel.add(jlNombre);
    panel.add(txtNombre);
    panel.add(lblApellido);
    panel.add(txtApellido);
    panel.add(lblTelefono);
    panel.add(txtTelefono);
    panel.add (lblci);
    panel.add(txtCi);
    panel.add(lblcorreo);
    panel.add(txtCorreo);
    panel.add(lblcontrasena);
    panel.add(txtContrasena);


    // Agregar el panel de entrada al panel3
    panel3.add(panel);

    // Agregar panel3 al panel2
    panel2.add(panel3);

    // Agregar panel2 al JFrame
    frame.add(panel2);

    // Botón para registrar

    

    JButton btnRegistrar = Plantilla.crearBoton("Registrar");

    /* 
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
    });  */

    // Agregar el botón en la parte inferior
   
   btnRegistrar.setBounds(140, 380,btnRegistrar.getPreferredSize().width, btnRegistrar.getPreferredSize().height);

   panel3.add(btnRegistrar);


    frame.revalidate();
    frame.repaint();

    // Mostrar la ventana
    frame.setVisible(true);
} }

/* 
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





}   */