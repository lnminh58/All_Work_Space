/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConnectDatabase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Goods;
import model.GoodsReceipt;
import model.Order;
import static view.frmGRList.selectedIndex;
import static view.frmGRList.tableGRData;

/**
 *
 * @author lnminh
 */
public class frmOrderList extends javax.swing.JFrame {

    static DecimalFormat moneyFormater = new DecimalFormat("###,###,###");
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static Vector<String> tableOrderTitle;
    static Vector<Vector> tableOrderData;
    static Vector<Order> listOrder;
    static Vector<String> tableOrderDetailTitle;
    static Vector<Vector> tableOrderDetailData;
    static HashMap<String, String> listEmp;
    static int selectedIndex;
    static long total;

    /**
     * Creates new form NewJFrame
     */
    public frmOrderList() {
        initComponents();
        loadData();
    }

    private void loadData() {
        loadListEmp();
        loadTableOrder();
        loadTableOrderDetailTitle();
        tableOrderDetailData= new Vector<>();
        showOnOrderDetailTable();

    }

    private void loadTableOrder() {
        loadTableOrderTitle();
        loadTableOrderData();
        showOnOderTable();
    }

    private void loadListEmp() {
        listEmp = new HashMap<>();

        try (Connection conn = ConnectDatabase.getConnectDatabase()) {
            String sql = "{call sp_getEmpIDAndName}";
            try (CallableStatement cstmt = conn.prepareCall(sql); ResultSet rs = cstmt.executeQuery()) {
                while (rs.next()) {
                    String key = rs.getString("maNV");
                    String value = rs.getString("tenNV");
                    listEmp.put(key, value);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "lỗi tải dữ liệu");
        }
    }

    private void loadTableOrderTitle() {
        tableOrderTitle = new Vector<>();
        tableOrderTitle.add("Mã Phiếu Xuất");
        tableOrderTitle.add("Ngày Xuất");
        tableOrderTitle.add("Khách Hàng");
        tableOrderTitle.add("Nhân Viên Bán Hàng");
        tableOrderTitle.add("Nhân Viên Giao Hàng");
    }

    private void loadTableOrderData() {
        tableOrderData = new Vector<>();
        listOrder = new Vector<>();

        String sql = "{call sp_getOrder}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                listOrder.add(new Order(rs.getString("maPX"),
                        rs.getDate("ngayXuat"),
                        rs.getString("tenKH"),
                        rs.getString("maNVBanHang"),
                        rs.getString("maNVGiaoHang")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu");
        }

        for (Order order : listOrder) {
            Vector<String> temp = new Vector<>();
            temp.add(order.getID());
            temp.add(sdf.format(order.getTime()));
            temp.add(order.getCustomer());
            temp.add(listEmp.get(order.getSalerID()));
            temp.add(listEmp.get(order.getShipperID()));
            tableOrderData.add(temp);

        }
    }

    private void showOnOderTable() {
        DefaultTableModel dtm = new DefaultTableModel(tableOrderData, tableOrderTitle) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblOrderList.setModel(dtm);
    }

    private void loadTableOrderDetail() {
        loadTableOrderDetailTitle();
        try {
            loadTableOrderDetailData(selectedIndex);
        } catch (Exception e) {
            
        }
        showOnOrderDetailTable();
    }

    private void loadTableOrderDetailTitle() {
        tableOrderDetailTitle = new Vector<>();
        tableOrderDetailTitle.add("Mã Sản Phẩm");
        tableOrderDetailTitle.add("Tên Sản Phẩm");
        tableOrderDetailTitle.add("Số Lượng Xuất");
        tableOrderDetailTitle.add("Đơn Giá");
    }

