package Frontend;

import java.awt.*;
import javax.swing.*;

public class CurvearTextArea extends JTextArea {
    public int radio;  // Radio de las esquinas redondeadas

    // Constructor que recibe el radio de las esquinas redondeadas
    public CurvearTextArea(int radio) {
        this.radio = radio;
        setOpaque(false); // Aseguramos que el área de texto sea transparente para que se vea el borde redondeado
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar el borde con esquinas redondeadas
        g2d.setColor(getBackground()); // Fondo del JTextArea
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
        
        super.paintComponent(g);
    }
}