package biblioteca;
import java.awt.*;
import javax.swing.*;

// Clase personalizada para panel con esquinas redondeadas
class RoundedPanel extends JPanel {
    private int radius;  // Radio de las esquinas redondeadas

    // Constructor que recibe el radio de las esquinas redondeadas
    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // Aseguramos que el panel sea transparente para que el fondo se vea
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Activar el antialiasing para bordes más suaves
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Establecer el color de fondo
        g2d.setColor(getBackground());
        
        // Dibujar un rectángulo con esquinas redondeadas
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    }
}
