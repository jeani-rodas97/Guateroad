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
public class Guateroad {

    
    public static arbolb.B ArbolUsuario = new arbolb.B();
    public static arbolb.B ArbolConductor = new arbolb.B();
    public static arbolb.B ArbolViajes = new arbolb.B();
    public static arbolb.B ArbolFacturas = new arbolb.B();
    public static hash.TablaHash HashT = new hash.TablaHash(10, 30, 75);
    public static Funcion fn = new Funcion();
    public static ListaLoc LocUsuario = new ListaLoc();
    public static ListaLoc LocConductor = new ListaLoc();
    public static grafo.ListaGrafo grafos = new grafo.ListaGrafo();
    public static GoogleMaps MapaGoogle = new GoogleMaps();
    public static int id, tiempoB = 5; 
    public static String contraseña;
    public static arbolb.arbol bUsuario = new arbolb.arbol();
    public static arbolb.arbol bConductor = new arbolb.arbol();
    public static arbolb.arbol bViajes = new arbolb.arbol();
    public static arbolb.arbol bFacturas = new arbolb.arbol();
    public static Blockchain.Bloque blockchain = new Blockchain.Bloque();
    //tiempoB es timepo bloque 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Blockchain.Tiempo bloqueTiempo = new Blockchain.Tiempo();
        bloqueTiempo.start();
        Login lg = new Login();
        lg.setVisible(true);
    }
    
}
