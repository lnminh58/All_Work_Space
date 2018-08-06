/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.connectDatabase;
import static controller.encrypt.encryptmd5;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nguyenducthao
 */
public class frmLogin extends javax.swing.JDialog {

    public static String txtUserNameNull;
    public static String txtPasswordNull;
    public static String MessageDialog;
    public static String MessageLoginFail;

    /**
     * Creates new form frmLogin
     *
     * @param parent
     * @param modal
     */
    public frmLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        txtUserName.setText("admin");
        txtPassword.setText("admin");
        switch (frmMain.language) {
            case "English":
                changeLanguage("en", "US");
                break;
            case "Tiếng Anh":
                changeLanguage("en", "US");
                break;
            case "VietNam":
                changeLanguage("vi", "VN");
                break;
            case "Tiếng Việt":
                changeLanguage("vi", "VN");
                break;
        }
    }

    public void changeLanguage(String language, String country) {
        Locale currentLocale;
        ResourceBundle myResourceBundle;
        String resource = "languages/language_" + language + "_" + country;
        currentLocale = new Locale(language, country);
        myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
        setTitle(myResourceBundle.getString("frmLoginTitle"));
        labelUsername.setText((myResourceBundle.getString("frmLoginlabelUsername")));
        labelPassword.setText((myResourceBundle.getString("frmLoginlabelPassword")));
        btnLogin.setText((myResourceBundle.getString("frmLoginbtnLogin")));
        btnExit.setText((myResourceBundle.getString("frmLoginbtnExit")));
        txtUserNameNull = myResourceBundle.getString("frmLogintxtUserNameNull");
        txtPasswordNull = myResourceBundle.getString("frmLogintxtPasswordNull");
        MessageDialog = myResourceBundle.getString("frmLoginMessageDialog");
        MessageLoginFail = myResourceBundle.getString("frmLoginMessageLoginFail");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUsername = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        labelUsername.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsername.setText("User name");

        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPassword.setText("Password");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(txtPassword))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUsername)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPassword)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit)
                    .addComponent(btnLogin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        if (txtUserName.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, txtUserNameNull, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
            txtUserName.requestFocus();
            return;
        }
        if (txtPassword.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, txtPasswordNull, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
            txtPassword.requestFocus();
            return;
        }
        try {
            // TODO add your handling code here:
            conn = connectDatabase.getConnectTable();
            String sql = "SELECT users.username, students.studentname FROM users, students where users.username=? and users.password=? and users.username=students.username";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            pstmt.setString(2, encryptmd5(txtPassword.getText()));
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    frmMain.userIDLogin = rs.getString("username");
                    frmMain.userNameLogin = rs.getString("studentname");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, MessageLoginFail, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            conn = connectDatabase.getConnectTable();
            String sql = "SELECT keyrole FROM usersrole where username=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtUserName.getText());
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    frmMain.userrole.add(rs.getString("keyrole"));
                }
                for (int i = 0; i < frmMain.userrole.size(); i++) {
                    frmMain.userrole.set(i, frmMain.userrole.get(i).replace("frmMain", ""));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        switch (frmMain.language) {
            case "English":
                String myLanguage = "en";
                String myCountry = "US";
                Locale currentLocale;
                ResourceBundle myResourceBundle;
                String resource = "languages/language_" + myLanguage + "_" + myCountry;
                currentLocale = new Locale(myLanguage, myCountry);
                myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
                frmMain.labelWelcome.setText(myResourceBundle.getString("frmMainLabelWelcome") + frmMain.userNameLogin + " (" + frmMain.userIDLogin + ")");
                break;
            case "Tiếng Anh":
                myLanguage = "en";
                myCountry = "US";
                resource = "languages/language_" + myLanguage + "_" + myCountry;
                currentLocale = new Locale(myLanguage, myCountry);
                myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
                frmMain.labelWelcome.setText(myResourceBundle.getString("frmMainLabelWelcome") + frmMain.userNameLogin + " (" + frmMain.userIDLogin + ")");
                break;
            case "VietNam":
                myLanguage = "vi";
                myCountry = "VN";
                resource = "languages/language_" + myLanguage + "_" + myCountry;
                currentLocale = new Locale(myLanguage, myCountry);
                myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
                frmMain.labelWelcome.setText(myResourceBundle.getString("frmMainLabelWelcome") + frmMain.userNameLogin + " (" + frmMain.userIDLogin + ")");
                break;
            case "Tiếng Việt":
                myLanguage = "vi";
                myCountry = "VN";
                resource = "languages/language_" + myLanguage + "_" + myCountry;
                currentLocale = new Locale(myLanguage, myCountry);
                myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
                frmMain.labelWelcome.setText(myResourceBundle.getString("frmMainLabelWelcome") + frmMain.userNameLogin + " (" + frmMain.userIDLogin + ")");
                break;
        }
        frmMain.loginSucess=true;
    }//GEN-LAST:event_btnLoginActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            frmLogin dialog = new frmLogin(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
