/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

/**
 *
 * @author Jeany
 */
public class Localidad {
    private String rol;
    private int idUs; 
    private String Lugar;
    private boolean dispo;

    public Localidad(String rol, int idUs, String Lugar, boolean dispo) {
        this.rol = rol;
        this.idUs = idUs;
        this.Lugar = Lugar;
        this.dispo = dispo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getIdUs() {
        return idUs;
    }

    public void setIdUs(int idUs) {
        this.idUs = idUs;
    }

    public String getLugar() {
        return Lugar;
    }

    public void setLugar(String Lugar) {
        this.Lugar = Lugar;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }
    
}

