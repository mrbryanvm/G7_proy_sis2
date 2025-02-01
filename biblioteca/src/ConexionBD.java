import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD{
    private static Connection conexion;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/biblioteca"; // 
    private static final String usuario = "root"; // Usuario de tu BD
    private static final String contrasena = ""; // Contraseña de tu BD

    public static Connection getConexion() {
        if (conexion == null) { // Si no se ha inicializado la conexión
            try {
                // Verifica que el controlador esté cargado
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Inicializa la conexión
                conexion = DriverManager.getConnection(URL, usuario, contrasena);
               // System.out.println("¡Conexión exitosa!");
            } catch (ClassNotFoundException e) {
               // System.out.println("Error: No se encontró el controlador JDBC: " + e.getMessage());
            } catch (SQLException e) {
               // System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            }
        }
        return conexion; // Devuelve la conexión existente o null si falló
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
               // System.out.println("Conexión cerrada correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}




