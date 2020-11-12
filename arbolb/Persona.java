/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

/**
 *
 * @author Jeany
 */
public class Persona {

    private int Id;
    private String Nombre;
    private String Usuario;
    private String Rol;
    private String Password;
    private String Correo;
    private String Telefono;
    private boolean Disponible;

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Persona(int Id, String Nombre, String Usuario, String Rol, String Password, String Correo, String Telefono, boolean Disponible) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Rol = Rol;
        this.Password = Password;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Disponible = Disponible;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }
    
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}
