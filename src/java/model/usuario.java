
package model;

public class usuario {
    
    public usuario(int id, String nombre, String apellido, String email, String contrasena, String descripcion){
       this.id = id;
       this.nombre = nombre;
       this.apellido = apellido;
       this.email = email;
       this.contrasena = contrasena;
       this.descripcion =  descripcion;
    }
    
    public usuario(){
        
    }
    
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String descripcion;    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
