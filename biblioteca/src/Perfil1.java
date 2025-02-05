

import Frontend.PaletaColor;
import Frontend.Plantilla;
import java.awt.*;
import javax.swing.*;


public class Perfil1 extends JFrame{
private String nom,ape,sisc;
private int ci;

    public Perfil1() {  
        setTitle("perfil");
        setSize(750, 500); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        usuario usu = SesionUsuario.getUsuarioActual();
        Administrador admin =SesionUsuario.getAdminActual();

        if(usu!=null){this.nom =usu.getNombre(); this.ape=usu.getApellido();this.ci=usu.getCi(); this.sisc=""+usu.getSis();
        }else{nom=admin.getNombre();ape=admin.getApellido();ci=admin.getCi();sisc = admin.getContrasena();}
    
    // Crear panel naranja
    JPanel panel2 = Plantilla.crearPanelNaranja();
    panel2.setLayout(null);
  
    // Crear el panel azul 
    JPanel panel3 = Plantilla.crearPanelAzul();
    panel3.setLayout(null);

    // imagen 
    ImageIcon imagenIcono2= new ImageIcon( "imagenes/biblio3.jpg" ); 
        Image imagen2 = imagenIcono2.getImage();

        imagen2 = imagen2.getScaledInstance(425, 500, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada2 = new ImageIcon(imagen2);
        JLabel etiquetaImagen2= new JLabel(imagenRedimensionada2);
        etiquetaImagen2.setBounds(425, 0, 425, 500); 
        panel3.add(etiquetaImagen2);
        

    


    // Crear el título
    JLabel lblTitulo = new JLabel("PERFIL");
    lblTitulo.setFont(new Font("Arial", Font.BOLD, 38));
    lblTitulo.setBounds(360, 30, 460, 50);
    lblTitulo.setForeground(PaletaColor.COLORCELESTECLARO);
    panel2.add(lblTitulo); 

    //panel blanco
    JPanel panelBLanco = Plantilla.crearPanelBlanco(250, 120);
    panelBLanco.setBounds(30, 230, 350, 120);
    panelBLanco.setLayout(null);



    //Jlabels
    // JLabel lbleditarPerfil = new JLabel("Perfil");
   //  lbleditarPerfil.setFont(new Font("Arial", Font.BOLD, 20));
   //  lbleditarPerfil.setForeground(PaletaColor.COLORBLANCO);
   //  lbleditarPerfil.setBounds(170, 190, 150, 30);
    // panel3.add(lbleditarPerfil);

     JLabel lblNombre = new JLabel("Nombre:  " + nom);
     lblNombre.setFont(new Font("Arial", Font.BOLD, 20));
     lblNombre.setForeground(PaletaColor.COLORCELESTE);
     lblNombre.setBounds(40, 10, 250, 30);
     panelBLanco.add(lblNombre);

     JLabel lblApellido = new JLabel("Apellido:  " +ape);
     lblApellido.setFont(new Font("Arial", Font.BOLD, 20));
     lblApellido.setForeground(PaletaColor.COLORCELESTE);
     lblApellido.setBounds(40, 40, 250, 30);
     panelBLanco.add(lblApellido);


     JLabel lblCi = new JLabel("CI:   " + ci);
     lblCi.setFont(new Font("Arial", Font.BOLD, 20));
     lblCi.setForeground(PaletaColor.COLORCELESTE);
     lblCi.setBounds(40, 70, 250, 30);
     panelBLanco.add(lblCi);

     JLabel lblSis = new JLabel("Sis o Contasena:   " +sisc);
     lblSis.setFont(new Font("Arial", Font.BOLD, 20));
     lblSis.setForeground(PaletaColor.COLORCELESTE);
     lblSis.setBounds(40, 90, 250, 30);
     panelBLanco.add(lblSis);
     






    //imagen
    ImageIcon imagenIcono = new ImageIcon( "imagenes/icono2.png" ); 
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
        new Perfil1();
    }


}