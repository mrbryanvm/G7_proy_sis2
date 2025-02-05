import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.Calendar;

import Frontend.CurvearTextArea;
import Frontend.Plantilla;

public class Prestamo {
    private String nombre_libro;
    private String autor;
    private int cant;
    usuario usuario=SesionUsuario.getUsuarioActual();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Prestamo(" "," "));
    }

    public Prestamo(String nombre,String autor) {
        nombre_libro=nombre;
        this.autor=autor;
        mostrarFormulario();
    }

    private void mostrarFormulario() {
        JFrame frame = new JFrame("Registro de Préstamos");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);

        Plantilla plantilla = new Plantilla();
        JPanel panel2 = plantilla.crearPanelNaranja();
        panel2.setPreferredSize(new Dimension(400, 200));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel3 = plantilla.crearPanelAzul();

        JLabel lblTitulo = new JLabel("Registro de Préstamos", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        panel2.add(lblTitulo);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));

        // Etiqueta y su nombre :v
        JLabel lblUsuario = new JLabel("Nombre del usuario: ");
        
        JLabel txtUsuario = new JLabel(usuario.getTipo_usuario()+" "+usuario.getNombre()+" "+usuario.getApellido());

 
        // Etiqueta para la fecha de préstamo (fecha actual)
        JLabel lblCarrera = new JLabel("Carrea que estudia o reparte:");
        CurvearTextArea txtCarrera = plantilla.crearTextArea();


        // Etiqueta para la fecha de préstamo (fecha actual)
        JLabel lblFechaPrestamo = new JLabel("Fecha de préstamo (YYYY-MM-DD):");
        JLabel lblFechaPrestamoValor = new JLabel(getFechaActual().toString());

        // Etiqueta para la fecha de devolución (3 meses después)
        JLabel lblFechaDevolucion = new JLabel("Fecha de devolución (YYYY-MM-DD):");
        JLabel lblFechaDevolucionValor = new JLabel(getFechaDevolucion().toString());

        panel.add(lblUsuario);
        panel.add(txtUsuario);
        panel.add(lblCarrera);
        panel.add(txtCarrera);
        panel.add(lblFechaPrestamo);
        panel.add(lblFechaPrestamoValor);
        panel.add(lblFechaDevolucion);
        panel.add(lblFechaDevolucionValor);

        panel3.add(panel, BorderLayout.CENTER);
        panel2.add(panel3, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.CENTER);

        JButton btnRegistrar = plantilla.crearBoton("Registrar Préstamo");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String carrera = txtUsuario.getText();
                    Date fechaPrestamo = getFechaActual();  
                    Date fechaDevolucion = getFechaDevolucion(); 
                    if (carrera.isEmpty() ) {
                        JOptionPane.showMessageDialog(frame, "Por favor, ingrese todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                if(verificarLibro()){

                    boolean exito = registrarPrestamo(carrera, fechaPrestamo, fechaDevolucion,nombre_libro,autor);
                    if (exito) {
                        JOptionPane.showMessageDialog(frame, "Préstamo registrado exitosamente.");
                        new ReportePrestamo(nombre_libro, autor, fechaPrestamo, fechaDevolucion);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "No se pudo registrar el préstamo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{JOptionPane.showMessageDialog(frame, "Este libro no esta disponible estan siendo ocupados.", "Error", JOptionPane.ERROR_MESSAGE);}


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Algo salio mal en el registro intentelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel3.add(btnRegistrar, BorderLayout.SOUTH);
        frame.revalidate();
        frame.repaint();
        frame.setVisible(true);
    }

    // Método para obtener la fecha actual
    private Date getFechaActual() {
        Calendar calendar = Calendar.getInstance();
        return new Date(calendar.getTimeInMillis());
    }

    // Método para obtener la fecha de devolución (3 meses después)
    private Date getFechaDevolucion() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 3); 
        return new Date(calendar.getTimeInMillis());
    }


    public  boolean registrarPrestamo(String carrera, Date fechaPrestamo, Date fechaDevolucion,String nombreLibro,String autor) {
        try {
            Connection conexion = ConexionBD.getConexion();
            if (conexion == null) {
                JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            int contras=usuario.getSis();
            //Insertar registro de Prestamo
            String insertQuery = "INSERT INTO prestamo (carrera , fecha_prestamo, fecha_devolucion, usuario_sis, nombre_libro, autor) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt = conexion.prepareStatement(insertQuery);
            insertStmt.setString(1, carrera);
            insertStmt.setDate(2, fechaPrestamo);
            insertStmt.setDate(3, fechaDevolucion);
            insertStmt.setInt(4,contras);
            insertStmt.setString(5,nombreLibro);
            insertStmt.setString(6,autor);
            insertStmt.executeUpdate();
            //Actulizar los libros disponibles ya ue se acab de registrar
            String updateQuery = "UPDATE libro SET cantidad_disponible = ? WHERE nombre = ? AND autor = ?";
            PreparedStatement updateStmt = conexion.prepareStatement(updateQuery);
            updateStmt.setInt(1, cant - 1);
            updateStmt.setString(2, nombre_libro);
            updateStmt.setString(3, autor);
            updateStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Préstamo registrado exitosamente.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    public  boolean verificarLibro(){
     try {
        Connection conexion = ConexionBD.getConexion();
        if (conexion == null) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        String insertQuery = "Select cantidad_disponible FROM libro WHERE nombre = ? AND AUTOR = ?";
        PreparedStatement Stmt = conexion.prepareStatement(insertQuery);
        Stmt.setString(1, this.nombre_libro);
        Stmt.setString(2, this.autor);
        ResultSet rs =Stmt.executeQuery();
        if(rs.next()){
          cant =rs.getInt("cantidad_disponible");
         if(cant>=1){ 
          return true;}else{return false;}
        } else {return false;}
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
    }
}
