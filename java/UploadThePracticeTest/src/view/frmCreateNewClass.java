/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.connectDatabase;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.batch;

/**
 *
 * @author nguyenducthao
 */
public class frmCreateNewClass extends javax.swing.JDialog {

    public static String txtClassIDNull;
    public static String txtClassNameNull;
    public static String MessageDialog;
    public static String MessageClassIDExits;
    public static String MessageClassNameExits;
    public static String MessageCreateSuccess;
    public static String TableColumOrder;
    public static String TableColumBatchID;
    public static String TableColumBatchName;
    static Vector vColumn;
    static Vector vData;

    /**
     * Creates new form frmCreateNewClass
     */
    public frmCreateNewClass(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/icon.png")));
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
        LoadData();
        initTableClass();
    }

    public void changeLanguage(String language, String country) {
        Locale currentLocale;
        ResourceBundle myResourceBundle;
        String resource = "languages/language_" + language + "_" + country;
        currentLocale = new Locale(language, country);
        myResourceBundle = ResourceBundle.getBundle(resource, currentLocale);
        setTitle(myResourceBundle.getString("frmCreateNewClassTitle"));
        labelClassID.setText((myResourceBundle.getString("frmCreateNewClasslabelClassID")));
        labelClassName.setText((myResourceBundle.getString("frmCreateNewClasslabelClassName")));
        btnCreate.setText((myResourceBundle.getString("frmCreateNewClassbtnCreate")));
        btnExit.setText((myResourceBundle.getString("frmCreateNewClassbtnExit")));
        txtClassIDNull = (myResourceBundle.getString("frmCreateNewClasstxtClassIDNull"));
        txtClassNameNull = (myResourceBundle.getString("frmCreateNewClasstxtClassNameNull"));
        MessageDialog = myResourceBundle.getString("frmCreateNewClassMessageDialog");
        MessageClassIDExits = myResourceBundle.getString("frmCreateNewClassMessageClassIDExits");
        MessageClassNameExits = myResourceBundle.getString("frmCreateNewClassMessageClassNameExits");
        MessageCreateSuccess = myResourceBundle.getString("frmCreateNewClassMessageCreateSuccess");
        TableColumOrder = myResourceBundle.getString("frmCreateNewClassTableColumOrder");
        TableColumBatchID = myResourceBundle.getString("frmCreateNewClassTableColumBatchID");
        TableColumBatchName = myResourceBundle.getString("frmCreateNewClassTableColumBatchName");
    }

    public void LoadData() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        vColumn = new Vector();
        vData = new Vector();
        vColumn.add(TableColumOrder);
        vColumn.add(TableColumBatchID);
        vColumn.add(TableColumBatchName);

        try {
            conn = connectDatabase.getConnectTable();
            stmt = conn.createStatement();
            String sql = "SELECT batchid, batchname FROM batch";
            rs = stmt.executeQuery(sql);
            int count = 0;
            while (rs.next()) {
                Vector vRow = new Vector();
                count++;
                vRow.add(count);
                vRow.add(rs.getString("batchid"));
                vRow.add(rs.getString("batchname"));
                vData.add(vRow);
            }

        } catch (SQLException ex) {
            Logger.getLogger(frmCreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmCreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void initTableClass() {
        DefaultTableModel model = new DefaultTableModel(vData, vColumn);
        tableClass.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelClassID = new javax.swing.JLabel();
        txtClassID = new javax.swing.JTextField();
        labelClassName = new javax.swing.JLabel();
        txtClassName = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClass = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create new class");
        setResizable(false);

        labelClassID.setText("Class ID");

        labelClassName.setText("Class name");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/classroom.png"))); // NOI18N

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        tableClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                //        return canEdit [columnIndex];
                return false;
            }
        });
        jScrollPane1.setViewportView(tableClass);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelClassID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelClassName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtClassName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClassID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelClassID)
                            .addComponent(txtClassID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelClassName)
                            .addComponent(txtClassName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        PreparedStatement pstmt = null;
        if (txtClassID.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, txtClassIDNull, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
            txtClassID.requestFocus();
            return;
        }
        if (txtClassName.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, txtClassNameNull, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
            txtClassName.requestFocus();
            return;
        }
        try {
            conn = connectDatabase.getConnectTable();
            String sql = "SELECT batchid, batchname FROM batch";
            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, txtClassID.getText());
//            pstmt.setString(2, txtClassName.getText());
            try (ResultSet rs = pstmt.executeQuery()) {
                ArrayList<batch> arrayListBatch = new ArrayList<>();
                while (rs.next()) {
                    arrayListBatch.add(new batch(rs.getString("batchid"), rs.getString("batchname")));
//                    JOptionPane.showMessageDialog(this, MessageClassIDExits, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
//                    return;
                }
                for (batch object : arrayListBatch) {
                    if (object.getBatchID().equalsIgnoreCase(txtClassID.getText().trim())) {
                        JOptionPane.showMessageDialog(this, MessageClassIDExits, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if (object.getBatchName().equalsIgnoreCase(txtClassName.getText().trim())) {
                        JOptionPane.showMessageDialog(this, MessageClassNameExits, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmCreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "INSERT INTO batch values(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, txtClassID.getText().trim());
            pstmt.setString(2, txtClassName.getText().trim());
            pstmt.executeUpdate();
            Vector vRow = new Vector();
            vRow.add(vData.size()+1);
            vRow.add(txtClassID.getText().trim());
            vRow.add(txtClassName.getText().trim());
            vData.add(vRow);
            DefaultTableModel model = new DefaultTableModel(vData, vColumn);
            tableClass.setModel(model);
            JOptionPane.showMessageDialog(this, MessageCreateSuccess, MessageDialog, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(frmCreateNewClass.class.getName()).log(Level.SEVERE, null, ex);
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
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
//        for (Object object : vData) {
//            System.out.println(object.toString().contains(txtSearch.getText()));
//        }
        Vector vColumnTemp = new Vector();
        Vector vDataTemp = new Vector();

        vColumnTemp.add(TableColumOrder);
        vColumnTemp.add(TableColumBatchID);
        vColumnTemp.add(TableColumBatchName);

        for (int i = 0; i < vData.size(); i++) {
            if (vData.get(i).toString().toUpperCase().contains(txtSearch.getText().toUpperCase())) {
                vDataTemp.add(vData.get(i));
            }
        }
        DefaultTableModel model = new DefaultTableModel(vDataTemp, vColumnTemp);
        tableClass.setModel(model);
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(frmCreateNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCreateNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCreateNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCreateNewClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCreateNewClass dialog = new frmCreateNewClass(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelClassID;
    private javax.swing.JLabel labelClassName;
    private javax.swing.JTable tableClass;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtClassName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
