/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author nguyenducthao
 */
public class frmMain extends javax.swing.JFrame {

    public static String language;
    public static String userIDLogin;
    public static String userNameLogin;
    public static List<Component> allComponent;
    public static ArrayList<String> userrole = new ArrayList<>();
    public static boolean loginSucess = false;

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
        initForm();
        setNameComponent();
        disableAllComponent();
        allComponent = getAllComponents(this);

    }

    void initForm() {
        cmbLanguage.removeAllItems();
        cmbLanguage.addItem("English");
//        cmbLanguage.addItem("VietNam");
    }

    void setNameComponent() {
        btnLogin.setName("btnLogin");
        btnLogout.setName("btnLogout");
        btnUpload.setName("btnUpload");
        btnCreateNewClass.setName("btnCreateNewClass");
        btnCreateNewStudent.setName("btnCreateNewStudent");
        btnDeleteStudent.setName("btnDeleteStudent");
        btnModifyStudent.setName("btnModifyStudent");
        btnCreateNewExamination.setName("btnCreateNewExamination");
    }

    public void disableAllComponent() {
        btnLogout.setEnabled(false);
        btnUpload.setEnabled(false);
        btnCreateNewClass.setEnabled(false);
        btnCreateNewStudent.setEnabled(false);
        btnDeleteStudent.setEnabled(false);
        btnModifyStudent.setEnabled(false);
        btnCreateNewExamination.setEnabled(false);
    }

    public void changeLanguage(String language, String country) {
        int currentIndex = cmbLanguage.getSelectedIndex();
        Locale currentLocale;
        ResourceBundle myResourceBundle;
        String resource = "languages/language_" + language + "_" + country;
        currentLocale = new Locale(language, country);
        myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
        setTitle(myResourceBundle.getString("frmMainTitle"));
        labelLanguage.setText((myResourceBundle.getString("frmMainlabelLanguage")));
        cmbLanguage.removeAllItems();
        cmbLanguage.addItem((myResourceBundle.getString("frmMainLanguageEnglish")));
        cmbLanguage.addItem((myResourceBundle.getString("frmMainLanguageVietNam")));
        btnLogin.setText((myResourceBundle.getString("frmMainbtnLogin")));
        btnLogout.setText((myResourceBundle.getString("frmMainbtnLogout")));
        btnUpload.setText((myResourceBundle.getString("frmMainbtnUpload")));
        btnCreateNewClass.setText((myResourceBundle.getString("frmMainbtnCreateNewClass")));
        btnCreateNewStudent.setText((myResourceBundle.getString("frmMainbtnCreateNewStudent")));
        btnDeleteStudent.setText((myResourceBundle.getString("frmMainbtnDeleteStudent")));
        btnModifyStudent.setText((myResourceBundle.getString("frmMainbtnModifyStudent")));
        btnCreateNewExamination.setText((myResourceBundle.getString("frmMainbtnCreateNewExamination")));
        labelWelcome.setText((myResourceBundle.getString("frmMainLabelWelcome")));

        cmbLanguage.setSelectedIndex(currentIndex);
    }

    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    void updateGUI() {
        
        for (int i = 0; i < allComponent.size(); i++) {
            for (int j = 0; j < userrole.size(); j++) {
                if (allComponent.get(i) instanceof JButton) {
                    if (allComponent.get(i) != null) {
                        if (allComponent.get(i).getName() != null) {
                            if (allComponent.get(i).getName().equalsIgnoreCase(userrole.get(j))) {
                                allComponent.get(i).setEnabled(true);
                            }
                        }
                    }
                }
            }
        }
        btnLogin.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cmbLanguage = new javax.swing.JComboBox<>();
        labelLanguage = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnCreateNewClass = new javax.swing.JButton();
        btnCreateNewStudent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        labelWelcome = new javax.swing.JLabel();
        btnDeleteStudent = new javax.swing.JButton();
        btnModifyStudent = new javax.swing.JButton();
        btnCreateNewExamination = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Upload the practice test");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Main Frame"));

        cmbLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLanguageActionPerformed(evt);
            }
        });

        labelLanguage.setText("Language");

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogin.setName(""); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon.png"))); // NOI18N
        btnUpload.setText("Upload");
        btnUpload.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnCreateNewClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/classroom.png"))); // NOI18N
        btnCreateNewClass.setText("Create new class");
        btnCreateNewClass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCreateNewClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewClassActionPerformed(evt);
            }
        });

        btnCreateNewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        btnCreateNewStudent.setText("Create new student");
        btnCreateNewStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        labelWelcome.setText("Welcome");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(labelWelcome)
                .addGap(0, 299, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addComponent(labelWelcome))
        );

        btnDeleteStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deleteuser.png"))); // NOI18N
        btnDeleteStudent.setText("Delete student");
        btnDeleteStudent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnModifyStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modifyuser.png"))); // NOI18N
        btnModifyStudent.setText("Modify student information");

        btnCreateNewExamination.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/examination.png"))); // NOI18N
        btnCreateNewExamination.setText("Create new examination");
        btnCreateNewExamination.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelLanguage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnCreateNewExamination, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpload, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateNewClass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateNewStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModifyStudent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLanguage))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpload)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateNewClass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateNewStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifyStudent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateNewExamination)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        frmLogin login = new frmLogin(this, rootPaneCheckingEnabled);
        login.setModal(true);
        login.setVisible(true);
        if (loginSucess) {
            updateGUI();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void cmbLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLanguageActionPerformed
        // TODO add your handling code here:
        if (cmbLanguage.getSelectedItem() != null) {
            switch (cmbLanguage.getSelectedItem().toString()) {
                case "English":
                    language="English";
                    changeLanguage("en", "US");
                    break;
                case "Tiếng Anh":
                    language="Tiếng Anh";
                    changeLanguage("en", "US");
                    break;
                case "VietNam":
                    language="VietNam";
                    changeLanguage("vi", "VN");
                    break;
                case "Tiếng Việt":
                    language="Tiếng Việt";
                    changeLanguage("vi", "VN");
                    break;
            }
        }
    }//GEN-LAST:event_cmbLanguageActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        loginSucess=false;
        userrole.clear();
        disableAllComponent();
        btnLogin.setEnabled(true);
        labelWelcome.setText(" ");
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCreateNewClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewClassActionPerformed
        // TODO add your handling code here:
        frmCreateNewClass createNewClass=new frmCreateNewClass(this, rootPaneCheckingEnabled);
        createNewClass.setModal(true);
        createNewClass.setVisible(true);
    }//GEN-LAST:event_btnCreateNewClassActionPerformed

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
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
                }
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNewClass;
    private javax.swing.JButton btnCreateNewExamination;
    private javax.swing.JButton btnCreateNewStudent;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnLogin;
    public javax.swing.JButton btnLogout;
    private javax.swing.JButton btnModifyStudent;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> cmbLanguage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelLanguage;
    public static javax.swing.JLabel labelWelcome;
    // End of variables declaration//GEN-END:variables
}
