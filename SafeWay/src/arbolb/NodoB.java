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
public class NodoB {
    public int []Val;
    public NodoB []hijos; 
    public static int num; 
    public boolean EsPadre;
    public int EnUso; 
    public int grado; 
    public NodoB padre; 
    
    public NodoB()
    {
        Val = new int [13];
        hijos = new NodoB[11];
    }
    
}
