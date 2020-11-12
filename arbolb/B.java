/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jeany
 */
public class B {
    private int Contador = 0; 
    public NodoB Raiz; 
    private int Nivel = 1; 
    private int Imprimir = 1; 
    public static String dot = ""; 
    private static boolean soyRaiz;
    private int idViaje = 0; 
    private int idFact = 0; 
    
    public List<Persona> person = new ArrayList<>();
    public List<Viajes> viaje = new ArrayList<>();
    public List<Factura> fact = new ArrayList<>();
    
    
    public boolean vacio() {
        return Contador == 0; 
    }
    
    public B() {
        Raiz = new NodoB();
        soyRaiz = true;
        Contador++; 
    }
    
    private void Ordenar(int nums[]){
        int cant = 0;   //Para saber cuantos espacios tiene en uso el arreglo 
        for(int i = 0; i<nums.length; i++) {
            if (nums[i] != 0)  {
                cant ++; 
            }
            else {
                break; 
            }
        }
        for (int j= 0; j < cant -1 ; j++ ) {
            if(nums[j] > nums[j+1]) {
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp; 
            }
        }
    }
    
    private void Separar(NodoB actual) {
        NodoB HijoIzq = new NodoB(); 
        NodoB HijoDer = new NodoB(); 
        
        if(actual.hijos[0] != null) {
            for (int i = 0; i <= 5; i++) { //Es 5 porque el grado es 5 
                HijoIzq.hijos[i] = actual.hijos[i];
                HijoIzq.hijos[i].padre = HijoIzq; 
                actual.hijos[i] = null;
                HijoDer.hijos[i] = actual.hijos[6+i]; //Grado + 1 + i
                HijoDer.hijos[i].padre = HijoDer; 
                actual.hijos[6+i] = null;
            }
        }
        for (int i = 0; i < 5; i++) {
            HijoIzq.Val[i] = actual.Val[i];
            actual.Val[i] = 0; 
            HijoDer.Val[i] = actual.Val[6+i];
            actual.Val[6+i] = 0;
        }
        
        actual.Val[0] = actual.Val[5]; //5 por el grado 
        actual.Val[5] = 0;
        actual.hijos[0] = HijoIzq; 
        actual.hijos[0].padre = actual; 
        actual.hijos[1] = HijoDer;
        actual.hijos[1].padre = actual;
        //set de hijos 
        setHijos(Raiz);
        //Ordenar 
        ordenarNodos(actual);
        
        if (actual.padre!=null) { // luego del split y asignar los hijos (hijoIzq, hijoDer), subir el valor al padre
            boolean subir = false;
            for (int i = 0; i<actual.padre.Val.length && subir==false; i++) {
                if (actual.padre.Val[i] == 0) {
                    actual.padre.Val[i] = actual.Val[0];
                    subir = true;
                    actual.Val[0] = 0;
                    //ordenarNodos(HijoDer);
                    Ordenar(actual.padre.Val);
                }
            }
            int posHijos = 0;
            for (int i = 0; i<13 ; i++) {
                if (actual.padre.hijos[i] !=null) {
                    posHijos++;
                } else {
                    break;
                }
            }
            
            actual.padre.hijos[posHijos] = actual.hijos[0];
            actual.padre.hijos[posHijos+1] = actual.hijos[1];
            actual.padre.hijos[posHijos].padre = actual.padre;
            actual.padre.hijos[posHijos+1].padre = actual.padre;
            int aqui = 0;
            for (int i =0; i<2*5+3 && actual.padre.hijos[i]!=null; i++) {
                if (actual.padre.hijos[i].Val[0] == actual.Val[0]) {
                    aqui = i;
                    break;
                }
            }
            NodoB PadreB = actual.padre;
            actual = null;
            int j = aqui;
            while( (j<2*5+2) && (PadreB.hijos[j]!=null) && (PadreB.hijos[j+1]!=null)) {
                PadreB.hijos[j] = PadreB.hijos[j+1];
                j++;
            }
            PadreB.hijos[j] = null;
            Ordenar(PadreB.Val);
            ordenarNodos(PadreB);
            if (PadreB.Val[2*5]!=0) {
                Separar(PadreB);
            }
        }
    }
    
    private void ordenarNodos(NodoB ParaOrdenar){
       int i,j;
       i = 0;
       NodoB tmp;
       
       while(i < 13 && ParaOrdenar.hijos[i] != null){
           j = 0;
           while(j < 12  && ParaOrdenar.hijos[j] != null && ParaOrdenar.hijos[j+1] != null){
               if(ParaOrdenar.hijos[j].Val[0] > ParaOrdenar.hijos[j+1].Val[0] ){
                   tmp = ParaOrdenar.hijos[j];
                   ParaOrdenar.hijos[j] = ParaOrdenar.hijos[j+1];
                   ParaOrdenar.hijos[j+1] = tmp;
                }
                j++;
            }
            i++;
        }   
    }
    
