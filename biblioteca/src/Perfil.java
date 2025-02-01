

import Frontend.CurvearTextArea;
import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;



public class Perfil extends JFrame{


    public Perfil() {
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
    JPanel panel= Plantilla.crearPanelBlanco(310, 220);
    panel.setBounds(60, 230, 310, 220);
    panel.setLayout(null);

    //tabla
    JPanel tabla=Plantilla.crearPanelBlanco(300, 350);
    tabla.setBounds(480, 90, 300, 300);
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
        etiquetaImagen.setBounds(135, 10, 180, 180); 


    //componentes
    String[] tipos = {"CATALOGO DE BIBLIOTECA ", "Titulo", "Autor"};

   //ComboBox
    JComboBox<String> comboTipoBusqueda = new JComboBox<>(tipos);
    comboTipoBusqueda.setBounds(60, 20, 200, 50);
    comboTipoBusqueda.setForeground(PaletaColor.COLORCELESTE);

    
    //textArea
    
    CurvearTextArea txtBuscar = Plantilla.crearTextArea();
   
    txtBuscar.setBounds(70, 110, txtBuscar.getPreferredSize().width, txtBuscar.getPreferredSize().height);

    //subtitulo libros disponibles

    JLabel jlSubtitulo = new JLabel("Libros Disponibles:");
    jlSubtitulo.setForeground(PaletaColor.COLORBLANCO);
     jlSubtitulo.setFont(new Font("Arial", Font.BOLD, 18));
      jlSubtitulo.setBounds(540, 40, 180, 50);
    
    //botones  

    JButton btnBuscar = Plantilla.crearBoton("Buscar");
    btnBuscar.setBounds(73, 160, btnBuscar.getPreferredSize().width, btnBuscar.getPreferredSize().height);

    JButton btnPrestarse = Plantilla.crearBoton("Prestarse");
    btnPrestarse.setBounds(540, 400, btnPrestarse.getPreferredSize().width, btnPrestarse.getPreferredSize().height);




    //anadir componentes

    add(panel3);
    add(panel2);
    panel3.add(panel);
    panel3.add(etiquetaImagen);
    panel.add(comboTipoBusqueda);
    panel.add(txtBuscar);
    panel.add(btnBuscar);
    panel3.add(btnPrestarse);
    panel3.add(jlSubtitulo);
    panel3.add(tabla);


    setVisible(true);
    
    }

    public static void main(String[] args) {
        new Perfil();
    }


}
