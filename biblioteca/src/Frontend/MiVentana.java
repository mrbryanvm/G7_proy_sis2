package Frontend;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;  




public class MiVentana extends JFrame {

    public MiVentana() {
        // Configuración del JFrame
        setTitle("Mi Ventana con Panel");
        setSize(850, 600); // Tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un JPanel
        JPanel panelCentral = new JPanel();
        JPanel panelNorte  = new JPanel();

        
         //crear un subpanel
         //JPanel subPanel= new JPanel();
         RoundedPanel subPanel = new RoundedPanel(30);

         //crear textfield y jlabel
         JLabel label1 = new JLabel("Nombre:");
        JTextField tex1 = new JTextField(20);
        JLabel label2 = new JLabel("Contraseña:");
        JTextField tex2 = new JTextField(20);
        
        JLabel label3 = new JLabel("BIENVENIDO");


        // colores de los componenetes
        // fondo del texfield
        tex1.setBackground(Color.GRAY);
        tex2.setBackground(Color.GRAY);

        //letra del text field color
        tex1.setForeground(Color.BLACK);
        tex2.setForeground(Color.BLACK);

        // color jlabel
         label1.setForeground(Color.BLUE);
         label2.setForeground(Color.BLUE);

         label3.setForeground(Color.WHITE);

         

        // cambiar tmano de la letra jablel
        label1.setFont(new Font("Arial", Font.BOLD, 18));
        label2.setFont(new Font("Arial", Font.BOLD, 18));

        label3.setFont(new Font("Arial", Font.BOLD, 35));


        // cambiar tamano y letra del txt field
        tex1.setFont(new Font("Courier New", Font.PLAIN,18));
        tex2.setFont(new Font("Courier New", Font.PLAIN, 18));
        



        //Posiciones de jlabel y texfield
        label1.setBounds(60, 20, 150, 40);
        tex1.setBounds(60, 60, 180, 30);
        label2.setBounds(60, 90, 150, 40);
        tex2.setBounds(60, 130, 180, 30);

        label3.setBounds(100, 20, 250, 50);

        // poner los componentes al subpanel

        subPanel.add(tex1);
        subPanel.add(tex2);
        subPanel.add(label1);
        subPanel.add(label2);

        panelCentral.add(label3);

        // crear botn 
        JButton boton = new JButton("Iniciar Sesion");
        JButton boton1 = new JButton("Registrarse");
        //posicion boton
        boton.setBounds(64, 190, 170, 30);
        boton1.setBounds(76,240,140,30); 
        //color de botn
        // color fondo
        boton.setBackground(Color.BLUE); 
        boton1.setBackground(Color.BLUE);
        // color letra
        boton.setForeground(Color.WHITE); 
        boton1.setForeground(Color.WHITE);
        // diseno letra
        boton.setFont(new Font("Arial", Font.BOLD, 18));
        boton1.setFont(new Font("Arial", Font.BOLD, 18));


        //anadir el boton al subpanel
        subPanel.add(boton);
        subPanel.add(boton1);



        //imagen crear
        // ruta de la imagen
       

       ImageIcon imagenIcono = new ImageIcon("biblioteca/imagenes/biblio1.jpg"); 
       ImageIcon imagenIcono2 = new ImageIcon("biblioteca/imagenes/logo.png"); 

        // asignar al jlabel la imagen
        
// la imagen redimensionar 
// Obtener la imagen
Image imagen = imagenIcono.getImage();
Image imagen2 = imagenIcono2.getImage(); 
// Ajustar el tamaño a 425x600
imagen = imagen.getScaledInstance(425, 600, Image.SCALE_SMOOTH); 
imagen2 = imagen2.getScaledInstance(150, 100, Image.SCALE_SMOOTH); 
// Asignar la imagen redimensionada al JLabel
ImageIcon imagenRedimensionada = new ImageIcon(imagen);
JLabel etiquetaImagen = new JLabel(imagenRedimensionada);

ImageIcon imagenRedimensionada2 = new ImageIcon(imagen2);
JLabel etiquetaImagen2 = new JLabel(imagenRedimensionada2);

        // acomodar la imagen 
        etiquetaImagen.setBounds(425, 0, 425, 600); 
        etiquetaImagen2.setBounds(50, 0, 150, 100);
        // anadir la inagen al panel central
        panelCentral.add(etiquetaImagen);
        panelNorte.add(etiquetaImagen2);



        // añadir panel color
        panelCentral.setBackground(Color.BLUE);
        panelNorte.setBackground(Color.ORANGE);
        subPanel.setBackground(Color.WHITE); 
       
               

        // Añadir el panel al JFrame
        add(panelCentral,BorderLayout.CENTER);
        add(panelNorte,BorderLayout.NORTH);

        //poner el subpanel al panel del centro

        panelCentral.add(subPanel);

        // poner tamaño

        panelCentral.setPreferredSize(new Dimension(600,750));
        panelNorte.setPreferredSize(new Dimension(600, 100)); 

        // panel para usar setbounds

        panelCentral.setLayout(null);
        subPanel.setLayout(null);
        panelNorte.setLayout(null);

        //poner tmaño del subpanel manunalmente y tambien ponemos su ubicacion
        subPanel.setBounds(50, 100, 300, 300); 

        //curvear el subpanel
       
     
        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la instancia de la ventana
        new MiVentana();
    }
}