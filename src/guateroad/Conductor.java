/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jeany
 */
public class Conductor extends javax.swing.JFrame {

    /**
     * Creates new form Conductor
     */
    public Conductor() {
        initComponents();
        this.setSize(750,520);
        
        txtCorreo.setVisible(false);
        txtName.setVisible(false);
        txtPass.setVisible(false);
        txtTel.setVisible(false);
        txtUser.setVisible(false);
        lblNombre.setText(Guateroad.ArbolConductor.UsuarioP(Guateroad.id));
        lblName.setText(Guateroad.ArbolConductor.NombreP(Guateroad.id));
        lblCorreo.setText(Guateroad.ArbolConductor.CorreoP(Guateroad.id));
        lblPass.setText(Guateroad.ArbolConductor.PassP(Guateroad.id));
        lblTel.setText(Guateroad.ArbolConductor.TelefonoP(Guateroad.id));
        lblUser.setText(Guateroad.ArbolConductor.UsuarioP(Guateroad.id));
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Viajes");
        tabla.addColumn("Fecha");
        tabla.addColumn("Precio");
        
        int c = 1; 
        for(int i = 0; i < Guateroad.ArbolFacturas.fact.size(); i++)
        {
            if(Guateroad.ArbolFacturas.PagoAconductor(Guateroad.id) != 0.0)
            {
                tabla.addRow(new Object[]{"Viaje "+ c, Guateroad.ArbolFacturas.FechaPago(Guateroad.id) ,"Q"+Guateroad.ArbolFacturas.PagoAconductor(Guateroad.id)});
                c++;
            }
        }
        
        TablaViajes.setModel(tabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        bttInicio = new javax.swing.JButton();
        bttCerrar = new javax.swing.JButton();
        bttModificar = new javax.swing.JButton();
        bttGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaViajes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblName.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblName);
        lblName.setBounds(40, 80, 190, 30);

        lblNombre.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblNombre);
        lblNombre.setBounds(590, 10, 180, 30);

        lblUser.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblUser);
        lblUser.setBounds(40, 130, 210, 30);

        lblPass.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblPass);
        lblPass.setBounds(40, 190, 310, 30);

        lblCorreo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("jLabel2");
        getContentPane().add(lblCorreo);
        lblCorreo.setBounds(40, 250, 210, 30);

        lblTel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        lblTel.setForeground(new java.awt.Color(255, 255, 255));
        lblTel.setText("jLabel2");
        getContentPane().add(lblTel);
        lblTel.setBounds(40, 300, 210, 30);

        txtTel.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        getContentPane().add(txtTel);
        txtTel.setBounds(40, 300, 210, 30);

        txtCorreo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(40, 250, 210, 30);

        txtPass.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        getContentPane().add(txtPass);
        txtPass.setBounds(40, 190, 210, 30);

        txtUser.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        getContentPane().add(txtUser);
        txtUser.setBounds(40, 130, 210, 30);

        txtName.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        getContentPane().add(txtName);
        txtName.setBounds(40, 80, 210, 30);

        bttInicio.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttInicio.setText("Inicio");
        bttInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttInicioActionPerformed(evt);
            }
        });
        getContentPane().add(bttInicio);
        bttInicio.setBounds(620, 420, 100, 25);

        bttCerrar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttCerrar.setText("Cerrar");
        getContentPane().add(bttCerrar);
        bttCerrar.setBounds(100, 410, 100, 25);

        bttModificar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttModificar.setText("Modificar");
        bttModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttModificarActionPerformed(evt);
            }
        });
        getContentPane().add(bttModificar);
        bttModificar.setBounds(30, 370, 100, 25);

        bttGuardar.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        bttGuardar.setText("Guardar");
        bttGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(bttGuardar);
        bttGuardar.setBounds(160, 370, 100, 25);

        TablaViajes.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        TablaViajes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TablaViajes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 70, 260, 290);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guateroad/azul.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 740, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttModificarActionPerformed
        txtCorreo.setVisible(true);
        txtName.setVisible(true);
        txtPass.setVisible(true);
        txtTel.setVisible(true);
        txtUser.setVisible(true);
        txtName.setText(Guateroad.ArbolConductor.NombreP(Guateroad.id));
        txtCorreo.setText(Guateroad.ArbolConductor.CorreoP(Guateroad.id));
        txtPass.setText(Guateroad.contraseña);
        txtTel.setText(Guateroad.ArbolConductor.TelefonoP(Guateroad.id));
        txtUser.setText(Guateroad.ArbolConductor.UsuarioP(Guateroad.id));
    }//GEN-LAST:event_bttModificarActionPerformed

    private void bttGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarActionPerformed
        Guateroad.contraseña = txtPass.getText();
        Guateroad.ArbolConductor.setCorreo(Guateroad.id, txtCorreo.getText());
        Guateroad.ArbolConductor.setNom(Guateroad.id, txtName.getText());
        Guateroad.ArbolConductor.setPass(Guateroad.id, txtPass.getText());
        Guateroad.ArbolConductor.setTel(Guateroad.id, txtTel.getText());
        Guateroad.ArbolConductor.setUs(Guateroad.id, txtUser.getText());
        txtCorreo.setVisible(false);
        txtName.setVisible(false);
        txtPass.setVisible(false);
        txtTel.setVisible(false);
        txtUser.setVisible(false);
        lblNombre.setText(Guateroad.ArbolConductor.UsuarioP(Guateroad.id));
        lblName.setText(Guateroad.ArbolConductor.NombreP(Guateroad.id));
        lblCorreo.setText(Guateroad.ArbolConductor.CorreoP(Guateroad.id));
        lblPass.setText(Guateroad.ArbolConductor.PassP(Guateroad.id));
        lblTel.setText(Guateroad.ArbolConductor.TelefonoP(Guateroad.id));
        lblUser.setText(Guateroad.ArbolConductor.UsuarioP(Guateroad.id));
    }//GEN-LAST:event_bttGuardarActionPerformed

    private void bttInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttInicioActionPerformed
        Login lg = new Login();
        lg.setVisible(true);
        dispose();
    }//GEN-LAST:event_bttInicioActionPerformed

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
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Conductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Conductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaViajes;
    private javax.swing.JButton bttCerrar;
    private javax.swing.JButton bttGuardar;
    private javax.swing.JButton bttInicio;
    private javax.swing.JButton bttModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTel;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
