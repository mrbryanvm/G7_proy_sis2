public class usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private int ci;
    private int sis;
    private int telefono;
    private String tipo_usuario; 
    
    public usuario(String nombre,String apellido,String correo,int ci,int sis,int telefono,String tipo_usuario){
    this.nombre=nombre;
    this.apellido=apellido;
    this.correo=correo;
    this.ci=ci;
    this.sis=sis;
    this.telefono=telefono;
    this.tipo_usuario=tipo_usuario;
    }

   //Establecer lso datos del estudiante 
   public void setnombre(String nombre){
    this.nombre=nombre;
   }
   public void setapellido(String apellido){
    this.apellido=apellido;
   }
   public void setcorreo(String correo){
    this.correo=correo;
   }
   public void setci(int ci){
    this.ci=ci;
   }
   public void setsis(int sis){
    this.sis=sis;
   }
   public void settelefono(int telefono){
    this.telefono=telefono;
   }
   public void settipo_usuario(String tipo_usuario){
    this.tipo_usuario=tipo_usuario;
   }

   
   //Obtener los datos del estudiante
    public String getNombre(){
    return this.nombre;
    }
    public String getApellido(){
    return this.apellido;
    }
    public String getCorreo(){
        return this.correo;
        }
    public int getTelefono(){
        return telefono; }
    public int getSis(){
        return sis;}
    public int getCi(){
        return ci;}
    public String getTipo_usuario(){
        return this.tipo_usuario;
            }
    
    //Validaciones
    private boolean nombreValido(String nombre){
        return nombre != null && !nombre.trim().isEmpty() && nombre.trim().split("\\s+") <=2;
    }

    private boolean correoValido(String correo){
        return correo != null && correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean telefonoValido(int telefono){
        return  String.valueOf(telefono).length() == 8;     //Tomando en cuenta un numero de celular del estudiante o docente
    }
    
     
}
