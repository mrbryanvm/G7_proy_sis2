public class SesionUsuario {
    private static usuario usuarioActual; // Instancia global del usuario activo
    private static Administrador admin;
    //  Método para establecer el usuario que inició sesión
    public static void iniciarSesion(usuario usuario) {
        usuarioActual = usuario;
    }

    public static void iniciarSesion(Administrador usuario) {
        admin = usuario;
    }

    //  Método para obtener el usuario actual en cualquier parte del programa
    public static usuario getUsuarioActual() {
        return usuarioActual;
    }
    public static Administrador getAdminActual() {
        return admin;
    }

    //  Método para cerrar sesión (eliminar el usuario activo)
    public static void cerrarSesion() {
        usuarioActual = null;
    }
}
