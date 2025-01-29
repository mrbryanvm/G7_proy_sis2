package biblioteca;

import java.awt.*;
import javax.swing.*;

class CurvearPanel extends JPanel {
    public int radio;  // Radio de las esquinas redondeadas

    // Constructor que recibe el radio de las esquinas redondeadas
    public CurvearPanel(int radio) {
        this.radio = radio;
        setOpaque(false); // Aseguramos que el panel sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Establecer el color de fondo
        g2d.setColor(getBackground());
        
        // Dibujar un rectángulo con esquinas redondeadas
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);
    }
}

