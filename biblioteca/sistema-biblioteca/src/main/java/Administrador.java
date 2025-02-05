import java.util.regex.Pattern;

public class Administrador {
      private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private String direccion;
    private String bibliotecaAsignada;
    private int telefono;
    private int ci;

    public Administrador(String nombre, String apellido, int ci, int telefono, String correo, String direccion, String bibliotecaAsignada) {
        setNombre(nombre);
        setApellido(apellido);
        setCi(ci);
        setTelefono(telefono);
        setCorreo(correo);
        setDireccion(direccion);
        setBibliotecaAsignada(bibliotecaAsignada);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        if (ci <= 0) {
            throw new IllegalArgumentException("El CI debe ser un número positivo.");
        }
        this.ci = ci;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        if (String.valueOf(telefono).length() != 8) {
            throw new IllegalArgumentException("El teléfono debe tener 8 dígitos.");
        }
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || !Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", correo)) {
            throw new IllegalArgumentException("Correo electrónico no válido.");
        }
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }

    public String getBibliotecaAsignada() {
        return bibliotecaAsignada;
    }

    public void setBibliotecaAsignada(String bibliotecaAsignada) {
        if (bibliotecaAsignada == null || bibliotecaAsignada.trim().isEmpty()) {
            throw new IllegalArgumentException("La biblioteca asignada no puede estar vacía.");
        }
        this.bibliotecaAsignada = bibliotecaAsignada;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || !Pattern.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$", contrasena)) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres, una mayúscula y un número.");
        }
        this.contrasena = contrasena;
    }
}
