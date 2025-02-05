

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class PerfilAdministrador extends JFrame{

    public static void main(String[] args) {
        new PerfilAdministrador();
    }

    public PerfilAdministrador() {
        setTitle("perfil");
        setSize(850, 650); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
    // Crear panel naranja
    JPanel panel2 = Plantilla.crearPanelNaranja();
    panel2.setLayout(null);
  
    // Crear el panel azul 
    JPanel panel3 = Plantilla.crearPanelAzul();
    panel3.setLayout(null);

    // Crear panel blanco
    JPanel panel= Plantilla.crearPanelBlanco(300, 180);
    panel.setBounds(500, 10, 300, 180);
    panel.setLayout(null);

    //tabla
    JPanel tabla=new LibroSelector();
   tabla.setBounds(480, 230, 300, 250);


    // Crear el título
    JLabel lblTitulo = new JLabel("BIENVENIDO ADMINISTRADOR");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 34));
    lblTitulo.setBounds(200, 30, 660, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); 

    //subtitulo nombre
     JLabel lblNombre = new JLabel("Perfil");
     lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
     lblNombre.setForeground(PaletaColor.COLORBLANCO);
     lblNombre.setBounds(185, 190, 100, 30);
     panel3.add(lblNombre);


    //imagen
    ImageIcon imagenIcono = new ImageIcon( "imagenes/icono2.png" ); 
        Image imagen = imagenIcono.getImage();

        imagen = imagen.getScaledInstance(180, 180, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada = new ImageIcon(imagen);
        JLabel etiquetaImagen = new JLabel(imagenRedimensionada);
        etiquetaImagen.setBounds(135, 5, 180, 180); 
         // Agregar evento de clic edl icono
        etiquetaImagen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               new Perfil1();
            }
        });


    //componentes
    String[] tipos = {"CATALOGO DE BIBLIOTECA ", "Titulo", "Autor"};

   //ComboBox
    JComboBox<String> comboTipoBusqueda = new JComboBox<>(tipos);
    comboTipoBusqueda.setBounds(50, 10, 200, 50);
    comboTipoBusqueda.setForeground(PaletaColor.COLORCELESTE);

    
    //textArea
    
    CurvearTextArea txtBuscar = Plantilla.crearTextArea();
   
    txtBuscar.setBounds(62, 80, txtBuscar.getPreferredSize().width, txtBuscar.getPreferredSize().height);

    //subtitulo libros disponibles

    JLabel jlSubtitulo = new JLabel("Libros Disponibles:");
    jlSubtitulo.setForeground(PaletaColor.COLORBLANCO);
     jlSubtitulo.setFont(new Font("Arial", Font.BOLD, 18));
      jlSubtitulo.setBounds(540, 190, 180, 50);
    
    //botones  

    JButton btnBuscar = Plantilla.crearBoton("Buscar");
    btnBuscar.setBounds(68, 135, btnBuscar.getPreferredSize().width, btnBuscar.getPreferredSize().height);


    JButton btnNoDevueltos = Plantilla.crearBoton("No Devueltos");
    btnNoDevueltos.setBounds(40, 230, btnNoDevueltos.getPreferredSize().width, btnNoDevueltos.getPreferredSize().height);
 
    JButton btnFrecuente = Plantilla.crearBoton("Frecuentes");
    btnFrecuente.setBounds(40, 290, btnFrecuente.getPreferredSize().width, btnFrecuente.getPreferredSize().height);

    JButton btnReportarse = Plantilla.crearBoton("Reportes");
    btnReportarse.setBounds(40, 350, btnReportarse.getPreferredSize().width, btnReportarse.getPreferredSize().height);

    JButton btnRoja = Plantilla.crearBoton("Ver Lista Roja");
    btnRoja.setBounds(230, 230, btnRoja.getPreferredSize().width, btnRoja.getPreferredSize().height);


    JButton btnRegistrar = Plantilla.crearBoton("Registrar Libro");
    btnRegistrar.setBounds(230, 290, btnRegistrar.getPreferredSize().width, btnRegistrar.getPreferredSize().height);
    btnRegistrar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           new RegistroLibro();
        }
    });



    JButton btnDevolucion = Plantilla.crearBoton("Devoluciones");
    btnDevolucion.setBounds(230, 350, btnDevolucion.getPreferredSize().width, btnDevolucion.getPreferredSize().height);
    btnDevolucion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
                Administrador usuario = SesionUsuario.getAdminActual();
                if (usuario != null) {
                    // Si el usuario es administrador, pedir el SIS del alumno
                    String sisAlumno = JOptionPane.showInputDialog("Ingrese el SIS del alumno:");
                    String nomLibro = JOptionPane.showInputDialog("Ingrese el Nombre del Libro:");
                    String autor = JOptionPane.showInputDialog("Ingrese el Autor del Libro:");
                    if (sisAlumno != null && !sisAlumno.trim().isEmpty() && nomLibro !=null && autor!=null && !nomLibro.trim().isEmpty()&& !autor.trim().isEmpty()) {
                        if (verificarUsuarioEnBD(sisAlumno)) {
                            new Devolucion(nomLibro, autor);
                        } else {
                            JOptionPane.showMessageDialog(null, "El usuario con SIS " + sisAlumno + " no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }  
        }
    });



    JButton atras = new JButton("Inicio");
    atras.setBounds(40, 450, 100,60);
    atras.setBackground(PaletaColor.COLORBLANCO);
    atras.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new Home();
        }
    });




    add(panel3);
    add(panel2);
    panel3.add(panel);
    panel3.add(etiquetaImagen);
    panel.add(comboTipoBusqueda);
    panel.add(txtBuscar);
    panel.add(btnBuscar);
    panel3.add(jlSubtitulo);
    panel3.add(tabla);
    panel3.add(btnNoDevueltos);
    panel3.add(btnDevolucion);
    panel3.add(btnFrecuente);
    panel3.add(btnRegistrar);
    panel3.add(btnReportarse);
    panel3.add(btnRoja);
    panel3.add(atras);


    setVisible(true);
    
    }

  

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