

import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;


public class editarPerfil extends JFrame{


    public editarPerfil() {  
        setTitle("perfil");
        setSize(850, 600); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
    // Crear panel naranja
    JPanel panel2 = Plantilla.crearPanelNaranja();
    panel2.setLayout(null);
  
    // Crear el panel azul 
    JPanel panel3 = Plantilla.crearPanelAzul();
    panel3.setLayout(null);

    // imagen 
    ImageIcon imagenIcono2= new ImageIcon( "biblioteca/imagenes/biblio3.jpg" ); 
        Image imagen2 = imagenIcono2.getImage();

        imagen2 = imagen2.getScaledInstance(425, 500, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada2 = new ImageIcon(imagen2);
        JLabel etiquetaImagen2= new JLabel(imagenRedimensionada2);
        etiquetaImagen2.setBounds(425, 0, 425, 500); 
        panel3.add(etiquetaImagen2);
        

    


    // Crear el título
    JLabel lblTitulo = new JLabel("BIENVENIDO");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 38));
    lblTitulo.setBounds(360, 30, 460, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); 

    //panel blanco
    JPanel panelBLanco = Plantilla.crearPanelBlanco(250, 120);
    panelBLanco.setBounds(90, 230, 250, 120);
    panelBLanco.setLayout(null);



    //Jlabels
     JLabel lbleditarPerfil = new JLabel("Editar Perfil");
     lbleditarPerfil.setFont(new Font("Arial", Font.BOLD, 20));
     lbleditarPerfil.setForeground(PaletaColor.COLORBLANCO);
     lbleditarPerfil.setBounds(170, 190, 150, 30);
     panel3.add(lbleditarPerfil);

     JLabel lblNombre = new JLabel("Nombre: ");
     lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
     lblNombre.setForeground(PaletaColor.COLORCELESTE);
     lblNombre.setBounds(40, 10, 150, 30);
     panelBLanco.add(lblNombre);

     JLabel lblApellido = new JLabel("Apellido: ");
     lblApellido.setFont(new Font("Arial", Font.BOLD, 20));
     lblApellido.setForeground(PaletaColor.COLORCELESTE);
     lblApellido.setBounds(40, 40, 150, 30);
     panelBLanco.add(lblApellido);


     JLabel lblCi = new JLabel("CI: ");
     lblCi.setFont(new Font("Arial", Font.BOLD, 20));
     lblCi.setForeground(PaletaColor.COLORCELESTE);
     lblCi.setBounds(40, 70, 150, 30);
     panelBLanco.add(lblCi);

     JLabel lblSis = new JLabel("Sis: ");
     lblSis.setFont(new Font("Arial", Font.BOLD, 20));
     lblSis.setForeground(PaletaColor.COLORCELESTE);
     lblSis.setBounds(40, 90, 150, 30);
     panelBLanco.add(lblSis);
     






    //imagen
    ImageIcon imagenIcono = new ImageIcon( "biblioteca/imagenes/icono2.png" ); 
        Image imagen = imagenIcono.getImage();

        imagen = imagen.getScaledInstance(180, 180, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada = new ImageIcon(imagen);
        JLabel etiquetaImagen = new JLabel(imagenRedimensionada);
        etiquetaImagen.setBounds(135, 5, 180, 180); 

    
      // botones
      JButton btnHistorial = Plantilla.crearBoton("Historial");
    btnHistorial.setBounds(125, 360, btnHistorial.getPreferredSize().width, btnHistorial.getPreferredSize().height);

    JButton btnComunicados = Plantilla.crearBoton("Comunicados");
    btnComunicados.setBounds(125, 410, btnComunicados.getPreferredSize().width, btnComunicados.getPreferredSize().height);
   
   
    //anadir componentes

    add(panel3);
    add(panel2);
    panel3.add(panelBLanco);

    panel3.add(etiquetaImagen);
    panel3.add(btnComunicados);
    panel3.add(btnHistorial);
   

    setVisible(true);
    
    }

    public static void main(String[] args) {
        new editarPerfil();
    }


}

