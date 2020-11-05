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
public class nodo {
    boolean esHoja = true;
    int n = 0;
    int[] ids = new int[5];
    nodo[] hijo = new nodo[5];
    nodo padre;
    
    public nodo(nodo padre)
    {
        this.padre = padre;
    }
    
    public void insertarN(int id)
    {
        this.ids[n++] = id;
        if(n>1)
            ordenar();
    }
    
    private void ordenar()
    {
        int aux;
        for(int i = 0; i<n-1; i++)
        {
            for(int j= i+1; j<n; j++)
            {
                if(ids[i] > ids[j])
                {
                    aux = ids[i];
                    ids[i] = ids[j];
                    ids[j] = aux;
                }
            }
        }
    }
    
    public String GraficarNodo()
    {
        String dot = "[label= \""; 
        dot += ids[0];
        for (int i = 1; i< n; i++)
        {
            dot += "|"+ids[i];
        }
        dot+="\"]; \n";
        return dot; 
    }
}
