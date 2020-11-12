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
public class TablaHash {
    private int Ocupado;
    private int CantTotal;
    private int Minimo;
    private int Maximo;
    private Lugares[] lugar;
    
    public TablaHash(int CantTotal, int Minimo, int Maximo)
    {
        this.CantTotal = CantTotal;
        this.Minimo = Minimo; 
        this.Maximo = Maximo; 
        IniciarTabla();
    }
    
    public int cantTotal()
    {
        return this.CantTotal;
    }
    
    public String Categoria(int i)
    {
        if(lugar[i].getId() == -1)
        {
            return "vacio";
        }
        return lugar[i].getCategoria();
    }
    
    public String Nombre(int i)
    {
        if(lugar[i].getId() == -1)
        {
            return "vacio";
        }
        return lugar[i].getNombre();
    }
    
    public String ObtenerDot()
    {
        String dot = "";
        for(int i = 0; i < lugar.length; i++)
        {
            if(lugar[i].getId() != -1)
            {
                dot += "        <tr><td>" + i +"</td><td>"+ Ascci(lugar[i].getNombre()) +"</td><td>"+ lugar[i].getNombre() +"</td></tr>\n";
            }
            else
            {
                dot+= "        <tr><td>"+i+"</td><td> </td><td> </td></tr>\n";
            }
        }
        return dot; 
    }
    
    private void IniciarTabla()
    {
        Lugares lug = new Lugares(-1, "vacio", "vacio", 0.0 ,0.0);
        Ocupado = 0;
        lugar = new Lugares[CantTotal];
        for(int i = 0; i<CantTotal; i++) {
            lugar[i] = lug;
        }
    }
    
    private int division(int k)
    {
        return (k % CantTotal);
    }
    
    private int lineal(int k)
    {
        return ((k+1)%CantTotal);
    }
    
    public void Nuevo(Lugares lugarJ)
    {
        int id, i; 
        id = Ascci(lugarJ.getNombre());
        System.out.println(id);
        i = division(id);
        System.out.println(i);
        while(lugar[i].getId() != -1)
        {
            i = lineal(i);
        }
        lugar[i] = new Lugares(lugarJ.getId(), lugarJ.getCategoria(), lugarJ.getNombre(), lugarJ.getLatitud(), lugarJ.getLongitud());
        guateroad.Guateroad.blockchain.BloqueLugar.add(lugarJ);
        Ocupado++;
        Redimensionar();
    }
    
    private int Ascci(String Nombre)
    {
        int num = 0; 
        for (char n : Nombre.toCharArray()) {
            num += (int)n;
        }
        return num;
    }
    
    private void Redimensionar()
    {
        int CantInicial = CantTotal; 
        if((Ocupado*100/CantTotal) >= Maximo)
        {
            Lugares[] TempLug;
            TempLug = lugar;
            CantTotal = (Ocupado*100/Minimo);
            IniciarTabla();
            for (int i = 0; i < CantInicial; i++)
            {
                if(TempLug[i].getId() != -1)
                {
                    Nuevo(TempLug[i]);
                }
            }
        }
        else 
        {
            System.out.println("No es necesario rehashing");
        }
    }
    
    public double LatLugar(String NombreLug)
    {
        double lat = 0.0;
        for(int i = 0; i < lugar.length; i++)
        {
            if(lugar[i].getNombre().equals(NombreLug))
            {
                lat = lugar[i].getLatitud();
                return lat;
            }
        }
        return lat;
    }
    
    public double LongLugar(String NombreLug)
    {
        double longi = 0.0;
        for(int i = 0; i < lugar.length; i++)
        {
            if(lugar[i].getNombre().equals(NombreLug))
            {
                longi = lugar[i].getLongitud();
                return longi;
            }
        }
        return longi;
    }
    
    
}

