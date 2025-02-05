import javax.swing.*;
import Frontend.Plantilla;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LibroSelector extends JPanel {
    private JList<String> listaLibros;
    private JButton botonSeleccionar;
    private String[] libro;

    public LibroSelector() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 350));

        // Obtener la lista de libros desde la base de datos
        String[] libros = obtenerListaLibros();

        // Crear un modelo de lista con los libros
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (String libro : libros) {
            modeloLista.addElement(libro);
        }

        // Crear lista de libros con scroll
        listaLibros = new JList<>(modeloLista);
        listaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listaLibros);

        // Crear el botón de seleccionar
        botonSeleccionar = Plantilla.crearBoton("Prestarse");
        botonSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String libroSeleccionado = listaLibros.getSelectedValue();
                if (libroSeleccionado != null) {
                    libro = libroSeleccionado.split("\\s*-\\s*");

                    Administrador usuario = SesionUsuario.getAdminActual();
                    if (usuario != null) {
                        // Si el usuario es administrador, pedir el SIS del alumno
                        String sisAlumno = JOptionPane.showInputDialog("Ingrese el SIS del alumno:");

                        if (sisAlumno != null && !sisAlumno.trim().isEmpty()) {
                            if (verificarUsuarioEnBD(sisAlumno)) {
                                new Prestamo(libro[0], libro[1]);
                            } else {
                                JOptionPane.showMessageDialog(null, "El usuario con SIS " + sisAlumno + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        // Si no es administrador, se procede normalmente
                        new Prestamo(libro[0], libro[1]);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un libro.");
                }
            }
        });

        // Agregar los componentes al panel
        add(scrollPane, BorderLayout.CENTER);
        add(botonSeleccionar, BorderLayout.SOUTH);
    }

    // Método para obtener la lista de libros desde la base de datos
    public String[] obtenerListaLibros() {
        try {
            Connection conexion = ConexionBD.getConexion();
            PreparedStatement stmt = conexion.prepareStatement("SELECT nombre, autor FROM libro");
            ResultSet rs = stmt.executeQuery();
            java.util.List<String> libros = new java.util.ArrayList<>();
            while (rs.next()) {
                // Combinar nombre del libro y autor en una sola cadena
                String libroConAutor = rs.getString("nombre") + " - " + rs.getString("autor");
                libros.add(libroConAutor);
            }
            return libros.toArray(new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    // Método para verificar si el usuario con SIS existe en la base de datos
    private boolean verificarUsuarioEnBD(String sis) {
        try {
            Connection conexion = ConexionBD.getConexion();
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM usuario WHERE sis = ?");
            stmt.setString(1, sis);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String cor = rs.getString("correo");
                int ci = rs.getInt("ci");
                int sis1 = rs.getInt("sis");
                int telefono=rs.getInt("telefono");
                String tipoUsuario = rs.getString("tipo_usuario");
                usuario usuario=new usuario(nombre,apellido,cor,ci,sis1,telefono,tipoUsuario);
                SesionUsuario.iniciarSesion(usuario);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
