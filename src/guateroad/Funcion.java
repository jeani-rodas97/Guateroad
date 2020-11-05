/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author Jeany
 */
public class Funcion {
    
    public String EncriptarSHA256(String pass)
    {
        MessageDigest dig = null; 
        try{
            dig = MessageDigest.getInstance("SHA-256");
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; 
        }
        
        byte[] encrip = dig.digest(pass.getBytes());
        StringBuffer bufString = new StringBuffer();
        for(byte en : encrip)
        {
            bufString.append(String.format("%02x", en));
        }
        return bufString.toString();
    }
    
    public int QueConductor(double LatUs, double LongUs)
    {
        double menor = 9999.99;
        int Conduct = 0;
        double LatConduct; 
        //double[] lat = new double[Guateroad.LocConductor.localidad.size()];
        
        for(int i = 0; i < Guateroad.LocConductor.localidad.size(); i++)
        {
            //System.out.println(Guateroad.ArbolConductor.NombreP(Guateroad.LocConductor.localidad.get(i).getIdUs()));
            if(Guateroad.LocConductor.localidad.get(i).isDispo())
            {
                LatConduct = Math.abs(LatUs - Guateroad.HashT.LatLugar(Guateroad.LocConductor.localidad.get(i).getLugar()));
                if(LatConduct < menor)
                {
                    menor = LatConduct;
                    //NameConduct = Guateroad.ArbolConductor.NombreP(Guateroad.LocConductor.localidad.get(i).getIdUs());
                    Conduct = Guateroad.LocConductor.localidad.get(i).getIdUs(); 
                }
            }
        }
        
        Guateroad.LocConductor.CambiarDispo(Conduct, false);
        /*
        for(int j = 0; j < lat.length; j++)
        {
            if(lat[j] < menor)
            {
                menor = lat[j];
                id = Guateroad.LocConductor.localidad.get(j).getIdUs();
            }
        } */
        
        return Conduct;
    }
    
             
}
