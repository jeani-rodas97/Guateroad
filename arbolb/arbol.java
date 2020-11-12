/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

import java.util.ArrayList;

/**
 *
 * @author Jeany
 */
public class arbol {
    
    nodo Raiz; 
    int cont=0;
    ArrayList<Integer> idNodo = new ArrayList();
    private String dotArbol = "digraph arbolB {\n" +
    "  concentrate=True;\n" +
    "  rankdir=TB;\n" +
    "  node [shape=record color=\"#8EB9AE\" style=filled fillcolor=\"#FFD9D9\"]; \n"; 
   
    
    public arbol()
    {
        Raiz = new nodo(null);
    }
    
    public void Insertar(int id)
    {
        Raiz = Agregar(id, Raiz);
    }
    
    private nodo Agregar(int id, nodo aux)
    {
        if(aux.esHoja){
            aux.insertarN(id);
        }
        else {
            boolean encontrado = false;
            for(int i = 0; i < aux.n-1; i++)
            {
                if(id < aux.ids[i]){
                    encontrado = true; 
                    Agregar(id, aux.hijo[i]);
                    break;
                }
            }
            if(!encontrado){
                Agregar(id, aux.hijo[aux.n]);
            }
        }
        
        if(aux.n == 5){
            if(aux.padre == null){
                nodo split = aux; 
                aux = new nodo(null);
                aux.insertarN(split.ids[5/2]);
                aux.hijo[0] = new nodo(aux);
                aux.hijo[1] = new nodo(aux);
                for(int i = 0; i<5/2; i++){
                    aux.hijo[0].insertarN(split.ids[i]);
                }
                for(int i=5/2+1; i< 5; i++){
                    aux.hijo[1].insertarN(split.ids[i]);
                }
                aux.esHoja = false;
            }
            else {
                int AuxId = aux.ids[5/2];
                aux.padre.insertarN(AuxId);
                int num; 
                for(num = 0; num<aux.padre.n; num++){
                    if(aux.padre.ids[num] == AuxId){
                        break;
                    }
                }
                for(int i = aux.padre.n; i > num+1; i--){
                    aux.padre.hijo[i] = aux.padre.hijo[i-1];
                }
                aux.padre.hijo[num+1] = new nodo(aux.padre);
                for(int i = 5/2+1; i<5; i++){
                    aux.padre.hijo[num+1].insertarN(aux.ids[i]);
                }
                nodo nuevoAux = aux; 
                aux.padre.hijo[num] = new nodo(aux.padre);
                for(int i =0; i<5/2; i++){
                    aux.padre.hijo[num].insertarN(nuevoAux.ids[i]);
                }
            }
        }
        return aux; 
    }
    
    public String Graficar()
    {
        Graficando(Raiz, 0, 0);
        for(int i = 0; i<idNodo.size()-2; i+=2){
            flechas(i);
        }
        flechas(0);
        dotArbol += " \n }";
        return dotArbol;
    }
    
    private void Graficando(nodo aux, int nivel, int rama)
    {
        this.idNodo.add(nivel);
        this.idNodo.add(rama);
        dotArbol += nivel+""+rama; 
        dotArbol += aux.GraficarNodo();
        for(int i = 0; i<5; i++)
        {
            if(aux.hijo[i] != null)
            {
                rama++;
                Graficando(aux.hijo[i], nivel+1, rama);
            }
        }
    }
    
    private void flechas(int levelAct)
    {    
        for(int i = 2; i<idNodo.size(); i+=2)           
        {
            
            if((idNodo.get(i) - idNodo.get(levelAct)) == 1){
                dotArbol += "\n"+idNodo.get(levelAct)+""+idNodo.get(levelAct+1)+"-> ";
                dotArbol+= idNodo.get(i)+ ""+ idNodo.get(i+1);
            }
        }
        
    }
}
