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
public class Viajes {
    
    private int idViaje; 
    private int HashInicio; 
    private int HashFin; 
    private String Fecha; 

    public Viajes(int idViaje, int HashInicio, int HashFin, String Fecha) {
        this.idViaje = idViaje;
        this.HashInicio = HashInicio;
        this.HashFin = HashFin;
        this.Fecha = Fecha;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getHashInicio() {
        return HashInicio;
    }

    public void setHashInicio(int HashInicio) {
        this.HashInicio = HashInicio;
    }

    public int getHashFin() {
        return HashFin;
    }

    public void setHashFin(int HashFin) {
        this.HashFin = HashFin;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
