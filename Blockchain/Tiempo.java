/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import static guateroad.Guateroad.blockchain;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.json.JSONException;

/**
 *
 * @author Jeany
 */
public class Tiempo extends Thread{
    
    @Override
    public void run()
    {
        while(true)
        {
            System.out.println("Nuevo bloque en " + guateroad.Guateroad.tiempoB);
            blockchain.NuevoBloque();
            try {
                blockchain.Carpeta();
            } catch (JSONException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
            Convertir(guateroad.Guateroad.tiempoB);
        }
    }
    
    private void Convertir(int tiempo)
    {
        try {
            sleep(tiempo * 60000);
        } catch (InterruptedException e) {
            Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
            
}
