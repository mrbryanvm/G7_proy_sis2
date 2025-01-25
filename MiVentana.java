package biblioteca;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

        // panel para usar stbounds

        panelCentral.setLayout(null);

        //poner tmaño del subpanel
        //subPanel.setPreferredSize(new Dimension(300,500));
        subPanel.setBounds(30, 100, 300, 300); 

        //curvear el subpanel
       
     
        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear la instancia de la ventana
        new MiVentana();
    }
}
