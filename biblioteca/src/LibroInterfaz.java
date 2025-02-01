import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class Libro {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new Libro());
    }

    public Libro() {
        llenardatos();
    }

    public void llenardatos() {
        JFrame frame = new JFrame("Registro de Libros");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(850, 600);
        frame.setLocationRelativeTo(null);

        Plantilla Plantilla = new Plantilla();
        JPanel panel2 = Plantilla.crearPanelNaranja();
        panel2.setLayout(null);

        JPanel panel3 = Plantilla.crearPanelAzul();
        panel3.setLayout(null);

        JLabel lblTitulo = new JLabel("REGISTRE EL LIBRO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 35));
        lblTitulo.setBounds(310, 30, 400, 50);
        lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
        panel2.add(lblTitulo);

        JPanel panel = Plantilla.crearPanelBlanco(400, 260);
        panel.setBounds(37, 80, 400, 260);
        panel.setLayout(null);
 
        JPanel panel4 = Plantilla.crearPanelBlanco(300, 260);
        panel4.setBounds(487, 80, 300, 260);
        panel4.setLayout(null);



        JLabel lblNombre = new JLabel("Nombre del libro:");
        CurvearTextArea txtNombre = Plantilla.crearTextArea();
        lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
    lblNombre.setForeground(PaletaColor.COLORCELESTE);
    lblNombre.setBounds(20, 40, 200, 30);

    txtNombre.setBounds(201, 40, txtNombre.getPreferredSize().width, txtNombre.getPreferredSize().height);


        JLabel lblAutor = new JLabel("Autor:");
        CurvearTextArea txtAutor = Plantilla.crearTextArea();
        lblAutor.setFont(new Font("Arial", Font.BOLD, 20));
    lblAutor.setForeground(PaletaColor.COLORCELESTE);
    lblAutor.setBounds(20, 110, 100, 30);

    txtAutor.setBounds(201, 110, txtAutor.getPreferredSize().width, txtAutor.getPreferredSize().height);



        JLabel lblEditorial = new JLabel("Editorial:");
        CurvearTextArea txtEditorial = Plantilla.crearTextArea();
        lblEditorial.setFont(new Font("Arial", Font.BOLD, 20));
    lblEditorial.setForeground(PaletaColor.COLORCELESTE);
    lblEditorial.setBounds(20, 180, 100, 30);

    txtEditorial.setBounds(201, 180, txtEditorial.getPreferredSize().width, txtEditorial.getPreferredSize().height);




        JLabel lblAnio = new JLabel("Año de publicación:");
        CurvearTextArea txtAnio = Plantilla.crearTextArea();
        lblAnio.setFont(new Font("Arial", Font.BOLD, 20));
    lblAnio.setForeground(PaletaColor.COLORCELESTE);
    lblAnio.setBounds(50, 20, 200, 30);

    txtAnio.setBounds(50, 60, txtAnio.getPreferredSize().width, txtAnio.getPreferredSize().height);




        JLabel lblIsbn = new JLabel("ISBN:");
        CurvearTextArea txtIsbn = Plantilla.crearTextArea();
        lblIsbn.setFont(new Font("Arial", Font.BOLD, 18));
    lblIsbn.setForeground(PaletaColor.COLORCELESTE);
    lblIsbn.setBounds(50, 105, 100, 30);

    txtIsbn.setBounds(50, 140, txtIsbn.getPreferredSize().width, txtIsbn.getPreferredSize().height);
    


        JLabel lblDisponible = new JLabel("Disponible:");
        lblDisponible.setFont(new Font("Arial", Font.BOLD, 18));
        lblDisponible.setForeground(PaletaColor.COLORCELESTE);
        JCheckBox chkDisponible = new JCheckBox("Sí", true);
        lblDisponible.setBounds(50, 190, 120, 50);
        chkDisponible.setBounds(190, 190, 50, 50);


        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblEditorial);
        panel.add(txtEditorial);
        panel4.add(lblAnio);
        panel4.add(txtAnio);
        panel4.add(lblIsbn);
        panel4.add(txtIsbn);
        panel4.add(lblDisponible);
        panel4.add(chkDisponible);

        panel3.add(panel);
        panel2.add(panel3);
        frame.add(panel2);
        panel3.add(panel4);

        JButton btnRegistrar = Plantilla.crearBoton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = txtNombre.getText();
                    String autor = txtAutor.getText();
                    String editorial = txtEditorial.getText();
                    int anio = Integer.parseInt(txtAnio.getText());
                    String isbn = txtIsbn.getText();
                    boolean disponible = chkDisponible.isSelected();

                    boolean registroExitoso = registrarLibro(nombre, autor, editorial, anio, isbn, disponible);
                    if (registroExitoso) {
                        txtNombre.setText("");
                        txtAutor.setText("");
                        txtEditorial.setText("");
                        txtAnio.setText("");
                        txtIsbn.setText("");
                        chkDisponible.setSelected(true);
                        JOptionPane.showMessageDialog(frame, "Registro exitoso.");
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "No se pudo registrar el libro. Intenta nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Asegúrate de ingresar todos los datos correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        btnRegistrar.setBounds(350, 370,btnRegistrar.getPreferredSize().width, btnRegistrar.getPreferredSize().height);
        
        panel3.add(btnRegistrar);



        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }




    public boolean registrarLibro(String nombre, String autor, String editorial, int anio, String isbn, boolean disponible) {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            String query = "INSERT INTO libro (nombre, autor, editorial, anio, isbn, disponible) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setString(2, autor);
            stmt.setString(3, editorial);
            stmt.setInt(4, anio);
            stmt.setString(5, isbn);
            stmt.setBoolean(6, disponible);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}