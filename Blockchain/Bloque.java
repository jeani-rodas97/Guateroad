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
import guateroad.Guateroad;
import guateroad.Localidad;
import hash.Lugares;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.zip.Deflater;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author Jeany
 */
public class Bloque {
    
    private int indice = 0;
    public String HashPrevio = "0000", CadenaJson;
    public JSONObject ArchJson = new JSONObject(); 
    
    public List<Persona> BloquePersona = new ArrayList<>();
    public List<Viajes> BloqueViaje = new ArrayList<>();
    public List<Factura> BloqueFactura = new ArrayList<>();
    public List<Localidad> BloqueLocUs = new ArrayList<>();
    public List<Localidad> BloqueLocCdt = new ArrayList<>();
    public List<DatosGrafo> BloqueGrafo = new ArrayList<>();
    public List<Lugares> BloqueLugar = new ArrayList<>();
    private String  ENCRYPT_KEY="0123456789abcdef";
    
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
        if(BloqueFactura.isEmpty() && BloqueGrafo.isEmpty() && BloqueLocUs.isEmpty() && BloqueLocCdt.isEmpty() && BloqueLugar.isEmpty() && BloquePersona.isEmpty() && BloqueViaje.isEmpty())
        {
            System.out.println("No hay nada que guardar");
        }
        if(!BloquePersona.isEmpty())
            ArchJson.put("usuarios", Personas());
        if(!BloqueLugar.isEmpty())
            ArchJson.put("Lugares", Lugares());
        if(!BloqueGrafo.isEmpty())
            ArchJson.put("Grafo", Grafos());
        if(!BloqueLocCdt.isEmpty())
            ArchJson.put("localidades", Localidades());
        if(!BloqueViaje.isEmpty())
            ArchJson.put("Viajes", Viajes());
        if(!BloqueFactura.isEmpty())
            ArchJson.put("Facturas", Facturas());
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
    
    private JSONArray Lugares() throws JSONException
    {
        JSONArray ListaLugares = new JSONArray();
        
        for(int i = 0; i < BloqueLugar.size(); i++)
        {
            JSONObject BLugares = new JSONObject();
            BLugares.put("id", new Integer(BloqueLugar.get(i).getId()));
            BLugares.put("Nombre", BloqueLugar.get(i).getNombre());
            BLugares.put("Categoria", BloqueLugar.get(i).getCategoria());
            BLugares.put("Lat", new Double(BloqueLugar.get(i).getLatitud()));
            BLugares.put("Lon", new Double(BloqueLugar.get(i).getLongitud()));
            ListaLugares.put(BLugares);
        }
        return ListaLugares;
    }
    
    private JSONArray Facturas() throws JSONException
    {
        JSONArray ListaFacturas = new JSONArray();
        
        for(int i = 0; i < BloqueFactura.size(); i++)
        {
            JSONObject BFacts = new JSONObject();
            BFacts.put("idPago", new Integer(BloqueFactura.get(i).getIdPago()));
            BFacts.put("idUs", new Integer(BloqueFactura.get(i).getIdUs()));
            BFacts.put("idConductor", new Integer(BloqueFactura.get(i).getIdConductor())); 
            BFacts.put("idViaje", new Integer(BloqueFactura.get(i).getIdViaje()));
            BFacts.put("Fecha", BloqueFactura.get(i).getFecha());
            BFacts.put("Precio", new Double(BloqueFactura.get(i).getPrecio()));
            ListaFacturas.put(BFacts);
        }
        return ListaFacturas;
    }
    
    private JSONArray Viajes() throws JSONException
    {
        JSONArray ListaViajes = new JSONArray();
        
        for(int i = 0; i < BloqueViaje.size(); i++)
        {
            JSONObject BLugares = new JSONObject();
            BLugares.put("idViaje", new Integer(BloqueViaje.get(i).getIdViaje()));
            BLugares.put("HashInicio", new Integer(BloqueViaje.get(i).getHashInicio()));
            BLugares.put("HashFin", new Integer(BloqueViaje.get(i).getHashFin()));
            BLugares.put("Fecha", BloqueViaje.get(i).getFecha());
            ListaViajes.put(BLugares);
        }
        return ListaViajes;
    }
    