    public void setHijos (NodoB actual) {
        if (actual == Raiz) {
            if (Raiz.hijos[0] != null) {
                Raiz.EsPadre = true;
            } 
        }
        for(int i = 0; i<actual.hijos.length; i++) {
            if (actual.hijos[i] != null) {
                actual.EsPadre = true;
                setHijos(actual.hijos[i]);
            }
        }
    }
    
    private void EncontrarValor(NodoB actual, int valor){
        int cont = 0;
        while(cont <= 2*5){
            if (actual.Val[cont]==0) { 
                actual.Val[cont]=valor;
                Ordenar(actual.Val);
                //Lista.ingresados.add(valor);
                if (cont == 2*5) {
                    Separar(actual);
                }
                break;
            }
            cont++;
        }
    }
    
    
    public String Recorrer(NodoB actual) {
        dot += "\n";
        for (int i =0; i<11; i++) {
            if (actual.hijos[i] != null) {
                if (i == 0) {
                    Nivel++;
                    System.out.println("hijos no nulos");
                    //imprimir = 1;
                } else {
                    //imprimir ++;
                }
                Recorrer(actual.hijos[i]);
            }
            dot += "[ ";
            for (int j = 0; actual.hijos[i]!=null && j<actual.hijos[i].Val.length; j++) {
                if (actual.hijos[i].Val[j] != 0) {
                    dot += actual.hijos[i].Val[j] + ", ";
                }
            }
            dot += " ]";
        }
        if (dot.length() > (2*5+3)*4) {
            //System.out.println (dot);
            return dot;
        }
        return dot;
    }
    
    public String Graficar() {
        String mostrar = Recorrer(Raiz);
        Nivel = 1;
        //imprimir = 1;
        return mostrar;
    }
    
    public int ObtenerId(String Usuario, String Pass)
    {
        for(int i = 0; i < person.size(); i++){
            if((person.get(i).getUsuario().equals(Usuario)) && (person.get(i).getPassword().equals(Pass))){
                return person.get(i).getId();
            }
        }
        return 0;
    }
    
    public int ConsultarId()
    {
        int id = 1; 
        for(int i = 0; i < person.size(); i++){
            if((id = person.get(i).getId()) == id){
                id++;
            }
            else
                return id;
        }
        return id; 
    }
    