    private void loadTableOrderDetailData(int selectedIndex) {
        tableOrderDetailData = new Vector<>();

        String sql = "{call sp_getOrderDetails(?)}";
        try (Connection conn = ConnectDatabase.getConnectDatabase(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, listOrder.get(selectedIndex).getID());

            try (ResultSet rs = cstmt.executeQuery()) {
                listOrder.get(selectedIndex).setOrderdetail(new Vector<>());

                while (rs.next()) {
                    listOrder.get(selectedIndex).getOrderdetail().add(new Goods(
                            rs.getString("maSP"), rs.getString("tenSP"), rs.getInt("soLuongXuat"), rs.getInt("giaXuat")));

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "lỗi tải dữ liệu");
        }
        total = 0;
        for (Goods goods : listOrder.get(selectedIndex).getOrderdetail()) {
            Vector<String> temp = new Vector<>();
            temp.add(goods.getGoodsID());
            temp.add(goods.getGoodsName());
            temp.add(Integer.toString(goods.getNum()));
            temp.add(moneyFormater.format(goods.getPrice()));
            total += goods.getNum() * goods.getPrice();
            tableOrderDetailData.add(temp);
        }

    }

    private void showOnOrderDetailTable() {
        DefaultTableModel dtm = new DefaultTableModel(tableOrderDetailData, tableOrderDetailTitle) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblListDetail.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnOrderList = new javax.swing.JPanel();
        spOrderList = new javax.swing.JSplitPane();
        pnList = new javax.swing.JPanel();
        scList = new javax.swing.JScrollPane();
        tblOrderList = new javax.swing.JTable();
        pnDetail = new javax.swing.JPanel();
        scDetail = new javax.swing.JScrollPane();
        tblListDetail = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnCreateNew = new javax.swing.JButton();
        lblIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnOrderList.setBackground(new java.awt.Color(27, 157, 221));

        spOrderList.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        spOrderList.setOneTouchExpandable(true);

        pnList.setMinimumSize(new java.awt.Dimension(0, 200));

        tblOrderList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblOrderList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderListMouseClicked(evt);
            }
        });
        scList.setViewportView(tblOrderList);

        javax.swing.GroupLayout pnListLayout = new javax.swing.GroupLayout(pnList);
        pnList.setLayout(pnListLayout);
        pnListLayout.setHorizontalGroup(
            pnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        pnListLayout.setVerticalGroup(
            pnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        spOrderList.setTopComponent(pnList);

        tblListDetail.setModel(new javax.swing.table.DefaultTableModel(
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
        scDetail.setViewportView(tblListDetail);

        javax.swing.GroupLayout pnDetailLayout = new javax.swing.GroupLayout(pnDetail);
        pnDetail.setLayout(pnDetailLayout);
        pnDetailLayout.setHorizontalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        pnDetailLayout.setVerticalGroup(
            pnDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scDetail, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
        );

        spOrderList.setRightComponent(pnDetail);

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal.setText("Tổng Tiền");
        lblTotal.setToolTipText("");

        txtTotal.setColumns(20);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnCreateNew.setBackground(new java.awt.Color(255, 255, 255));
        btnCreateNew.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnCreateNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_button.png"))); // NOI18N
        btnCreateNew.setText("Tạo bảng mới");
        btnCreateNew.setContentAreaFilled(false);
        btnCreateNew.setOpaque(true);
        btnCreateNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewActionPerformed(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sale.png"))); // NOI18N

        javax.swing.GroupLayout pnOrderListLayout = new javax.swing.GroupLayout(pnOrderList);
        pnOrderList.setLayout(pnOrderListLayout);
        pnOrderListLayout.setHorizontalGroup(
            pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spOrderList)
            .addGroup(pnOrderListLayout.createSequentialGroup()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnCreateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotal)
                .addGap(30, 30, 30)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        pnOrderListLayout.setVerticalGroup(
            pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnOrderListLayout.createSequentialGroup()
                .addComponent(spOrderList, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnOrderListLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnOrderListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCreateNew, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnOrderListLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnOrderList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreateNewActionPerformed

    private void tblOrderListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderListMouseClicked
        // TODO add your handling code here:
        showOnDetailTable();
    }//GEN-LAST:event_tblOrderListMouseClicked

    private void showOnDetailTable() {
        selectedIndex = tblOrderList.getSelectedRow();
        loadTableOrderDetail();
        txtTotal.setText(moneyFormater.format(total));
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
            java.util.logging.Logger.getLogger(frmOrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmOrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmOrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmOrderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmOrderList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateNew;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnDetail;
    private javax.swing.JPanel pnList;
    private javax.swing.JPanel pnOrderList;
    private javax.swing.JScrollPane scDetail;
    private javax.swing.JScrollPane scList;
    private javax.swing.JSplitPane spOrderList;
    private javax.swing.JTable tblListDetail;
    private javax.swing.JTable tblOrderList;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