    private JSONArray Grafos() throws JSONException
    {
        JSONArray LitasGrafos = new JSONArray();
        
        for(int i = 0; i < BloqueGrafo.size(); i++)
        {
            JSONObject BGrafos = new JSONObject();
            BGrafos.put("inicio", BloqueGrafo.get(i).getInicio());
            BGrafos.put("final", BloqueGrafo.get(i).getFin());
            BGrafos.put("peso", new Integer(BloqueGrafo.get(i).getPeso()));
            BGrafos.put("unidad", BloqueGrafo.get(i).getUnidad());
            BGrafos.put("precio", new Double(BloqueGrafo.get(i).getPrecio()));
            BGrafos.put("moneda", BloqueGrafo.get(i).getMoneda());
            LitasGrafos.put(BGrafos);
        }
        return LitasGrafos;
    }
    
    private JSONArray Localidades() throws JSONException
    {
        JSONArray ListaLocalidadesUs = new JSONArray();
        
        for(int i = 0; i < BloqueLocUs.size(); i++)
        {
            JSONObject BLocalidades = new JSONObject();
            BLocalidades.put("id_usuario", new Integer(BloqueLocUs.get(i).getIdUs()));
            BLocalidades.put("nombre", BloqueLocUs.get(i).getLugar());
            ListaLocalidadesUs.put(BLocalidades);
        }
        
        for(int i = 0; i < BloqueLocCdt.size(); i++)
        {
            JSONObject BLocalidades = new JSONObject();
            BLocalidades.put("id_conductor", new Integer(BloqueLocCdt.get(i).getIdUs()));
            BLocalidades.put("lugar", BloqueLocCdt.get(i).getLugar());
            BLocalidades.put("disponibilidad", BloqueLocCdt.get(i).isDispo());
            ListaLocalidadesUs.put(BLocalidades);
        }
        
        return ListaLocalidadesUs;
    }
    
    public void NuevoBloque()
    {
        CadenaJson = ArchJson.toString();
        String Fecha = Fecha();
        String Hash, actual;
        int Nonce = 0;
        Hash = indice+Fecha+HashPrevio+CadenaJson+Nonce; 
        actual = guateroad.Guateroad.fn.EncriptarSHA256(Hash);
        char[] c = actual.toCharArray();
        while((c[0] != '0') || (c[1] != '0') || (c[2] != '0') || (c[3] != '0'))
        {
            Nonce++;
            Hash = indice+Fecha+HashPrevio+CadenaJson+Nonce; 
            actual = guateroad.Guateroad.fn.EncriptarSHA256(Hash);
            c = actual.toCharArray();
        }
        indice++;
        System.out.println("Nonce "+Nonce+" HashActual "+actual);
        HashPrevio = actual;
    }
    
