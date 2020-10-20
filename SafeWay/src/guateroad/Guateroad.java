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
    public static hash.TablaHash HashT = new hash.TablaHash(10, 30, 75);
    public static int id; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login lg = new Login();
        lg.setVisible(true);
    }
    
}
