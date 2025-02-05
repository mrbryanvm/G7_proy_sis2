import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import Frontend.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Home extends JFrame {
  
  public static void main(String[] args) {
    new Home();
}

    public Home() {
        // Configuración del JFrame
        setTitle("Home");
        setSize(850, 600); // Tamaño del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // paneles
        JPanel panelNaranja =Plantilla.crearPanelNaranja();
        JPanel panelAzul = Plantilla.crearPanelAzul();
        JPanel panelBlanco =Plantilla.crearPanelBlanco(200, 100);

        panelAzul.setLayout(null);
        panelBlanco.setLayout(null);

        
        //botones
        JButton botonLogin = Plantilla.crearBoton("Login");
        JButton botonRegistro =Plantilla.crearBoton("Registrarse");
        botonLogin.setBounds(50, 20, botonLogin.getPreferredSize().width, botonLogin.getPreferredSize().height);
        botonLogin.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             Login login = new Login();


              // Verificar si el usuario inicia sesión correctamente
        login.addLoginSuccessListener(new Login.LoginSuccessListener() {
          @Override
          public void onLoginSuccess() {
              dispose(); // Cierra la ventana Home
          }
      });
                  }});


        botonRegistro.setBounds(50, 70, botonRegistro.getPreferredSize().width, botonRegistro.getPreferredSize().height);

        botonRegistro.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {

            String[] opciones = {"Usuario(Estudiante o Docente)", "Administrador"};
            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de usuario:",
                    "Registro",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Abrir la ventana de registro correspondiente
            if (seleccion != null) {
                switch (seleccion) {
                    case "Usuario(Estudiante o Docente)":
                        new registro();
                        break;
                    case "Administrador":
                        new registro_Administradores();
                        break;
                }
            }
                  }});
  





        panelBlanco.setBounds(80, 310, 260, 120);
        panelBlanco.add(botonLogin);
        panelBlanco.add(botonRegistro);

        // anadir componentes

        add(panelAzul);
        add(panelNaranja);
        panelAzul.add(panelBlanco);
       
        // imagen
        ImageIcon imagenIcono = new ImageIcon( "imagenes\\biblio1.jpg" ); 
        Image imagen = imagenIcono.getImage();

        imagen = imagen.getScaledInstance(425, 500, Image.SCALE_SMOOTH); 
        ImageIcon imagenRedimensionada = new ImageIcon(imagen);
        JLabel etiquetaImagen = new JLabel(imagenRedimensionada);
        etiquetaImagen.setBounds(425, 0, 425, 500); 
        panelAzul.add(etiquetaImagen);

        // titulo
        JLabel label3 = new JLabel("BIENVENIDO");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Arial", Font.BOLD, 35));
         label3.setBounds(100, 20, 250, 50);
         panelAzul.add(label3);

         //parrafo

         JTextArea textArea = new JTextArea("Bienvenido a nuestra biblioteca digital, un espacio creado para facilitar el acceso a la información y el conocimiento. Desde sus inicios, este sistema ha sido diseñado para organizar, gestionar y simplificar la búsqueda de libros y recursos, asegurando que cada usuario encuentre lo que necesita de manera rápida y eficiente.");
      textArea.setBounds(60, 100, 300, 190);  
      textArea.setFont(new Font("Arial", Font.BOLD, 16)); 
      textArea.setForeground(Color.WHITE);  
      textArea.setBackground(PaletaColor.COLORCELESTE);   
      textArea.setLineWrap(true);           
      textArea.setWrapStyleWord(true);      
      textArea.setEditable(false);         

      panelAzul.add(textArea); 

      // subtitulos 
      JLabel label4 = new JLabel("SOPORTE");
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("Arial", Font.BOLD, 18));
         label4.setBounds(710, 40, 100, 50);
         panelNaranja.add(label4);

      JLabel label5 = new JLabel("BUSCAR");
      label5.setForeground(Color.BLACK);
      label5.setFont(new Font ("Arial",Font.BOLD,18));
      label5.setBounds(600,40,100,50);
       panelNaranja.add(label5);

        setVisible(true);


    
   }

}