import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;



public class newregistro extends JFrame{
   
    public usuario est;
   // public transient JFrame panel =new JFrame();


public static void main(String[] args){
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new newregistro();
        }
    });
}

public newregistro(){
llenardatos();
}









public void llenardatos() {
    // Crear el JFrame
    JFrame frame = new JFrame("Registro");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(850, 600);
    frame.setLocationRelativeTo(null);

    // Crear la plantilla 
    

    // Crear panel2 (panel naranja)
    JPanel panel2 = Plantilla.crearPanelNaranja();
    panel2.setLayout(null); 

    // Crear el panel azul (panel3)
    JPanel panel3 = Plantilla.crearPanelAzul();
    panel3.setLayout(null);

    // Crear el título
    JLabel lblTitulo = new JLabel("REGISTRE SU CUENTA");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 31));
    lblTitulo.setBounds(300, 25, 400, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); // Colocar el título en panel2

    // Crear un panel para los campos de entrada
    JPanel panel = Plantilla.crearPanelBlanco(400, 300);
    panel.setBounds(40, 60, 350, 270);
    panel.setLayout(null);


    
    JPanel panel4 = Plantilla.crearPanelBlanco(400, 300);
    panel4.setBounds(440, 60, 350, 150);
    panel4.setLayout(null);
    panel3.add(panel4);


    // Crear etiquetas y campos de texto
    JLabel jlNombre = new JLabel("Nombres:");
    CurvearTextArea txtNombre = Plantilla.crearTextArea();
    jlNombre.setFont(new Font("Arial", Font.BOLD, 18));
    jlNombre.setForeground(PaletaColor.COLORCELESTE);
    jlNombre.setBounds(40, 20, 100, 30);

    txtNombre.setBounds(140, 20, txtNombre.getPreferredSize().width, txtNombre.getPreferredSize().height);



    JLabel lblApellido = new JLabel("Apellidos:");
    CurvearTextArea txtApellido = Plantilla.crearTextArea();
    lblApellido.setFont(new Font("Arial", Font.BOLD, 18));
    lblApellido.setForeground(PaletaColor.COLORCELESTE);
    lblApellido.setBounds(40, 80, 100, 30);

    txtApellido.setBounds(140, 80, txtApellido.getPreferredSize().width, txtApellido.getPreferredSize().height);


    JLabel lblcorreo = new JLabel("Correo:");
    CurvearTextArea txtCorreo = Plantilla.crearTextArea();
    lblcorreo.setFont(new Font("Arial", Font.BOLD, 18));
    lblcorreo.setForeground(PaletaColor.COLORCELESTE);
    lblcorreo.setBounds(40, 140, 100, 30);

    txtCorreo.setBounds(140, 140, txtCorreo.getPreferredSize().width, txtCorreo.getPreferredSize().height);



    JLabel lblci = new JLabel("CI:");
    CurvearTextArea txtCi = Plantilla.crearTextArea();
    lblci.setFont(new Font("Arial", Font.BOLD, 18));
    lblci.setForeground(PaletaColor.COLORCELESTE);
    lblci.setBounds(40, 200, 100, 30);

    txtCi.setBounds(140, 200, txtCi.getPreferredSize().width, txtCi.getPreferredSize().height);



    JLabel lblSis = new JLabel("SIS:");
    CurvearTextArea txtSis = Plantilla.crearTextArea();
    lblSis.setFont(new Font("Arial", Font.BOLD, 18));
    lblSis.setForeground(PaletaColor.COLORCELESTE);
    lblSis.setBounds(40, 20, 100, 30);

    txtSis.setBounds(140, 20, txtSis.getPreferredSize().width, txtSis.getPreferredSize().height);


    JLabel lblTelefono = new JLabel("Telefono:");
    CurvearTextArea txtTelefono = Plantilla.crearTextArea();
    lblTelefono.setFont(new Font("Arial", Font.BOLD, 18));
    lblTelefono.setForeground(PaletaColor.COLORCELESTE);
    lblTelefono.setBounds(40, 80, 100, 30);

    txtTelefono.setBounds(140, 80, txtTelefono.getPreferredSize().width, txtTelefono.getPreferredSize().height);


    // Tipo de usuario
    JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
    lblTipoUsuario.setFont(new Font("Arial", Font.BOLD, 18));
    lblTipoUsuario.setForeground(PaletaColor.COLORBLANCO);
    lblTipoUsuario.setBounds(530, 220, 180, 30);

    
    String[] tipos = {"Selecciona el tipo de usuario ", "Estudiante", "Maestro"};
    
    

    JComboBox<String> comboTipoUsuario = new JComboBox<>(tipos);
    comboTipoUsuario.setBounds(515, 260, 200, 50);

    // Agregar etiquetas y campos de texto al panel
    panel.add(jlNombre);
    panel.add(txtNombre);
    panel.add(lblApellido);
    panel.add(txtApellido);
    panel.add(lblcorreo);
    panel.add(txtCorreo);
    panel.add(lblci);
    panel.add(txtCi);
    panel4.add(lblSis);
    panel4.add(txtSis);
    panel4.add(lblTelefono);
    panel4.add(txtTelefono);
    panel3.add(lblTipoUsuario);
    panel3.add(comboTipoUsuario);

    // Agregar el panel de entrada al panel3
    panel3.add(panel);

    // Agregar panel3 al panel2
    panel2.add(panel3);

    // Agregar panel2 al JFrame
    frame.add(panel2);

    // Botón para registrar
    JButton btnRegistrar = Plantilla.crearBoton("Registrar");
    panel3.add(btnRegistrar);
    btnRegistrar.setBounds(333, 375, btnRegistrar.getPreferredSize().width, btnRegistrar.getPreferredSize().height);


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
            String query = "INSERT INTO usuario (nombre,apellido,correo,ci,sis,telefono,tipo_usuario) VALUES (?, ?, ?, ?, ?, ? ,?)";
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
