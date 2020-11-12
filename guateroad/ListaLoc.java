/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeany
 */
public class ListaLoc {
    public List<Localidad> localidad = new ArrayList<>();
    
    public void Insertar(Localidad loc)
    {
        this.localidad.add(loc);
    }
    
    public String NombreLugar(int idUs)
    {
        String Nombre = "vacio"; 
        for (int i = 0; i < localidad.size(); i++)
        {
            if(localidad.get(i).getIdUs() == idUs)
            {
                Nombre = localidad.get(i).getLugar();
                return Nombre;
            }
        }
        return Nombre;
    }
    
    public void CambiarDispo(int idConduct, boolean dispo)
    {
        for (int i = 0; i < localidad.size(); i++)
        {
            if(localidad.get(i).getIdUs() == idConduct)
            {
                localidad.get(i).setDispo(dispo);
            }
        }
    }
    
}