    public String NombreP(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                return person.get(i).getNombre();
            }
        }
        return " ";
    }
    
    public void setNom(int id, String Nombre)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setNombre(Nombre);
            }
        }
    }
    
    public String UsuarioP(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                return person.get(i).getUsuario();
            }
        }
        return " ";
    }
    
    public void setUs(int id, String User)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setUsuario(User);
            }
        }
    }
    
    public String CorreoP(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                return person.get(i).getCorreo();
            }
        }
        return " ";
    }
    
    public void setCorreo(int id, String Correo)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setCorreo(Correo);
            }
        }
    }
    
    public String PassP(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                return person.get(i).getPassword();
            }
        }
        return " ";
    }
    
    public void setPass(int id, String Pass)
    {
        String NuevaPass = guateroad.Guateroad.fn.EncriptarSHA256(Pass);
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setPassword(NuevaPass);
            }
        }
    }
    
    public String TelefonoP(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                return person.get(i).getTelefono();
            }
        }
        return " ";
    }
    
    public void setTel(int id, String Telefono)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setTelefono(Telefono);
            }
        }
    }
    
    public void ModifDispo(int id, boolean dispo)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                person.get(i).setDisponible(dispo);
                
            }
        }
    }
    
    public boolean Buscar(int valor){
        boolean encontrado = false;
        for(int i = 0; i < person.size() && !encontrado; i++){
            if(person.get(i).getId() == valor){
                encontrado = true;
                return encontrado;
            }
        }
        return false;
    }
    
    public void AgregarHijo(NodoB Hijo, int valor, Persona nuevo) {
        boolean TieneHijos = false;
        if(Hijo != null && !Hijo.EsPadre){
            System.out.println("agregando un hijo ");
            EncontrarValor(Hijo, valor);
            TieneHijos = true;
        }
        for(int i = 0; Hijo != null && i < 2*5 + 1  && !TieneHijos; i++){
            if(valor < Hijo.Val[i] || Hijo.Val[i] == 0){
                TieneHijos = true;
                this.person.add(nuevo);
                AgregarHijo(Hijo.hijos[i], valor, nuevo);
                i = 2*5;
            }
        } 
    }
    
    public void AgregarEnB(int valor, Persona nuevo) {
        if(Raiz.EsPadre == false){
            int j = 0;  
            for(int i = 0; i < Raiz.Val.length; i++){
                if(Raiz.Val[i] == 0){
                    Raiz.Val[i] = valor; 
                    this.person.add(nuevo);
                    //guateroad.Guateroad.id = nuevo.getId();
                    j = i;
                    Ordenar(Raiz.Val);
                    break;
                }
            }
            if (j == 2*5) {
                Separar(Raiz);
            }
        } else {
            setHijos(Raiz);
            AgregarHijo(Raiz, valor, nuevo);
            
        }
    } 
    
    
    public void Eliminar(int valor) { //elimina de la lista el valor y vuelve a crear el arbol
        boolean encontrado = false;
        int j = 0;
        for (int i=0; i< person.size() && !encontrado; i++) {
            if(person.get(i).getId() == valor) {
                encontrado = true;
                j = i;
            }
        }
        if (encontrado==true) {
            person.remove(j);
        } else {
            System.out.println("El valor a eliminar no se encuentra en el arbol B");
        }
        List<Persona> personAux = person;
        person = new ArrayList<>();
        Raiz = new NodoB();
        Raiz.EsPadre = false; 
        for(int k = 0; k < personAux.size(); k++){
            Persona p = personAux.get(k);
            int id = p.getId();
            AgregarEnB(id, p);
        }
    }
    
    private int Ascci(String Nombre)
    {
        int num = 0; 
        for (char n : Nombre.toCharArray()) {
            num += (int)n;
        }
        return num;
    }
    
    public int InsertarViaje(String LugInicio, String LugFinal, String Fecha)
    {
        idViaje++;
        idViaje = IdViaje(idViaje);
        int inicio, fin; 
        inicio = Ascci(LugInicio); 
        fin = Ascci(LugFinal);
        Viajes v = new Viajes(idViaje, inicio, fin, Fecha);
        this.viaje.add(v);
        guateroad.Guateroad.blockchain.BloqueViaje.add(v);
        System.out.println("Nuevo Viaje" + idViaje + " " + Fecha);
        return idViaje;
    }
    
    public void InsertarViajeJson(int id, int Hinicio, int Hfin, String Fecha)
    {
        Viajes v = new Viajes(id, Hinicio, Hfin, Fecha);
        this.viaje.add(v);
    }
        
    private int IdViaje(int id)
    {
        for(int i = 0; i<viaje.size(); i++)
        {
            if(viaje.get(i).getIdViaje() == id)
            {
                id++;
            }
        }
        return id;
    }
    
    public double PagoAconductor(int id)
    {
        for(int i = 0; i < fact.size(); i++){
            if(fact.get(i).getIdConductor() == id)
            {
                return fact.get(i).getPrecio();
            }
        }
        return 0.0;
    }
    
    public String FechaPago(int id)
    {
        for(int i = 0; i < fact.size(); i++){
            if(fact.get(i).getIdConductor() == id)
            {
                return fact.get(i).getFecha();
            }
        }
        return "";
    }
    
    public int InsertarFact(int idUs, int idConduct, int idViaje, String Fecha, double precio)
    {
        idFact++;
        idFact = IdFact(idFact);
        Factura f = new Factura(idFact, idUs, idConduct, idViaje, Fecha, precio);
        System.out.println("Nueva factura "+idFact + idConduct +" Q"+precio);
        this.fact.add(f);
        guateroad.Guateroad.blockchain.BloqueFactura.add(f);
        return idFact;
    }
    
    public void InsertarFactJson(int id, int idUs, int IdConduct, int IdViaje, String Fecha, double precio)
    {
        Factura f = new Factura(id, idUs, IdConduct, IdViaje, Fecha, precio);
        this.fact.add(f);
    }
    
    private int IdFact(int id)
    {
        for(int i = 0; i<fact.size(); i++)
        {
            if(fact.get(i).getIdPago()== id)
            {
                id++;
            }
        }
        return id;
    }
    
    public void InsertarPersona(Persona p)
    {
       this.person.add(p);
    }
    
    public void BorrarPersona(int id)
    {
        for(int i = 0; i < person.size(); i++){
            if(person.get(i).getId() == id){
                this.person.remove(i);
            }
        }
    }
}
