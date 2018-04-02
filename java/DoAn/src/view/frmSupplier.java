/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Confirm;
import controller.ConnectDatabase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Supplier;

/**
 *
 * @author lnminh
 */
public class frmSupplier extends javax.swing.JFrame {
    static Vector<String> tableTitle;
    static Vector<Vector> tableData;
    static Vector<Supplier> listSuppliers;
   
public frmSupplier() {
        initComponents();
        loadData();
        addWindowListener(Confirm.disposeListener(this));
    }
private void loadData() {
        loadTableTitle();
        loadTableData();
        showOnTable();
    }
private void loadTableTitle() {
        tableTitle = new Vector<>();
        tableTitle.add("Mã Nhà Cung Cấp");
        tableTitle.add("Tên Nhà Cung Cấp");
        tableTitle.add("Địa Chỉ");
        tableTitle.add("Số Điện Thoại");
    
    }

    private void loadTableData() {
        tableData = new Vector<>();
        listSuppliers = new Vector<>();

        String sql = "{call sp_getSupplier}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                listSuppliers.add(new Supplier(rs.getString("maNCC"), rs.getString("tenNCC"), rs.getString("diaChiNCC"),rs.getString("sdtNCC")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu");
        }
        for (Supplier supplier : listSuppliers) {
            Vector<String> temp = new Vector<>();
            temp.add(supplier.getID());
            temp.add(supplier.getName());
            temp.add(supplier.getAddress());
            temp.add(supplier.getPhoneNumber());
            tableData.add(temp);
        }
        
    }

    private void showOnTable() {
        DefaultTableModel dtm = new DefaultTableModel(tableData, tableTitle) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblSupplier.setModel(dtm);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSupplier = new javax.swing.JPanel();
        scSupplier = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtPhoneNum = new javax.swing.JTextField();
        lblPhoneNum = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnSupplier.setBackground(new java.awt.Color(27, 112, 218));

        tblSupplier.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        scSupplier.setViewportView(tblSupplier);

        lblID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(51, 51, 51));
        lblID.setText("Mã nhà cung cấp");
        lblID.setToolTipText("");

        txtID.setColumns(20);

        txtName.setColumns(20);

        lblName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 51, 51));
        lblName.setText("Tên nhà cung cấp");
        lblName.setToolTipText("");

        txtPhoneNum.setColumns(20);

        lblPhoneNum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPhoneNum.setForeground(new java.awt.Color(51, 51, 51));
        lblPhoneNum.setText("Số điện thoại");
        lblPhoneNum.setToolTipText("");

        lblAddress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(51, 51, 51));
        lblAddress.setText("Địa chỉ");
        lblAddress.setToolTipText("");

        txtAddress.setColumns(20);

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/del_button.png"))); // NOI18N
        btnDel.setText("Xóa");
        btnDel.setContentAreaFilled(false);
        btnDel.setOpaque(true);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_button.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/supplier.png"))); // NOI18N

        javax.swing.GroupLayout pnSupplierLayout = new javax.swing.GroupLayout(pnSupplier);
        pnSupplier.setLayout(pnSupplierLayout);
        pnSupplierLayout.setHorizontalGroup(
            pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSupplierLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnSupplierLayout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSupplierLayout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 38, Short.MAX_VALUE)
                .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSupplierLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnSupplierLayout.createSequentialGroup()
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAddress))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnSupplierLayout.createSequentialGroup()
                            .addComponent(lblPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPhoneNum))))
                .addGap(80, 80, 80))
            .addComponent(scSupplier)
        );
        pnSupplierLayout.setVerticalGroup(
            pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSupplierLayout.createSequentialGroup()
                .addComponent(scSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSupplierLayout.createSequentialGroup()
                        .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnSupplierLayout.createSequentialGroup()
                        .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblIcon))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
       showToEditText();
// TODO add your handling co
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addNewSupplier();
       loadData();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
       delSupplier();
       loadData();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelActionPerformed
    private void showToEditText() {
        int selectedRow = tblSupplier.getSelectedRow();
        txtID.setText((String) tblSupplier.getValueAt(selectedRow, 0));
        txtName.setText((String) tblSupplier.getValueAt(selectedRow, 1));
        txtAddress.setText((String) tblSupplier.getValueAt(selectedRow, 2));
        txtPhoneNum.setText((String) tblSupplier.getValueAt(selectedRow, 3));
    }
    
    private void addNewSupplier(){
        if (txtID.getText().trim().equalsIgnoreCase("")||
                txtName.getText().trim().equalsIgnoreCase("")||
                txtAddress.getText().trim().equalsIgnoreCase("")||
                txtPhoneNum.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Xin điền đầy đủ các thông tin");
            txtID.requestFocus();
            return;
        }
        String sql = "{call sp_addNewSupplier(?,?,?,?)}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);) {
            cstmt.setString(1, txtID.getText());
            cstmt.setString(2, txtName.getText());
            cstmt.setString(3, txtAddress.getText());
            cstmt.setString(4, txtPhoneNum.getText());
            cstmt.executeUpdate();
        } catch (SQLException ex) {
            if (ex.getMessage().contains("duplicate key")) {
                JOptionPane.showMessageDialog(this, "Lỗi trùng dữ liệu");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi thêm dữ liệu \n" + ex.getMessage());
            }
        }
    }
    
    private void delSupplier() {
        if (txtID.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Xin điền mã nhà cung cấp cần xóa");
            txtID.requestFocus();
            return;
        }
        String sql = "{call sp_delSupplier(?)}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);) {
            cstmt.setString(1, txtID.getText());
            cstmt.executeUpdate();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(this, "Lỗi xóa dữ liệu \n" + ex.getMessage());
        }
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhoneNum;
    private javax.swing.JPanel pnSupplier;
    private javax.swing.JScrollPane scSupplier;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNum;
    // End of variables declaration//GEN-END:variables

    
}
