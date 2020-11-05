/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Jeany
 */
public class ListaGrafo {
    public List<DatosGrafo> grafo = new ArrayList<>();
    private int matriz[][];
    private double precios[][];
    private hash.Lugares SoloLug[];
    
    public void Insertar(DatosGrafo graf)
    {
        this.grafo.add(graf);
        guateroad.Guateroad.blockchain.BloqueGrafo.add(graf);
    }
    
    private double Precio(String inicio, String fin)
    {
        double P = 0.0;
        for(int i = 0; i < grafo.size(); i++)
        {
            if(grafo.get(i).getInicio().equals(inicio))
            {
                if(grafo.get(i).getFin().equals(fin))
                {
                    P = grafo.get(i).getPrecio();
                    return P;
                }
            }
        }
        return P; 
    }
    
    private int Peso (String inicio, String fin)
    {
        int P = 0;
        for(int i = 0; i < grafo.size(); i++)
        {
            if(grafo.get(i).getInicio().equals(inicio))
            {
                if(grafo.get(i).getFin().equals(fin))
                {
                    P = grafo.get(i).getPeso();
                    return P;
                }
            }
        }
        return P; 
    }
    
    private int NumLug()
    {
        int cant = guateroad.Guateroad.HashT.cantTotal();
        int cont=0;
        for(int i = 0; i < cant; i++)
        {
            if (guateroad.Guateroad.HashT.Categoria(i).equals("vacio"))
            {
                //System.out.println(guateroad.Guateroad.HashT.Categoria(i));
            }
            else 
            {
                cont++;
            }
        }
        return cont;
    }
    
    private void LlenarList()
    {
        SoloLug = new hash.Lugares[NumLug()];
        int cant = guateroad.Guateroad.HashT.cantTotal();
        int cont=0;
        String Categoria, Nombre; 
        double lat, lon;
        for(int i = 0; i < cant; i++)
        {
            if (guateroad.Guateroad.HashT.Categoria(i).equals("vacio"))
            {
                //System.out.println(guateroad.Guateroad.HashT.Categoria(i));
            }
            else 
            {
                Categoria = guateroad.Guateroad.HashT.Categoria(i);
                Nombre = guateroad.Guateroad.HashT.Nombre(i);
                lat = guateroad.Guateroad.HashT.LatLugar(Nombre);
                lon = guateroad.Guateroad.HashT.LongLugar(Nombre);
                System.out.println(guateroad.Guateroad.HashT.Nombre(i));
                SoloLug[cont] = new hash.Lugares(cont, Categoria, Nombre, lat, lon);
                //SoloLug[cont] = new hash.Lugares(cont, guateroad.Guateroad.HashT.Categoria(i), guateroad.Guateroad.HashT.Nombre(i), guateroad.Guateroad.HashT.LatLugar(guateroad.Guateroad.HashT.Nombre(i)), guateroad.Guateroad.HashT.LongLugar(guateroad.Guateroad.HashT.Nombre(i)));
                cont++;
            }
        }
    }
    
    private void Adyacencia()
    {
        String NomInicio, NomFinal; 
        LlenarList();
        int cant = SoloLug.length;
        //Tamaño segun la cantidad de lugares que tengo 
        matriz = new int[cant][cant];
        precios = new double[cant][cant];
        //Voy a llenar todo lo que tengo de info con respecto al lugar 0, 1 y así los demás serán 0
        for(int i = 0; i < cant; i++)
        {
            //Primero voy a llenar todas las que tengan fila 0 entonces [i][j] 
            NomInicio = SoloLug[i].getNombre();
            for(int j = 0; j< cant; j++)
            {
                NomFinal = SoloLug[j].getNombre();
                matriz[i][j] = Peso(NomInicio, NomFinal);
                precios[i][j] = Precio(NomInicio, NomFinal);
            }
        }
    }
    
    private int Posicion(String nombre)
    {
        int pos = -1;
        for(int i = 0; i< SoloLug.length; i++)
        {
            if(SoloLug[i].getNombre().equals(nombre))
                return i;
        }
        return pos;
    }
    
    public double Dijkstra(String Inicio, String Fin)
    {
        double Total = 0.0;
        Adyacencia();
        int[] distancia = new int[matriz.length]; 
        int[] recorrido = new int[matriz.length]; 
        double[] precio = new double[matriz.length]; 
        boolean[] visitado = new boolean[matriz.length];
        int contador, distM; 
        int pos = Posicion(Inicio);
        int fin = Posicion(Fin);
        if(pos == -1)
            System.out.println("Lugar de inicio no encontrado");
        
        for(int i = 0; i<matriz.length; i++)
        {
            distancia[i] = 9999;
            visitado[i] = false; 
            precio[i] = 0.0;
        }
        distancia[pos] = 0;
        recorrido[pos] = -1;
        
        for(int i = 0; i<matriz.length; i++)
        {
            contador = 0; 
            distM = 9999;
            for(int j = 0; j<matriz.length; j++)
            {
                if((!visitado[j]) && (distancia[j]<distM))
                {
                    distM = distancia[j];
                    contador = j; 
                }
            }
            visitado[contador] = true; 
            
            for(int k = 0; k<matriz.length; k++)
            {
                if((!visitado[k]) && ((matriz[contador][k] + distancia[contador]) < distancia[k]) && (distancia[contador] != 9999))
                {
                    distancia[k] = distancia[contador] + matriz[contador][k];
                    precio[k] = precio[contador] + precios[contador][k];
                    recorrido[k] = contador;
                }
            }
        }
        System.out.println("Nodo \t Dist \t Precio \t Camino");
        for(int g= 0; g<matriz.length; g++)
        {
            if(g == fin){
                Total = precio[g];
                System.out.println(g + "\t" + distancia[g] + "\t" + precio[g] + "\t \t" + recorrido[g] );
                return Total;
            }                
        }
        return Total;
    }
    
}
