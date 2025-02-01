public class Administrador{
private String nombre,apellido,contrasena;
private int telefono;

public Administrador(String nombre,String apellido,int telefono){

this.nombre=nombre;
this.apellido =apellido;
this.telefono=telefono;
}

public void setnombre(String nombre){
    this.nombre=nombre;
   }
   public void setapellido(String apellido){
    this.apellido=apellido;
   }

   public void setContrasena(String contrasena){
    this.contrasena=contrasena;
   }
   public void settelefono(int telefono){
    this.telefono=telefono;
   }

   public String getNombre(){
    return this.nombre;
    }
    public String getApellido(){
    return this.apellido;
    }
    public int getTelefono(){
        return telefono; }

    public String getContrasena(){
        return contrasena;}

    public String GenerarContrasena(){
    String contrasenanueva;
    int i=(int) (Math.random()*9000000)+1000000;
    contrasenanueva = "umss_"+i;

    return contrasenanueva;
    }









    
}