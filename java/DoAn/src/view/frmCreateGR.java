/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CheckText;
import controller.Confirm;
import controller.ConnectDatabase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Goods;
import model.GoodsReceipt;
import model.Inventory;

/**
 *
 * @author lnminh
 */
public class frmCreateGR extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdfSQL = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat moneyFormater = new DecimalFormat("###,###,###");
    String currentTime;
    String currentTimeSQL;
    static Vector<Inventory> listInventorys;
    Vector<Vector> listSupplier;
    GoodsReceipt goodsReceipt;
    Vector<String> tableTitle;
    Vector<Vector> tableData = new Vector<>();
    String idGR;
    boolean confirm = false;
    Vector<Goods> updateInventorys;

    /**
     * Creates new form frmCreateGR
     */
    public frmCreateGR() {
        initComponents();
        loadData();
        addWindowListener(Confirm.disposeListener(this));
    }

    private void loadData() {
        setDefaultValue();
        loadInventory();
        loadSupplier();
        loadTableTitle();
        showOnTable();
    }

    private void getCurrentTime() {

        currentTime = sdf.format((new Date()).getTime());
        currentTimeSQL = sdfSQL.format((new Date()).getTime());
    }

    private void setDefaultValue() {
        goodsReceipt = new GoodsReceipt();
        goodsReceipt.setGRdetail(new Vector<Goods>());
        getCurrentTime();
        txtTime.setText(currentTime);
        txtNum.setText("0");
        txtPrice.setText("0");
    }

    private void loadInventory() {
        listInventorys = new Vector<>();
        cbGoods.removeAllItems();
        String sql = "{call sp_getInventory}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                listInventorys.add(new Inventory(rs.getString("maSP"), rs.getString("tenSP"), rs.getInt("soLuong")));
                cbGoods.addItem(rs.getString("tenSP"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu");
        }
    }

    private void loadSupplier() {

        listSupplier = new Vector<>();
        cbSupplier.removeAllItems();
        String sql = "{call sp_getSupIDAndName}";
        try (Connection conn = ConnectDatabase.getConnectDatabase();
                CallableStatement cstmt = conn.prepareCall(sql);
                ResultSet rs = cstmt.executeQuery()) {
            while (rs.next()) {
                Vector temp = new Vector();
                temp.add(rs.getString("maNCC"));
                temp.add(rs.getString("tenNCC"));
                listSupplier.add(temp);
                cbSupplier.addItem(rs.getString("tenNCC"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCreateGR = new javax.swing.JPanel();
        scGR = new javax.swing.JScrollPane();
        tblGR = new javax.swing.JTable();
        btnDel = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblSupplier = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        cbSupplier = new javax.swing.JComboBox<>();
        lblGoods = new javax.swing.JLabel();
        cbGoods = new javax.swing.JComboBox<>();
        lblPrice = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblTotal = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        pnCreateGR.setBackground(new java.awt.Color(232, 134, 96));

        tblGR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scGR.setViewportView(tblGR);

        btnDel.setBackground(new java.awt.Color(255, 255, 255));
        btnDel.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnDel.setForeground(new java.awt.Color(0, 0, 0));
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/del_button.png"))); // NOI18N
        btnDel.setText("Xóa");
        btnDel.setContentAreaFilled(false);
        btnDel.setOpaque(true);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        txtID.setColumns(20);
        txtID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        lblID.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblID.setForeground(new java.awt.Color(51, 51, 51));
        lblID.setText("Mã đơn nhập");
        lblID.setToolTipText("");

        lblSupplier.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblSupplier.setForeground(new java.awt.Color(51, 51, 51));
        lblSupplier.setText("Nhà cung cấp");
        lblSupplier.setToolTipText("");

        lblTime.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(51, 51, 51));
        lblTime.setText("Ngày Nhập");
        lblTime.setToolTipText("");

        txtTime.setEditable(false);
        txtTime.setColumns(20);
        txtTime.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        cbSupplier.setBackground(new java.awt.Color(255, 255, 255));
        cbSupplier.setEditable(true);
        cbSupplier.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbSupplier.setForeground(new java.awt.Color(0, 0, 0));
        cbSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblGoods.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblGoods.setForeground(new java.awt.Color(51, 51, 51));
        lblGoods.setText("Sản phẩm");
        lblGoods.setToolTipText("");

        cbGoods.setBackground(new java.awt.Color(255, 255, 255));
        cbGoods.setEditable(true);
        cbGoods.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        cbGoods.setForeground(new java.awt.Color(0, 0, 0));
        cbGoods.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblPrice.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPrice.setForeground(new java.awt.Color(51, 51, 51));
        lblPrice.setText("Đơn Giá");
        lblPrice.setToolTipText("");

        lblNum.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNum.setForeground(new java.awt.Color(51, 51, 51));
        lblNum.setText("Số lượng");
        lblNum.setToolTipText("");

        txtPrice.setColumns(20);
        txtPrice.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/down_arrow_button.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setOpaque(true);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnAccept.setBackground(new java.awt.Color(255, 255, 255));
        btnAccept.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnAccept.setForeground(new java.awt.Color(0, 0, 0));
        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accept_button.png"))); // NOI18N
        btnAccept.setText("Chấp nhận");
        btnAccept.setContentAreaFilled(false);
        btnAccept.setOpaque(true);
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        txtTotal.setColumns(20);
        txtTotal.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(51, 51, 51));
        lblTotal.setText("Tổng Tiền");
        lblTotal.setToolTipText("");

        txtNum.setColumns(20);
        txtNum.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnCreateGRLayout = new javax.swing.GroupLayout(pnCreateGR);
        pnCreateGR.setLayout(pnCreateGRLayout);
        pnCreateGRLayout.setHorizontalGroup(
            pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCreateGRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCreateGRLayout.createSequentialGroup()
                        .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCreateGRLayout.createSequentialGroup()
                                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCreateGRLayout.createSequentialGroup()
                                .addComponent(lblGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime)
                            .addComponent(lblNum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnCreateGRLayout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDel))
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(cbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCreateGRLayout.createSequentialGroup()
                        .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scGR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
        );
        pnCreateGRLayout.setVerticalGroup(
            pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCreateGRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGoods, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGoods, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDel)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pnCreateGRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCreateGRLayout.createSequentialGroup()
                    .addContainerGap(124, Short.MAX_VALUE)
                    .addComponent(scGR, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCreateGR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCreateGR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addTolistGoods();
        loadTableTitle();
        loadTableData();
        showOnTable();
    }//GEN-LAST:event_btnAddActionPerformed
    private void addTolistGoods() {

        int index = cbGoods.getSelectedIndex();
        String snum = txtNum.getText().trim();
        String sprice = txtPrice.getText().trim();
        String name = listInventorys.get(index).getName();
        String id = listInventorys.get(index).getID();

        if (snum.equalsIgnoreCase("")
                || sprice.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền vào đầy đủ thông tin");
            return;

        }

        if (!CheckText.isInteger(snum)
                || !CheckText.isInteger(sprice)) {
            JOptionPane.showMessageDialog(this, "Hãy điền đúng kiểu thông tin");
            return;
        }

        int num = Integer.valueOf(snum);
        int price = Integer.valueOf(sprice);
        for (Goods goods : goodsReceipt.getGRdetail()) {
            if (goods.getGoodsID().equalsIgnoreCase(id)) {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã được chọn");
                return;
            }
        }

        goodsReceipt.getGRdetail().add(new Goods(id, name, num, price));
        long total=0;
        for (Goods goods : goodsReceipt.getGRdetail()) {
            total+=goods.getNum()*goods.getPrice();
        }
        txtTotal.setText(Long.toString(total));

    }

    private void loadTableTitle() {
        tableTitle = new Vector<>();
        tableTitle.add("Mã sản phẩm");
        tableTitle.add("Tên sản phẩm");
        tableTitle.add("Số lượng");
        tableTitle.add("Đơn giá");

    }

    private void loadTableData() {
        tableData = new Vector<>();
        for (Goods goods : goodsReceipt.getGRdetail()) {
            Vector<String> temp = new Vector<>();
            temp.add(goods.getGoodsID());
            temp.add(goods.getGoodsName());
            temp.add(Integer.toString(goods.getNum()));
            temp.add(moneyFormater.format(goods.getPrice()));
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
        tblGR.setModel(dtm);
    }


    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        
        insertGRToDatabase();
        insertGRDetail();
        loadInventory();
        loadGRDetailData();
        sumGoodsNum();
        updateInventory();
        JOptionPane.showMessageDialog(this, "Đã xử lý xong.\n"
                + "Chuyển sang về lại màn hình đơn nhập để cập nhật dữ liệu mới");
    }//GEN-LAST:event_btnAcceptActionPerformed
    
    
    private void insertGRToDatabase() {
        idGR = txtID.getText().trim();
        if (idGR.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Hãy điền vào đầy đủ thông tin");
            return;
        }
        int index = cbSupplier.getSelectedIndex();
        Vector supplier = listSupplier.get(index);
        String idSup = (String) supplier.get(0);

        try (Connection conn = ConnectDatabase.getConnectDatabase()) {
            String sql = "{call sp_addGR(?,?,?)}";
            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, idGR);
                cstmt.setDate(2, java.sql.Date.valueOf(currentTimeSQL));
                cstmt.setString(3, idSup);
                cstmt.executeUpdate();
                confirm = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "lỗi thêm dữ liệu");
        }
        

    }

    private void insertGRDetail() {
        if (!confirm) {
            return;
        }
        for (Goods goods : goodsReceipt.getGRdetail()) {
            try (Connection conn = ConnectDatabase.getConnectDatabase()) {
                String sql = "{call sp_addGRDetails(?,?,?,?)}";
                try (CallableStatement cstmt = conn.prepareCall(sql)) {

                    cstmt.setString(1, idGR);
                    cstmt.setString(2, goods.getGoodsID());
                    cstmt.setInt(3, goods.getNum());
                    cstmt.setInt(4, goods.getPrice());
                    cstmt.executeUpdate();

                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "lỗi thêm dữ liệu");
            }
        }
        confirm = false;
    }

    private void loadGRDetailData() {
        updateInventorys = new Vector<>();

        String sql = "{call sp_getGRDetails(?)}";
        try (Connection conn = ConnectDatabase.getConnectDatabase(); CallableStatement cstmt = conn.prepareCall(sql)) {
            cstmt.setString(1, idGR);

            try (ResultSet rs = cstmt.executeQuery()) {

                while (rs.next()) {
                    updateInventorys.add(new Goods(
                            rs.getString("maSP"), rs.getString("tenSP"), rs.getInt("soLuongNhap"), rs.getInt("giaNhap")));

                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "lỗi tải dữ liệu");
        }

    }
    
    private void sumGoodsNum() {
           
           for (Goods goods : updateInventorys) {
               for (Inventory inventory : listInventorys) {
                   if (inventory.getID().equalsIgnoreCase(goods.getGoodsID())) {
                       int num=inventory.getNumInventory()+goods.getNum();
                       goods.setNum(num);
                   }
               }
             
           }
    }
    private void updateInventory(){
        for (Goods  goods : updateInventorys) {
             try (Connection conn = ConnectDatabase.getConnectDatabase()) {
                String sql = "{call sp_updateInventory(?,?)}";
                try (CallableStatement cstmt = conn.prepareCall(sql)) {

                    cstmt.setString(1, goods.getGoodsID());
                    cstmt.setInt(2, goods.getNum());
                    cstmt.executeUpdate();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "lỗi cập nhật dữ liệu");
            }
        }
    }

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        delFromListGoods();
        loadTableTitle();
        loadTableData();
        showOnTable();
    }//GEN-LAST:event_btnDelActionPerformed

    private void delFromListGoods() {
        int selectedRow = tblGR.getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        goodsReceipt.getGRdetail().remove(selectedRow);

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
            java.util.logging.Logger.getLogger(frmCreateGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCreateGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCreateGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCreateGR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCreateGR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDel;
    private javax.swing.JComboBox<String> cbGoods;
    private javax.swing.JComboBox<String> cbSupplier;
    private javax.swing.JLabel lblGoods;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnCreateGR;
    private javax.swing.JScrollPane scGR;
    private javax.swing.JTable tblGR;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables


 

}
