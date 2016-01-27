/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginDialog.java
 *
 */
package GUI;

import Entity.Server;

/**
 *
 * @author GiangNT
 */
public class ConfigServer extends javax.swing.JDialog {
    private static Server server;
    
    //Get Server

    public static Server getServer() {
        return server;
    }
    
    public ConfigServer(Server server) {
        this.server = server;
    }
    /**
     * Creates new form LoginDialog
     */
    public ConfigServer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDatabase = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfServerName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPass = new javax.swing.JTextField();
        btDefault = new javax.swing.JButton();
        btSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Campaign Information System"); // NOI18N
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(340, 223));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(56, 79, 113));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Database:");
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        tfDatabase.setText("ProjectXDB");
        tfDatabase.setName("tfDatabase"); // NOI18N
        jPanel1.add(tfDatabase, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 310, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servername:");
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        tfServerName.setText("localhost");
        tfServerName.setName("tfServerName"); // NOI18N
        tfServerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfServerNameActionPerformed(evt);
            }
        });
        jPanel1.add(tfServerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 190, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Port:");
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        tfPort.setText("1527");
        tfPort.setName("tfPort"); // NOI18N
        jPanel1.add(tfPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        tfUsername.setText("sa");
        tfUsername.setName("tfUsername"); // NOI18N
        jPanel1.add(tfUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 310, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");
        jLabel5.setName("jLabel5"); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        tfPass.setText("123456");
        tfPass.setName("tfPass"); // NOI18N
        jPanel1.add(tfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 310, -1));

        btDefault.setText("Default");
        btDefault.setName("btDefault"); // NOI18N
        btDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDefaultActionPerformed(evt);
            }
        });
        jPanel1.add(btDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        btSave.setText("Save");
        btSave.setName("btSave"); // NOI18N
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 70, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfServerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfServerNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfServerNameActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        //server = new Server();
        server = new Server(tfServerName.getText(),tfPort.getText(),tfUsername.getText(),tfPass.getText(),tfDatabase.getText());
        ////System.out.println(server.getServerName());
        dispose();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDefaultActionPerformed
        // TODO add your handling code here:
        tfDatabase.setText("ProjectXDB");
        tfPass.setText("123456");
        tfPort.setText("1527");
        tfServerName.setText("localhost");
        tfUsername.setText("sa");
    }//GEN-LAST:event_btDefaultActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDefault;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfDatabase;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfServerName;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}