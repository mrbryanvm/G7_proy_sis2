public class Administrador {
    private String nombre, apellido, contrasena, correo, direccion, bibliotecaAsignada;
    private int telefono, ci;

    public Administrador(String nombre, String apellido, int ci, int telefono, String correo, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.ci = ci;
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getDireccion() {
        return this.direccion;
    }


    public int getCi() {
        return this.ci;
    }

    
}