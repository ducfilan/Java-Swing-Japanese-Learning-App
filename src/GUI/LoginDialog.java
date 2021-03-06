/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * LoginDialog.java
 *
 */
package GUI;

import Entity.User;
import Interaction.DataInteraction;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author GiangNT
 */
public class LoginDialog extends javax.swing.JDialog {

    /**
     * Creates new form LoginDialog
     */
    public LoginDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Ham connect server
        //DataInteraction.connect();
        setLocationRelativeTo(null);
        setVisible(true);
        //ConfigServer configServerObject = new ConfigServer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLogin = new javax.swing.JPanel();
        tfName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        btExit = new javax.swing.JButton();
        btChoose = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbMess = new javax.swing.JLabel();
        btConfig = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbMessageLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Campaign Information System"); // NOI18N
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLogin.setBackground(new java.awt.Color(56, 79, 113));
        pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlLogin.setName("pnlLogin"); // NOI18N
        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfName.setText("admin");
        tfName.setName("tfName"); // NOI18N
        tfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameActionPerformed(evt);
            }
        });
        pnlLogin.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 21, 170, 30));

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUserName.setForeground(new java.awt.Color(240, 240, 240));
        lblUserName.setText("Enter your name :");
        lblUserName.setName("lblUserName"); // NOI18N
        pnlLogin.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 17, -1, 30));

        btLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btLogin.setText("Login");
        btLogin.setName("btLogin"); // NOI18N
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 170, 40));

        btExit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btExit.setText("Exit");
        btExit.setName("btExit"); // NOI18N
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        pnlLogin.add(btExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 170, 40));

        btChoose.setText("Choose avatar");
        btChoose.setName("btChoose"); // NOI18N
        btChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChooseActionPerformed(evt);
            }
        });
        pnlLogin.add(btChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 120, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Icon_Admin.png"))); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        pnlLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 120));

        lbMess.setForeground(new java.awt.Color(240, 240, 240));
        lbMess.setName("lbMess"); // NOI18N
        pnlLogin.add(lbMess, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 170, 30));

        btConfig.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btConfig.setForeground(new java.awt.Color(255, 0, 51));
        btConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/remove-from-database-icon.png"))); // NOI18N
        btConfig.setText("Config Server");
        btConfig.setBorder(null);
        btConfig.setBorderPainted(false);
        btConfig.setContentAreaFilled(false);
        btConfig.setName("btConfig"); // NOI18N
        btConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfigActionPerformed(evt);
            }
        });
        pnlLogin.add(btConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 140, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Message:");
        jLabel2.setName("jLabel2"); // NOI18N
        pnlLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 60, 20));

        lbMessageLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbMessageLogin.setForeground(new java.awt.Color(255, 255, 255));
        lbMessageLogin.setName("lbMessageLogin"); // NOI18N
        pnlLogin.add(lbMessageLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 130, 20));

        getContentPane().add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChooseActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        int action = fileChooser.showOpenDialog(this);
        if (action == JFileChooser.APPROVE_OPTION) {
            File f = fileChooser.getSelectedFile();
            avatarPath = f.getAbsolutePath();
            ImageIcon icon = new ImageIcon(avatarPath);
            Image scaleImage = icon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
            icon = new ImageIcon(scaleImage);
            jLabel1.setIcon(icon);
        }
    }//GEN-LAST:event_btChooseActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        // TODO add your handling code here:
        status = false;
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        DataInteraction.connect();
        //System.out.println(DataInteraction.getMessage());
        if (DataInteraction.getMessage().equals("Database connecting failure.")) {
            lbMessageLogin.setText("Config server first! ->");
        } else {
            login();
        }

    }//GEN-LAST:event_btLoginActionPerformed

    private void tfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameActionPerformed
        // TODO add your handling code here:
        btLoginActionPerformed(evt);
    }//GEN-LAST:event_tfNameActionPerformed

    private void btConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfigActionPerformed
        // TODO add your handling code here:
        new ConfigServer(null, true);

    }//GEN-LAST:event_btConfigActionPerformed
    private void login() {

        name = tfName.getText();
        if ("".equals(name)) {
            lbMess.setText("Please enter your name!");
            status = false;
        } else {
            status = true;
            dispose();
        }

    }

    /**
     *
     * @return
     */
    public static String getNameUr() {
        return name;
    }

    public static String getAvatarPath() {
        return avatarPath;
    }

    public static boolean getStatus() {
        return status;
    }
    ConfigServer sc = null;
    private static boolean status = false;
    private static String name = "";
    private static String avatarPath = "";
    public static User ur = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChoose;
    private javax.swing.JButton btConfig;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbMess;
    private javax.swing.JLabel lbMessageLogin;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
