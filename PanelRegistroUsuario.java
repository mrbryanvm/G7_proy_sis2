import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistroUsuario extends JPanel {
    private JTextField txtId, txtNombre, txtCorreo;
    private JComboBox<String> cbTipoUsuario;
    private Biblioteca biblioteca;

    public PanelRegistroUsuario(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        inicializarUI();
    }

    private void inicializarUI() {
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("ID del Usuario:"));
        txtId = new JTextField();
        add(txtId);

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        add(txtCorreo);

        add(new JLabel("Tipo de Usuario:"));
        cbTipoUsuario = new JComboBox<>(new String[]{"Estudiante", "Profesor", "Bibliotecario"});
        add(cbTipoUsuario);

        JButton btnRegistrar = new JButton("Registrar Usuario");
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String tipoUsuario = (String) cbTipoUsuario.getSelectedItem();

        Usuario nuevoUsuario = new Usuario(id, nombre, correo, tipoUsuario);
        JOptionPane.showMessageDialog(this, "Usuario registrado:\n" + nuevoUsuario);
    }
}
