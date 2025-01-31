package Frontend;

import java.awt.*;
import javax.swing.*;

// Clase para boton con esquinas redondeadas
class CurvearButton extends JButton {
    public int radio; 

    public CurvearButton(String text, int radio) {
        super(text);
        this.radio = radio;
        setContentAreaFilled(false); 
        setFocusPainted(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       
        if (getModel().isPressed()) {
            g2d.setColor(getBackground().darker()); 
        } else {
            g2d.setColor(getBackground()); 
        }

       
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);

       
        super.paintComponent(g); 
    }

    @Override
    protected void paintBorder(Graphics g) {
        
        g.setColor(getBackground()); 
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radio, radio); 
    }
}