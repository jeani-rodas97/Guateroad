/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guateroad;

import javax.swing.JOptionPane;

/**
 *
 * @author Jeany
 */
public class Registrar extends javax.swing.JFrame {

    static int id = 1; 

    /**
     * Creates new form Registrar
     */
    public Registrar() {
        initComponents();
        this.setSize(620,650);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TipoUsuario = new javax.swing.ButtonGroup();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        rbtConductor = new javax.swing.JRadioButton();
        txtPass = new javax.swing.JTextField();
        rbtNormal = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 110, 80, 17);

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Usuario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 150, 80, 17);

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 190, 80, 17);

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(140, 230, 80, 17);

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Teléfono");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(140, 270, 80, 17);

        txtTelefono.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTelefono);
        txtTelefono.setBounds(270, 263, 220, 30);

        txtNombre.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(270, 103, 220, 30);

        txtUsuario.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(270, 143, 220, 30);

        txtCorreo.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(270, 183, 220, 30);

        TipoUsuario.add(rbtConductor);
        rbtConductor.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        rbtConductor.setText("Conductor");
        rbtConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtConductorActionPerformed(evt);
            }
        });
        getContentPane().add(rbtConductor);
        rbtConductor.setBounds(110, 460, 120, 25);

        txtPass.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        getContentPane().add(txtPass);
        txtPass.setBounds(270, 223, 220, 30);

        TipoUsuario.add(rbtNormal);
        rbtNormal.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        rbtNormal.setText("Normal");
        rbtNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNormalActionPerformed(evt);
            }
        });
        getContentPane().add(rbtNormal);
        rbtNormal.setBounds(110, 410, 120, 25);

        jButton1.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jButton1.setText("REGISTRARSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 420, 230, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guateroad/Rotulo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, -10, 620, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void rbtConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtConductorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtConductorActionPerformed

    private void rbtNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNormalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtNormalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(rbtConductor.isSelected())
        {
            id++;
            arbolb.Persona Usuario = new arbolb.Persona(id, txtNombre.getText(), txtUsuario.getText(), "Conductor", txtPass.getText(), txtCorreo.getText(), txtTelefono.getText(), true);
            Guateroad.ArbolConductor.AgregarEnB(id, Usuario);
            JOptionPane.showMessageDialog(null, "Usuario conductor creado");
        }
        
        if(rbtNormal.isSelected())
        {
            id++;
            arbolb.Persona Usuario = new arbolb.Persona(id, txtNombre.getText(), txtUsuario.getText(), "Conductor", txtPass.getText(), txtCorreo.getText(), txtTelefono.getText(), true);
            Guateroad.ArbolUsuario.AgregarEnB(id, Usuario);
            JOptionPane.showMessageDialog(null, "Usuario creado");
        }
        else
            JOptionPane.showMessageDialog(null, "Usuario no pudo ser creado");
        Login log = new Login();
        log.setVisible(true);
        new Registrar().setVisible(false);
        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup TipoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton rbtConductor;
    private javax.swing.JRadioButton rbtNormal;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
