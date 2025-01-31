package Frontend;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Plantilla {


    // crear boton
    public static JButton crearBoton(String texto) {
        CurvearButton boton = new CurvearButton(texto, 30);
        
        boton.setBackground(PaletaColor.COLORCELESTECLARO);  
        boton.setForeground(PaletaColor.COLORBLANCO); 
        boton.setFont(new Font("Arial", Font.BOLD, 18)); 
        boton.setPreferredSize(new Dimension(170, 40)); 
         return boton;
    }

    // crear texArea
    public static CurvearTextArea crearTextArea() {
        CurvearTextArea textArea = new CurvearTextArea(30); 
        textArea.setBackground(PaletaColor.COLORPLOMO);  
        textArea.setForeground(Color.BLACK);  
        textArea.setFont(new Font("Arial", Font.PLAIN, 16)); 
        textArea.setPreferredSize(new Dimension(180, 40)); //
        return textArea;
    }


    public static CurvearPanel crearPanelBlanco(int width, int height) {
        CurvearPanel panel = new CurvearPanel(25); 
        panel.setBackground(PaletaColor.COLORBLANCO);   
        panel.setPreferredSize(new Dimension(width, height));

        return panel;
    }

    
    public static JPanel crearPanelAzul() {
        JPanel panel = new JPanel();  
        panel.setBackground(PaletaColor.COLORAZUL);  
        panel.setPreferredSize(new Dimension(850, 500));  
       panel.setBounds(0, 100, 850, 700);
        return panel;  
    }


    public static JPanel crearPanelNaranja() {
        JPanel panel = new JPanel();
        
        panel.setBackground(PaletaColor.COLORNARANJA); 
        panel.setPreferredSize(new Dimension(850, 100));
          panel.setBounds(0, 0, 600, 100); 
        
        panel.setLayout(null); 
          
        JLabel logoLabel = new JLabel();
        
        ImageIcon logoIcono = new ImageIcon("imagenes\\logo.png"); 
        Image logoImage = logoIcono.getImage();
        Image resizedImage = logoImage.getScaledInstance(150, 100, Image.SCALE_SMOOTH); 
        logoLabel.setIcon(new ImageIcon(resizedImage));
        logoLabel.setBounds(30, 0, 150, 100); 
        panel.add(logoLabel);
           
        return panel;
}
}
