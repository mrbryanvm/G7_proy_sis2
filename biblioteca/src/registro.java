import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;



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
    JFrame frame = new JFrame("Registro");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLayout(new BorderLayout(10, 10)); // Usar BorderLayout para organizar los componentes
    frame.setLocationRelativeTo(null);

    // Crear el título
    JLabel lblTitulo = new JLabel("Registro de Estudiantes", JLabel.CENTER);
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
    frame.add(lblTitulo, BorderLayout.NORTH); // Colocar el título en la parte superior

    // Crear un panel para los campos de entrada
    JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); // 6 filas, 2 columnas con espaciado

    // Crear etiquetas y campos de texto
    JLabel jlNombre = new JLabel("Nombres:");
    JTextField txtNombre = new JTextField();

    JLabel lblApellido = new JLabel("Apellidos:");
    JTextField txtApellido = new JTextField();

    JLabel lblcorreo = new JLabel("Correo:");
    JTextField txtCorreo = new JTextField();

    JLabel lblci = new JLabel("CI:");
    JTextField txtCi = new JTextField();

    JLabel lblSis = new JLabel("SIS:");
    JTextField txtSis = new JTextField();

    JLabel lblTelefono = new JLabel("Telefono:");
    JTextField txtTelefono = new JTextField();

    //Tipo dde usuario
    JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
    String[] tipos = {"Selecciona el tipo de usurio --","Estudiante", "Maestro"};
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

    // Agregar el panel al centro del BorderLayout
    frame.add(panel, BorderLayout.CENTER);

    // Botón para registrar
    JButton btnRegistrar = new JButton("Registrar");
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
                if(tipoUsuario.equals("Selecciona el tipo de usurio --")){
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona un tipo de usuario", "Error", JOptionPane.ERROR_MESSAGE);
                    return ;}
                // Crear un objeto estudiante
                est = new usuario(nombre, apellido, correo, ci, sis, telefono,tipoUsuario);
                BD(); // Llamar a tu método BD()

                // Limpiar los campos después del registro
                txtNombre.setText("");
                txtApellido.setText("");
                txtCorreo.setText("");
                txtCi.setText("");
                txtSis.setText("");
                txtTelefono.setText("");
                comboTipoUsuario.setSelectedIndex(0); 

                JOptionPane.showMessageDialog(frame, "Registro exitoso.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Error: Asegúrate de ingresar números válidos en los campos CI, SIS y Teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    // Agregar el botón en la parte inferior
    frame.add(btnRegistrar, BorderLayout.SOUTH);

    // Mostrar la ventana
    frame.setVisible(true);
}


public void BD(){

 try {
            Connection conexion = ConexionBD.getConexion(); // Obtén la conexión
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
        } catch (Exception e) {
            e.printStackTrace();
        }

}



}
