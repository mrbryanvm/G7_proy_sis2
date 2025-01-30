public class usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private int ci;
    private int sis;
    private int telefono;
    private String tipo_usuario; 
    
    public usuario(String nombre,String apellido,String correo,int ci,int sis,int telefono,String tipo_usuario){
        if(nombreValido(nombre) && nombreValido(apellido)){
            this.nombre = nombre;
            this.apellido = apellido;
        }else {
            throw new IllegalArgumentException("Nombre o apellido inválido. Asegúrese de que no estén vacíos o contengan más de dos palabras.");
        }

        if(correoValido(correo)){
            this.correo = correo;
        }else {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }

        if(ci > 0){
            this.ci = ci;
        }else {
            throw new IllegalArgumentException("CI inválido.");
        }

        if(codSisValido(sis)){
            this.sis=sis;
        }else {
            throw new IllegalArgumentException("Codigo SIS inválido.");
        }

        if(telefonoValido(telefono)){
            this.telefono=telefono;
        }else {
            throw new IllegalArgumentException("Número de teléfono inválido.");
        }
        
        this.tipo_usuario=tipo_usuario;
         
        /*this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.ci=ci;
        this.sis=sis;
        this.telefono=telefono;
        this.tipo_usuario=tipo_usuario;*/
    }

   //Establecer los datos del estudiante 
   public void setnombre(String nombre){
        if(nombreValido(nombre) ){
            this.nombre = nombre;
        }else {
            throw new IllegalArgumentException("Nombre inválido.");
        }
   }

   public void setapellido(String apellido){
        if(nombreValido(apellido)){
            this.apellido = apellido;
        }else {
            throw new IllegalArgumentException("Apellido inválido.");
        }
   }

   public void setcorreo(String correo){
        if( correoValido(correo)){
            this.correo = correo;
        }else {
            throw new IllegalArgumentException("Correo electrónico inválido.");
        }
   }

   public void setci(int ci){
        if(ci>0){
            this.ci=ci;
        }else {
            throw new IllegalArgumentException("CI inválido.");
        }
   }
   public void setsis(int sis){
        if(codSisValido(sis)){
            this.sis = sis;
        }else {
            throw new IllegalArgumentException("Codigo SIS inválido.");
        }
   }

   public void settelefono(int telefono){
        if(telefonoValido(telefono)){
            this.telefono = telefono;
        }else {
            throw new IllegalArgumentException("Número de teléfono inválido.");
        }
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
        return telefono; 
    }
    public int getSis(){
        return sis;
    }
    public int getCi(){
        return ci;
    }
    public String getTipo_usuario(){
        return tipo_usuario;
    }
    
    //Validaciones
    private boolean nombreValido(String nombre){
        return nombre != null && !nombre.trim().isEmpty();
    }

    private boolean correoValido(String correo){
        return correo != null && correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean telefonoValido(int telefono){
        return  String.valueOf(telefono).length() == 8 && telefono > 0;     //Tomando en cuenta un numero de celular del estudiante o docente
    }

    private boolean codSisValido(int codSis){
        return String.valueOf(codSis).length() == 9 && codSis > 0;
    }
   
}
