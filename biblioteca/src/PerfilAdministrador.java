

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;



public class PerfilAdministrador extends JFrame{


    public PerfilAdministrador() {
        setTitle("perfil");
        setSize(850, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
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
    JPanel tabla=Plantilla.crearPanelBlanco(200, 200);
    tabla.setBounds(550, 250, 200, 200);
    tabla.setLayout(null);


    // Crear el título
    JLabel lblTitulo = new JLabel("BIENVENIDO");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 38));
    lblTitulo.setBounds(360, 30, 460, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); 

    //subtitulo nombre
     JLabel lblNombre = new JLabel("Nombre");
     lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
     lblNombre.setForeground(PaletaColor.COLORBLANCO);
     lblNombre.setBounds(185, 190, 100, 30);
     panel3.add(lblNombre);


    //imagen
    ImageIcon imagenIcono = new ImageIcon( "biblioteca/imagenes/icono2.png" ); 
        Image imagen = imagenIcono.getImage();

        imagen = imagen.getScaledInstance(180, 180, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada = new ImageIcon(imagen);
        JLabel etiquetaImagen = new JLabel(imagenRedimensionada);
        etiquetaImagen.setBounds(135, 5, 180, 180); 


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

    JButton btnPrestamos = Plantilla.crearBoton("Prestamos");
    btnPrestamos.setBounds(40, 230, btnPrestamos.getPreferredSize().width, btnPrestamos.getPreferredSize().height);

    JButton btnNoDevueltos = Plantilla.crearBoton("No Devueltos");
    btnNoDevueltos.setBounds(40, 290, btnNoDevueltos.getPreferredSize().width, btnNoDevueltos.getPreferredSize().height);
 
    JButton btnFrecuente = Plantilla.crearBoton("Frecuentes");
    btnFrecuente.setBounds(40, 350, btnFrecuente.getPreferredSize().width, btnFrecuente.getPreferredSize().height);

    JButton btnReportarse = Plantilla.crearBoton("Reportes");
    btnReportarse.setBounds(40, 410, btnReportarse.getPreferredSize().width, btnReportarse.getPreferredSize().height);

    JButton btnRoja = Plantilla.crearBoton("Ver Lista Roja");
    btnRoja.setBounds(230, 230, btnRoja.getPreferredSize().width, btnRoja.getPreferredSize().height);

    JButton btnPrestar = Plantilla.crearBoton("Prestar Libro");
    btnPrestar.setBounds(230, 290, btnPrestar.getPreferredSize().width, btnPrestar.getPreferredSize().height);


    JButton btnRegistrar = Plantilla.crearBoton("Registrar Libro");
    btnRegistrar.setBounds(230, 350, btnRegistrar.getPreferredSize().width, btnRegistrar.getPreferredSize().height);

    JButton btnDevolucion = Plantilla.crearBoton("Devoluciones");
    btnDevolucion.setBounds(230, 410, btnDevolucion.getPreferredSize().width, btnDevolucion.getPreferredSize().height);
    //anadir componentes

    add(panel3);
    add(panel2);
    panel3.add(panel);
    panel3.add(etiquetaImagen);
    panel.add(comboTipoBusqueda);
    panel.add(txtBuscar);
    panel.add(btnBuscar);
    panel3.add(btnPrestamos);
    panel3.add(jlSubtitulo);
    panel3.add(tabla);
    panel3.add(btnPrestar);
    panel3.add(btnNoDevueltos);
    panel3.add(btnDevolucion);
    panel3.add(btnFrecuente);
    panel3.add(btnRegistrar);
    panel3.add(btnReportarse);
    panel3.add(btnRoja);


    setVisible(true);
    
    }

    public static void main(String[] args) {
        new PerfilAdministrador();
    }


}

