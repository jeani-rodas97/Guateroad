/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

/**
 *
 * @author Jeany
 */
public class Lugares {
    private int Id; 
    private String Categoria; 
    private String Nombre; 
    private Double Latitud; 
    private Double Longitud; 

    public Lugares(int Id, String Categoria, String Nombre, Double Latitud, Double Longitud) {
        this.Id = Id;
        this.Categoria = Categoria;
        this.Nombre = Nombre;
        this.Latitud = Latitud;
        this.Longitud = Longitud;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Double getLatitud() {
        return Latitud;
    }

    public void setLatitud(Double Latitud) {
        this.Latitud = Latitud;
    }

    public Double getLongitud() {
        return Longitud;
    }

    public void setLongitud(Double Longitud) {
        this.Longitud = Longitud;
    }
    
    
}