    public void Carpeta() throws JSONException, Exception
    {
        CrearJson();
        CadenaJson = ArchJson.toString();
        //Comprimir(CadenaJson);
        File Carpeta = new File("Bloques");
        if(!Carpeta.exists())
            Carpeta.mkdirs();
        
        if(!CadenaJson.equals("{}"))
        {
            try{
                File arch = new File(".\\Bloques\\"+DocFecha()+".txt");
                if(!arch.exists())
                    arch.createNewFile();

                FileWriter escribir = new FileWriter(arch);
                BufferedWriter buffer = new BufferedWriter(escribir);
                buffer.write(Encriptar(CadenaJson));
                buffer.close();

            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        LimpiarListas();
    }
    
    public void LeerBloques()
    {
        
        File carpeta = new File("C:\\Users\\Jeany\\Documents\\NetBeansProjects\\SafeWay\\Bloques");
        if(!carpeta.exists())
            return;
        File[] Archivos = carpeta.listFiles();
        
        for(int f=0; f<Archivos.length; f++)
        {
            String Json = "";
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject();
            LeerCadaArch(Archivos[f], jsn, obj);
            
        }
    }
    
    private void Comprimir(String cadena)
    {
        Deflater def = new Deflater();
        byte[] datos = cadena.getBytes();
        byte[] salida = new byte[128];
        def.setInput(datos);
        def.finish();
        int contador = def.deflate(salida);
        System.out.println(def.toString() + "nuevo tamaño "+contador);
        def.end();
    }
    
    private String Encriptar(String datos) throws Exception {  
        Key llave = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES"); 
        Cipher cifrado = Cipher.getInstance("AES");
        cifrado.init(Cipher.ENCRYPT_MODE, llave);

        byte[] encriptado = cifrado.doFinal(datos.getBytes());

        byte[] encodedBytes = Base64.getEncoder().encode(encriptado);

        return new String(encodedBytes);
    }
 
    private String Desencriptar(String encriptado) throws Exception {
        byte[] encryptedBytes=Base64.getDecoder().decode(encriptado.replace("\n", "") );

        Key llave = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, llave  );

        String decrypted = new String(cipher.doFinal(encryptedBytes));

        return decrypted;
    }
    
    private void LeerCadaArch(File arch, JSONTokener jsn, JSONObject obj)
    {
        String nombre, usuario, correo, pass, tel, rol, pss, Categoria, Nombre, inicio, fin, unidad, moneda, Lugar, LugarC, Fecha; 
        int idJ, id, peso, idUsuario, idConductor, idViaje, HashInicio, HashFin, idPago, idUs, idCtor, idViaj;   
        boolean disponible;
        double Lat, Lon, precio;
        try {
                FileReader leer = new FileReader(arch);
                System.out.println("Leyendo " + arch.getName());
                BufferedReader buffer = new BufferedReader(leer);
                String linea = "";
                String Json = ""; 
                while((linea = buffer.readLine()) != null){
                    Json += linea + "\n"; 
                }
                String JsonDesencriptado = Desencriptar(Json);
                leer.close();
                buffer.close();
                //System.out.println(Json);
                jsn = new JSONTokener(JsonDesencriptado); 
                obj = new JSONObject(jsn);
                
                if(obj.has("usuarios"))
                {
                    JSONArray docJsonUs = (JSONArray) obj.get("usuarios");
                    System.out.println(docJsonUs.toString());
                    for(int i = 0; i < docJsonUs.length(); i++)
                    {
                        JSONObject user = (JSONObject)docJsonUs.get(i);
                        idJ = Integer.parseInt(user.get("id").toString());
                        nombre = user.get("nombre").toString();
                        usuario = user.get("usuario").toString();
                        correo = user.get("correo").toString();
                        pss = user.get("pass").toString();
                        pass = Guateroad.fn.EncriptarSHA256(pss);
                        //Guateroad.contraseña = user.get("pass").toString();
                        tel = user.get("telefono").toString();
                        rol = user.get("rol").toString();
                        arbolb.Persona NuevoUser = new Persona(idJ, nombre, usuario, rol, pss, correo, tel, true);
                        guateroad.Guateroad.blockchain.BloquePersona.add(NuevoUser);
                        if(rol.equals("conductor")) {
                            //Guateroad.ArbolConductor.AgregarEnB(idJ, NuevoUser);
                            guateroad.Guateroad.ArbolConductor.InsertarPersona(NuevoUser);
                            guateroad.Guateroad.bConductor.Insertar(idJ);
                            //System.out.println("Conductor agregado al arbol");
                        }

                        if(rol.equals("normal")) {
                            //Guateroad.ArbolUsuario.AgregarEnB(idJ, NuevoUser);
                            guateroad.Guateroad.ArbolUsuario.InsertarPersona(NuevoUser);
                            guateroad.Guateroad.bUsuario.Insertar(idJ);
                            //System.out.println("Usuario agregado al arbol");
                        }
                        //System.out.println("Usuarios encontrados y agregados");
                    }
                }
                
                if(obj.has("Lugares"))
                {
                    JSONArray docJsonLg = (JSONArray) obj.get("Lugares");
                    System.out.println(docJsonLg.toString());
                    for(int i = 0; i < docJsonLg.length(); i++)
                    {
                        JSONObject lug = (JSONObject)docJsonLg.get(i);
                        id = Integer.parseInt(lug.get("id").toString());
                        Categoria = lug.get("Categoria").toString();
                        Nombre = lug.get("Nombre").toString();
                        Lat = Double.parseDouble(lug.get("Lat").toString());
                        Lon = Double.parseDouble(lug.get("Lon").toString());
                        hash.Lugares lg = new Lugares(id, Categoria, Nombre, Lat, Lon);
                        Guateroad.HashT.Nuevo(lg);

                        //System.out.println("Lugares encontrados y agregados");
                    }
                }
                
                if(obj.has("Grafo"))
                {
                    JSONArray docJsonGraf = (JSONArray) obj.get("Grafo");
                    System.out.println(docJsonGraf.toString());
                    for(int i = 0; i < docJsonGraf.length(); i++)
                    {
                        JSONObject grafoJ = (JSONObject)docJsonGraf.get(i);
                        inicio = grafoJ.get("inicio").toString();
                        fin = grafoJ.get("final").toString();
                        peso = Integer.parseInt(grafoJ.get("peso").toString());
                        unidad = grafoJ.get("unidad").toString();
                        precio = Double.parseDouble(grafoJ.get("precio").toString());
                        moneda = grafoJ.get("moneda").toString();

                        grafo.DatosGrafo DGraf = new DatosGrafo(inicio, fin, unidad, moneda, peso, precio);
                        Guateroad.grafos.Insertar(DGraf);

                        //System.out.println("Grafos encontrados y agregados");
                    }
                }
                
                if(obj.has("Viajes"))
                {
                    JSONArray docJsonViaje = (JSONArray) obj.get("Viajes");
                    System.out.println(docJsonViaje.toString());
                    for(int i = 0; i < docJsonViaje.length(); i++)
                    {
                        JSONObject viajeJ = (JSONObject)docJsonViaje.get(i);
                        idViaje = Integer.parseInt(viajeJ.get("idViaje").toString());
                        HashInicio = Integer.parseInt(viajeJ.get("HashInicio").toString());
                        HashFin = Integer.parseInt(viajeJ.get("HashFin").toString());
                        Fecha = viajeJ.get("Fecha").toString();
                        
                        guateroad.Guateroad.ArbolViajes.InsertarViajeJson(idViaje, HashInicio, HashFin, Fecha);
                        guateroad.Guateroad.bViajes.Insertar(idViaje);
                    }
                }
                
                if(obj.has("Facturas"))
                {
                    JSONArray docJsonFacts = (JSONArray) obj.get("Facturas");
                    System.out.println(docJsonFacts.toString());
                    for(int i = 0; i < docJsonFacts.length(); i++)
                    {
                        JSONObject factsJ = (JSONObject)docJsonFacts.get(i);
                        idPago = Integer.parseInt(factsJ.get("idPago").toString());
                        idUs = Integer.parseInt(factsJ.get("idUs").toString());
                        idCtor = Integer.parseInt(factsJ.get("idConductor").toString());
                        idViaj = Integer.parseInt(factsJ.get("idViaje").toString());
                        Fecha = factsJ.get("Fecha").toString();
                        precio = Double.parseDouble(factsJ.get("Precio").toString());

                        Guateroad.ArbolFacturas.InsertarFactJson(idPago, idUs, idCtor, idViaj, Fecha, precio);
                        Guateroad.bFacturas.Insertar(idPago);
                    }
                }
                
                if(obj.has("localidades"))
                {
                    JSONArray docJsonLoc = (JSONArray) obj.get("localidades");
                    System.out.println(docJsonLoc.toString());
                    for(int i = 0; i < docJsonLoc.length(); i++)
                    {
                        JSONObject lcd = (JSONObject)docJsonLoc.get(i);
                        if(lcd.has("disponibilidad"))
                        {
                            idConductor = Integer.parseInt(lcd.get("id_conductor").toString());
                            LugarC = lcd.get("lugar").toString();
                            disponible = Boolean.parseBoolean(lcd.get("disponibilidad").toString());
                            Localidad lc = new Localidad("Conductor", idConductor, LugarC, disponible);
                            Guateroad.LocConductor.Insertar(lc);
                            Guateroad.blockchain.BloqueLocCdt.add(lc);
                            if(Guateroad.ArbolConductor.Buscar(idConductor)) {
                                Guateroad.ArbolConductor.ModifDispo(idConductor, disponible);
                            }
                            System.out.println("Loc conductor encontrados y agregados");
                        }
                        else 
                        {
                            idUsuario = Integer.parseInt(lcd.get("id_usuario").toString());
                            Lugar = lcd.get("nombre").toString();
                            Localidad lc = new Localidad("Normal", idUsuario, Lugar, true);
                            Guateroad.LocUsuario.Insertar(lc);
                            Guateroad.blockchain.BloqueLocUs.add(lc);
                            System.out.println("Loc inicial encontrados y agregados");
                        }
                        
                    }
                }
                
            }
            catch(Exception e) {
            }
    }
    
    public void LimpiarListas()
    {
        CadenaJson = "";
        BloqueFactura.clear();
        BloqueGrafo.clear();
        BloqueLocCdt.clear();    
        BloqueLocUs.clear();
        BloqueLugar.clear();
        BloquePersona.clear();
        BloqueViaje.clear();
    }
}
