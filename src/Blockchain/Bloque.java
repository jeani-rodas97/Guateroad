/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockchain;

import arbolb.Factura;
import arbolb.Persona;
import arbolb.Viajes;
import grafo.DatosGrafo;
import guateroad.Localidad;
import hash.Lugares;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Jeany
 */
public class Bloque {
    
    private int indice = 0;
    public JSONObject ArchJson = new JSONObject(); 
    
    public List<Persona> BloquePersona = new ArrayList<>();
    public List<Viajes> BloqueViaje = new ArrayList<>();
    public List<Factura> BloqueFactura = new ArrayList<>();
    public List<Localidad> BloqueLocalidad = new ArrayList<>();
    public List<DatosGrafo> BloqueGrafo = new ArrayList<>();
    public List<Lugares> BloqueLugar = new ArrayList<>();
    
    private String Fecha()
    {
        String Fecha, FormatoFecha;
        Date fechita = new Date();
        FormatoFecha = "dd-MM-yy::hh:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(FormatoFecha);
        Fecha = format.format(fechita);
        return Fecha; 
    }
    
    private String DocFecha()
    {
        String Fecha, FormatoFecha;
        Date fechita = new Date();
        FormatoFecha = "hh.mm.ss dd-MM-yy";
        SimpleDateFormat format = new SimpleDateFormat(FormatoFecha);
        Fecha = format.format(fechita);
        return Fecha; 
    }
    
    private void CrearJson() throws JSONException
    {
        if(BloqueFactura.isEmpty() && BloqueGrafo.isEmpty() && BloqueLocalidad.isEmpty() && BloqueLugar.isEmpty() && BloquePersona.isEmpty() && BloqueViaje.isEmpty())
        {
            System.out.println("No hay nada que guardar");
        }
        if(!BloquePersona.isEmpty())
            ArchJson.put("usuarios", Personas());
    }
    
    private JSONArray Personas() throws JSONException
    {
        JSONArray ListaPersonas = new JSONArray();
        
        for(int i = 0; i < BloquePersona.size(); i++)
        {
            JSONObject Bpersonas = new JSONObject();
            Bpersonas.put("id", new Integer(BloquePersona.get(i).getId()));
            Bpersonas.put("nombre", BloquePersona.get(i).getNombre());
            Bpersonas.put("usuario", BloquePersona.get(i).getUsuario());
            Bpersonas.put("correo", BloquePersona.get(i).getCorreo());
            Bpersonas.put("pass", BloquePersona.get(i).getPassword());
            Bpersonas.put("telefono", BloquePersona.get(i).getTelefono());
            Bpersonas.put("rol", BloquePersona.get(i).getRol());
            ListaPersonas.put(Bpersonas);
        }
        return ListaPersonas;
    }
    
    public void NuevoBloque(String Previo)
    {
        String CadenaJson = ArchJson.toString();
        String Fecha = Fecha();
        String Hash, actual;
        int Nonce = 0;
        Hash = indice+Fecha+Previo+CadenaJson+Nonce; 
        actual = guateroad.Guateroad.fn.EncriptarSHA256(Hash);
        char[] c = actual.toCharArray();
        while((c[0] != '0') || (c[1] != '0') || (c[2] != '0') || (c[3] != '0'))
        {
            Nonce++;
            Hash = indice+Fecha+Previo+CadenaJson+Nonce; 
            actual = guateroad.Guateroad.fn.EncriptarSHA256(Hash);
            c = actual.toCharArray();
        }
        indice++;
        System.out.println("Nonce "+Nonce+" HashActual "+actual);
    }
    
    public void Carpeta() throws JSONException
    {
        CrearJson();
        String CadenaJson = ArchJson.toString();
        File Carpeta = new File("Bloques");
        if(!Carpeta.exists())
            Carpeta.mkdirs();
        
        try{
            File arch = new File(".\\Bloques\\"+DocFecha()+".txt");
            if(!arch.exists())
                arch.createNewFile();
            
            FileWriter escribir = new FileWriter(arch);
            BufferedWriter buffer = new BufferedWriter(escribir);
            buffer.write(CadenaJson);
            buffer.close();
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
