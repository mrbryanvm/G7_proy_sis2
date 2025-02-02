import javax.swing.*;

public class GestorInterfaz extends JFrame {
    private Biblioteca biblioteca;

    public GestorInterfaz() {
        biblioteca = new Biblioteca();
        inicializarUI();
    }

    private void inicializarUI() {
        setTitle("Sistema Gestor de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("📚 Inicio", crearPanelInicio());
        tabbedPane.addTab("👤 Registrar Usuario", new PanelRegistroUsuario(biblioteca));
        tabbedPane.addTab("📖 Gestión de Préstamos", new PanelPrestamos(biblioteca));
        //tabbedPane.addTab("📋 Catálogo de Libros", new PanelCatalogo(biblioteca));
        tabbedPane.addTab("📋 Registrar Libro", new PanelRegistroLibro(biblioteca)); // Nueva pestaña


        add(tabbedPane);
    }

    private JPanel crearPanelInicio() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("📚 Bienvenido al Sistema de Biblioteca", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(18f));
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestorInterfaz().setVisible(true));
    }
}
