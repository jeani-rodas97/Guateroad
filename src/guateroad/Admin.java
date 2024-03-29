/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import arbolb.Persona;
import grafo.DatosGrafo;
import hash.Lugares;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author Jeany
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        this.setSize(750,510);
        bttJlocalidad.setVisible(false);
        bttJlugares.setVisible(false);
        bttJinicial.setVisible(false);
        bttJConectar.setVisible(false);
        bttJuser.setVisible(false);
        jScrollPane1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();
        bttCerrar = new javax.swing.JButton();
        bttModificar = new javax.swing.JButton();
        bttJinicial = new javax.swing.JButton();
        bttJuser = new javax.swing.JButton();
        bttJlocalidad = new javax.swing.JButton();
        bttJlugares = new javax.swing.JButton();
        bttJConectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaLugares = new javax.swing.JTable();
        Inicio = new javax.swing.JButton();
        bttRepLug = new javax.swing.JButton();
        bttRepUs = new javax.swing.JButton();
        bttRepCondc = new javax.swing.JButton();
        bttTime = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lbl2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbl2.setForeground(new java.awt.Color(255, 255, 255));
        lbl2.setText("52635899");
        getContentPane().add(lbl2);
        lbl2.setBounds(50, 270, 210, 17);

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("andree_avalos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(534, 10, 120, 17);

        lbl1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("Carlos Andree Avalos Soto");
        getContentPane().add(lbl1);
        lbl1.setBounds(50, 70, 210, 17);

        lbl3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbl3.setForeground(new java.awt.Color(255, 255, 255));
        lbl3.setText("andree_avalos ");
        getContentPane().add(lbl3);
        lbl3.setBounds(50, 120, 210, 17);

        lbl4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbl4.setForeground(new java.awt.Color(255, 255, 255));
        lbl4.setText("admin");
        getContentPane().add(lbl4);
        lbl4.setBounds(50, 170, 210, 17);

        lbl5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lbl5.setForeground(new java.awt.Color(255, 255, 255));
        lbl5.setText("aavalosoto@gmail.com ");
        getContentPane().add(lbl5);
        lbl5.setBounds(50, 220, 210, 17);

        bttCerrar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttCerrar.setText("Cerrar");
        getContentPane().add(bttCerrar);
        bttCerrar.setBounds(150, 340, 110, 25);

        bttModificar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttModificar.setText("Modificar");
        getContentPane().add(bttModificar);
        bttModificar.setBounds(20, 340, 110, 25);

        bttJinicial.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttJinicial.setText("Loc Inicial");
        bttJinicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJinicialActionPerformed(evt);
            }
        });
        getContentPane().add(bttJinicial);
        bttJinicial.setBounds(330, 220, 110, 25);

        bttJuser.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttJuser.setText("Usuario");
        bttJuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJuserActionPerformed(evt);
            }
        });
        getContentPane().add(bttJuser);
        bttJuser.setBounds(330, 70, 110, 25);

        bttJlocalidad.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttJlocalidad.setText("Localidad");
        bttJlocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJlocalidadActionPerformed(evt);
            }
        });
        getContentPane().add(bttJlocalidad);
        bttJlocalidad.setBounds(330, 270, 110, 25);

        bttJlugares.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttJlugares.setText("Lugares");
        bttJlugares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJlugaresActionPerformed(evt);
            }
        });
        getContentPane().add(bttJlugares);
        bttJlugares.setBounds(330, 120, 110, 25);

        bttJConectar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttJConectar.setText("Conexion");
        bttJConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttJConectarActionPerformed(evt);
            }
        });
        getContentPane().add(bttJConectar);
        bttJConectar.setBounds(330, 170, 110, 25);

        jScrollPane1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N

        TablaLugares.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        TablaLugares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaLugares);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 30, 510, 370);

        Inicio.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        Inicio.setText("Inicio");
        Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioActionPerformed(evt);
            }
        });
        getContentPane().add(Inicio);
        Inicio.setBounds(620, 390, 90, 25);

        bttRepLug.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttRepLug.setText("Reporte Lugares");
        bttRepLug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRepLugActionPerformed(evt);
            }
        });
        getContentPane().add(bttRepLug);
        bttRepLug.setBounds(480, 170, 180, 25);

        bttRepUs.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttRepUs.setText("Reporte Usuarios");
        bttRepUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRepUsActionPerformed(evt);
            }
        });
        getContentPane().add(bttRepUs);
        bttRepUs.setBounds(480, 70, 180, 25);

        bttRepCondc.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttRepCondc.setText("Reporte Conductores");
        bttRepCondc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRepCondcActionPerformed(evt);
            }
        });
        getContentPane().add(bttRepCondc);
        bttRepCondc.setBounds(480, 120, 180, 25);

        bttTime.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttTime.setText("Tiempo");
        bttTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttTimeActionPerformed(evt);
            }
        });
        getContentPane().add(bttTime);
        bttTime.setBounds(510, 390, 90, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guateroad/verde.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 440);

        jMenu1.setText("Perfil");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cargar Archivos");
        jMenu2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Lugares");
        jMenu3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        lbl3.setVisible(true);
        lbl4.setVisible(true);
        lbl5.setVisible(true);
        lbl1.setText("Carlos Andree Avalos Soto");
        lbl2.setText("andree_avalos");
        lbl3.setText("admin");
        lbl4.setText("aavalosoto@gmail.com");
        lbl5.setText("52635899");
        bttModificar.setVisible(true);
        bttCerrar.setVisible(true);
        bttJConectar.setVisible(false);
        bttJinicial.setVisible(false);
        bttJlocalidad.setVisible(false);
        bttJlugares.setVisible(false);
        bttJuser.setVisible(false);
        jScrollPane1.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        lbl1.setVisible(true);
        lbl2.setVisible(true);
        lbl3.setVisible(true);
        lbl4.setVisible(true);
        lbl5.setVisible(true);
        lbl1.setText("Cargar Usuarios");
        lbl2.setText("Cargar Localidad");
        lbl3.setText("Cargar Lugares");
        lbl4.setText("Cargar Conexiones");
        lbl5.setText("Cargar Localidad Inicial");
        bttModificar.setVisible(false);
        bttCerrar.setVisible(false);
        bttJConectar.setVisible(true);
        bttJinicial.setVisible(true);
        bttJlocalidad.setVisible(true);
        bttJlugares.setVisible(true);
        bttJuser.setVisible(true);
        jScrollPane1.setVisible(false);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void bttJuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJuserActionPerformed
        String nombre, usuario, correo, pass, tel, rol; 
        int idJ;
        JFileChooser fView = new JFileChooser();
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivos Json", "json");
        fView.setFileFilter(ext);
        fView.showOpenDialog(null);
        File js = fView.getSelectedFile();
        try {
            FileReader leer = new FileReader(js);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = "";
            String Json = ""; 
            while((linea = buffer.readLine()) != null){
                Json += linea + "\n"; 
            }
            
            //System.out.println(Json);
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject(jsn);
            JSONArray docJson = (JSONArray) obj.get("usuarios");
            for(int i = 0; i < docJson.length(); i++)
            {
                JSONObject user = (JSONObject)docJson.get(i);
                idJ = Integer.parseInt(user.get("id").toString());
                nombre = user.get("nombre").toString();
                usuario = user.get("usuario").toString();
                correo = user.get("correo").toString();
                pass = Guateroad.fn.EncriptarSHA256(user.get("pass").toString());
                Guateroad.contraseña = user.get("pass").toString();
                tel = user.get("telefono").toString();
                rol = user.get("rol").toString();
                arbolb.Persona NuevoUser = new Persona(idJ, nombre, usuario, rol, pass, correo, tel, true);
                guateroad.Guateroad.blockchain.BloquePersona.add(NuevoUser);
                if(rol.equals("conductor")) {
                    Guateroad.ArbolConductor.AgregarEnB(idJ, NuevoUser);
                    Guateroad.bConductor.Insertar(idJ);
                    //System.out.println("Conductor agregado al arbol");
                }
                
                if(rol.equals("normal")) {
                    Guateroad.ArbolUsuario.AgregarEnB(idJ, NuevoUser);
                    Guateroad.bUsuario.Insertar(idJ);
                    //System.out.println("Usuario agregado al arbol");
                }
                
            }
            JOptionPane.showMessageDialog(null, "Usuarios cargados correctamente");
        }
        catch(Exception e) {
        }
        
    }//GEN-LAST:event_bttJuserActionPerformed

    private void bttJlocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJlocalidadActionPerformed
        int idConductor;
        String Lugar;
        boolean disponible;
        JFileChooser fView = new JFileChooser();
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivos Json", "json");
        fView.setFileFilter(ext);
        fView.showOpenDialog(null);
        File js = fView.getSelectedFile();
        try {
            FileReader leer = new FileReader(js);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = "";
            String Json = ""; 
            while((linea = buffer.readLine()) != null){
                Json += linea + "\n"; 
            }
            
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject(jsn);
            JSONArray docJson = (JSONArray) obj.get("localidades");
            for(int i = 0; i < docJson.length(); i++)
            {
                JSONObject lcd = (JSONObject)docJson.get(i);
                idConductor = Integer.parseInt(lcd.get("id_conductor").toString());
                Lugar = lcd.get("lugar").toString();
                disponible = Boolean.parseBoolean(lcd.get("disponibilidad").toString());
                Localidad lc = new Localidad("Conductor", idConductor, Lugar, disponible);
                Guateroad.LocConductor.Insertar(lc);
                if(Guateroad.ArbolConductor.Buscar(idConductor)) {
                    Guateroad.ArbolConductor.ModifDispo(idConductor, disponible);
                }
            }
            
            JOptionPane.showMessageDialog(null, "Localidad conductor cargada correctamente");
        }
        catch(Exception e) {
        }
        
    }//GEN-LAST:event_bttJlocalidadActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        lbl1.setVisible(false);
        lbl2.setVisible(false);
        lbl3.setVisible(false);
        lbl4.setVisible(false);
        lbl5.setVisible(false);
        bttModificar.setVisible(false);
        bttCerrar.setVisible(false);
        bttJConectar.setVisible(false);
        bttJinicial.setVisible(false);
        bttJlocalidad.setVisible(false);
        bttJlugares.setVisible(false);
        bttJuser.setVisible(false);
        
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Categoria");
        tabla.addColumn("Lugar");
        
        for(int i = 0; i < Guateroad.HashT.cantTotal(); i++)
        {
            if (Guateroad.HashT.Categoria(i).equals("vacio"))
            {
                System.out.println(Guateroad.HashT.Categoria(i));
            }
            else 
            {
                System.out.println(Guateroad.HashT.Nombre(i));
                tabla.addRow(new Object[]{Guateroad.HashT.Categoria(i), Guateroad.HashT.Nombre(i)});
            }
        }
        
        TablaLugares.setModel(tabla);
        jScrollPane1.setVisible(true);
        
    }//GEN-LAST:event_jMenu3MouseClicked

    private void bttJlugaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJlugaresActionPerformed
        String Categoria, Nombre;
        int id;
        double Lat, Lon; 
        JFileChooser fView = new JFileChooser();
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivos Json", "json");
        fView.setFileFilter(ext);
        fView.showOpenDialog(null);
        File js = fView.getSelectedFile();
        try {
            FileReader leer = new FileReader(js);
            
            BufferedReader buffer = new BufferedReader(leer);
            String linea = "";
            String Json = ""; 
            while((linea = buffer.readLine()) != null){
                Json += linea + "\n"; 
            }
            
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject(jsn);
            JSONArray docJson = (JSONArray) obj.get("Lugares");
            
            for(int i = 0; i < docJson.length(); i++)
            {
                JSONObject lug = (JSONObject)docJson.get(i);
                id = Integer.parseInt(lug.get("id").toString());
                Categoria = lug.get("Categoria").toString();
                Nombre = lug.get("Nombre").toString();
                Lat = Double.parseDouble(lug.get("Lat").toString());
                Lon = Double.parseDouble(lug.get("Lon").toString());
                hash.Lugares lg = new Lugares(id, Categoria, Nombre, Lat, Lon);
                Guateroad.HashT.Nuevo(lg);
            }
            
            JOptionPane.showMessageDialog(null, "Lugares cargados correctamente");
        }
        catch(Exception e) {
        }
    }//GEN-LAST:event_bttJlugaresActionPerformed

    private void InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_InicioActionPerformed

    private void bttRepLugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRepLugActionPerformed
        String comando = "cmd /c dot HashLugar.dot -Tpdf -o HashLugar.pdf ";
        String dot = "digraph hash{\n" +
        "graph [\n" +
        "rankdir = \"LR\"\n" +
        "bgcolor = \"white:orange\"\n" +
        "style=\"filled\"\n" +
        "gradientangle = 270];\n" +
        "tbl [\n" +
        "    shape=plaintext\n" +
        "    label=<\n" +
        "    <table color='black' cellspacing='0'>\n";
        dot += Guateroad.HashT.ObtenerDot();
        dot += "    </table>\n" + ">];\n" + "}";
        
        try{
            File arch = new File("HashLugar.dot");
            if(!arch.exists())
                arch.createNewFile();
            
            FileWriter escribir = new FileWriter(arch);
            BufferedWriter buffer = new BufferedWriter(escribir);
            buffer.write(dot);
            buffer.close();
            
            Process proceso = Runtime.getRuntime().exec(comando);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_bttRepLugActionPerformed

    private void bttJConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJConectarActionPerformed
        String inicio, fin, unidad, moneda;
        int peso;
        double precio;
        JFileChooser fView = new JFileChooser();
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivos Json", "json");
        fView.setFileFilter(ext);
        fView.showOpenDialog(null);
        File js = fView.getSelectedFile();
        try {
            FileReader leer = new FileReader(js);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = "";
            String Json = ""; 
            while((linea = buffer.readLine()) != null){
                Json += linea + "\n"; 
            }
            
            //System.out.println(Json);
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject(jsn);
            JSONArray docJson = (JSONArray) obj.get("Grafo");
            for(int i = 0; i < docJson.length(); i++)
            {
                JSONObject grafoJ = (JSONObject)docJson.get(i);
                inicio = grafoJ.get("inicio").toString();
                fin = grafoJ.get("final").toString();
                peso = Integer.parseInt(grafoJ.get("peso").toString());
                unidad = grafoJ.get("unidad").toString();
                precio = Double.parseDouble(grafoJ.get("precio").toString());
                moneda = grafoJ.get("moneda").toString();
                
                grafo.DatosGrafo DGraf = new DatosGrafo(inicio, fin, unidad, moneda, peso, precio);
                Guateroad.grafos.Insertar(DGraf);
            }
            
            JOptionPane.showMessageDialog(null, "Datos grafo cargados correctamente");
        }
        catch(Exception e) {
        }
    }//GEN-LAST:event_bttJConectarActionPerformed

    private void bttJinicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttJinicialActionPerformed
        int idUsuario;
        String Lugar;
        JFileChooser fView = new JFileChooser();
        FileNameExtensionFilter ext = new FileNameExtensionFilter("Archivos Json", "json");
        fView.setFileFilter(ext);
        fView.showOpenDialog(null);
        File js = fView.getSelectedFile();
        try {
            FileReader leer = new FileReader(js);
            BufferedReader buffer = new BufferedReader(leer);
            String linea = "";
            String Json = ""; 
            while((linea = buffer.readLine()) != null){
                Json += linea + "\n"; 
            }
            
            JSONTokener jsn = new JSONTokener(Json); 
            JSONObject obj = new JSONObject(jsn);
            JSONArray docJson = (JSONArray) obj.get("localidades");
            for(int i = 0; i < docJson.length(); i++)
            {
                JSONObject lcd = (JSONObject)docJson.get(i);
                idUsuario = Integer.parseInt(lcd.get("id_usuario").toString());
                Lugar = lcd.get("nombre").toString();
                
                Localidad lc = new Localidad("Normal", idUsuario, Lugar, true);
                Guateroad.LocUsuario.Insertar(lc);
                
            }
            
            JOptionPane.showMessageDialog(null, "Usuarios cargados correctamente");
        }
        catch(Exception e) {
        }
        
    }//GEN-LAST:event_bttJinicialActionPerformed

    private void bttRepUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRepUsActionPerformed
        String comando = "cmd /c dot RepUs.dot -Tpdf -o RepUs.pdf ";
        String dot;
        dot = Guateroad.bUsuario.Graficar();
        try{
            File arch = new File("RepUs.dot");
            if(!arch.exists())
                arch.createNewFile();
            
            FileWriter escribir = new FileWriter(arch);
            BufferedWriter buffer = new BufferedWriter(escribir);
            buffer.write(dot);
            buffer.close();
            
            Process proceso = Runtime.getRuntime().exec(comando);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bttRepUsActionPerformed

    private void bttRepCondcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRepCondcActionPerformed
        String comando = "cmd /c dot RepCd.dot -Tpdf -o RepCd.pdf ";
        String dot;
        dot = Guateroad.bConductor.Graficar();
        try{
            File arch = new File("RepCd.dot");
            if(!arch.exists())
                arch.createNewFile();
            
            FileWriter escribir = new FileWriter(arch);
            BufferedWriter buffer = new BufferedWriter(escribir);
            buffer.write(dot);
            buffer.close();
            
            Process proceso = Runtime.getRuntime().exec(comando);
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bttRepCondcActionPerformed

    private void bttTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttTimeActionPerformed
        String tiempito = JOptionPane.showInputDialog("Tiempo en minutos");
        Guateroad.tiempoB = Integer.parseInt(tiempito);
    }//GEN-LAST:event_bttTimeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inicio;
    private javax.swing.JTable TablaLugares;
    private javax.swing.JButton bttCerrar;
    private javax.swing.JButton bttJConectar;
    private javax.swing.JButton bttJinicial;
    private javax.swing.JButton bttJlocalidad;
    private javax.swing.JButton bttJlugares;
    private javax.swing.JButton bttJuser;
    private javax.swing.JButton bttModificar;
    private javax.swing.JButton bttRepCondc;
    private javax.swing.JButton bttRepLug;
    private javax.swing.JButton bttRepUs;
    private javax.swing.JButton bttTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    // End of variables declaration//GEN-END:variables
}
