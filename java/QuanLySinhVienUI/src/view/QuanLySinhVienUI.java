/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConnectDatabase;
import controller.DatabaseManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Student;

/**
 *
 * @author lnmin
 */
public class QuanLySinhVienUI extends javax.swing.JFrame {

    Vector<String> tableTitle;
    Vector<Vector> tableData;
    Vector<Student> listStudent;

    /**
     * Creates new form QuanLySinhVienUi
     */
    public QuanLySinhVienUI() {
        initComponents();
        showWindow();
        showOnTable();
    }

    public void showWindow() {
        setLocationRelativeTo(null);
    }

    public void setTitle() {
        tableTitle = new Vector<>();
        tableTitle.add("ID");
        tableTitle.add("Name");
        tableTitle.add("Gender");
        tableTitle.add("Class ID");
    }

    public void setData() {
        tableData = new Vector<>();
        listStudent = new Vector<>();
        try (Connection conn = ConnectDatabase.getConnectDatabase(); Statement stmt = conn.createStatement();) {
            String sql = "Select * from student";
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    listStudent.add(new Student(
                            rs.getString("id"),
                            rs.getString("name"),
                            rs.getBoolean("gender"),
                            rs.getString("classid")));
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Load data fail!!!");
        }

        for (Student st : listStudent) {
            Vector temp = new Vector();
            temp.add(st.getId());
            temp.add(st.getName());
            if (st.isGender()) {
                temp.add("M");
            } else {
                temp.add("F");
            }
            temp.add(st.getClassID());
            tableData.add(temp);
        }
    }

    public void showOnTable() {
        setTitle();
        setData();
        DefaultTableModel dtm = new DefaultTableModel(tableData, tableTitle) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblStudent.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupGender = new javax.swing.ButtonGroup();
        pnMain = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        pnIDName = new javax.swing.JPanel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        lblStudentName = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        pnSexClass = new javax.swing.JPanel();
        lblGender = new javax.swing.JLabel();
        radMale = new javax.swing.JRadioButton();
        radFemale = new javax.swing.JRadioButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        lblClassID = new javax.swing.JLabel();
        txtClassID = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        pnBottom = new javax.swing.JPanel();
        scTable = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();

        groupGender.add(radFemale);
        groupGender.add(radMale);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Manager");

        pnMain.setMinimumSize(new java.awt.Dimension(800, 600));
        pnMain.setPreferredSize(new java.awt.Dimension(800, 600));
        pnMain.setLayout(new javax.swing.BoxLayout(pnMain, javax.swing.BoxLayout.Y_AXIS));

        pnTop.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Student Informations", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pnTop.setPreferredSize(new java.awt.Dimension(1000, 100));
        pnTop.setLayout(new javax.swing.BoxLayout(pnTop, javax.swing.BoxLayout.Y_AXIS));

        pnIDName.setMinimumSize(new java.awt.Dimension(380, 20));
        pnIDName.setPreferredSize(new java.awt.Dimension(1000, 50));
        pnIDName.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        lblStudentID.setText("Student ID");
        pnIDName.add(lblStudentID);

        txtStudentID.setColumns(20);
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        pnIDName.add(txtStudentID);
        pnIDName.add(jSeparator2);
        pnIDName.add(jSeparator3);
        pnIDName.add(jSeparator4);
        pnIDName.add(jSeparator1);

        lblStudentName.setText("Student Name");
        pnIDName.add(lblStudentName);

        txtStudentName.setColumns(20);
        txtStudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentNameActionPerformed(evt);
            }
        });
        pnIDName.add(txtStudentName);

        btnAdd.setText("ADD");
        btnAdd.setPreferredSize(new java.awt.Dimension(71, 25));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnIDName.add(btnAdd);

        pnTop.add(pnIDName);

        pnSexClass.setPreferredSize(new java.awt.Dimension(800, 50));
        pnSexClass.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        lblGender.setText("Gender");
        lblGender.setPreferredSize(new java.awt.Dimension(49, 15));
        pnSexClass.add(lblGender);

        radMale.setText("Male");
        radMale.setPreferredSize(new java.awt.Dimension(75, 23));
        pnSexClass.add(radMale);

        radFemale.setText("Female");
        radFemale.setPreferredSize(new java.awt.Dimension(75, 23));
        radFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFemaleActionPerformed(evt);
            }
        });
        pnSexClass.add(radFemale);
        pnSexClass.add(jSeparator6);
        pnSexClass.add(jSeparator8);
        pnSexClass.add(jSeparator9);
        pnSexClass.add(jSeparator5);

        lblClassID.setText("Class ID");
        lblClassID.setPreferredSize(new java.awt.Dimension(67, 15));
        pnSexClass.add(lblClassID);

        txtClassID.setColumns(20);
        pnSexClass.add(txtClassID);

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnSexClass.add(btnDelete);

        pnTop.add(pnSexClass);

        pnMain.add(pnTop);

        pnBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "List Student", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        pnBottom.setPreferredSize(new java.awt.Dimension(1000, 400));
        pnBottom.setLayout(new java.awt.BorderLayout());

        scTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scTable.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scTableMouseClicked(evt);
            }
        });

        tblStudent.setModel(new javax.swing.table.DefaultTableModel(
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
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        scTable.setViewportView(tblStudent);

        pnBottom.add(scTable, java.awt.BorderLayout.CENTER);

        pnMain.add(pnBottom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentNameActionPerformed

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void radFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radFemaleActionPerformed

    private void scTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scTableMouseClicked

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        showOnInfoFrame();

    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addStudent();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        deleteStudent();
    }//GEN-LAST:event_btnDeleteActionPerformed
    private boolean isExistStudent(String id) {
        for (Student st : listStudent) {
            if (st.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private void clearFields() {
        txtStudentID.setText(null);
        txtStudentName.setText(null);
        txtClassID.setText(null);
        radMale.setSelected(true);
    }

    private void deleteStudent() {
        String id = txtStudentID.getText();
        if (isExistStudent(id)) {
            DatabaseManager.deleteStudent(id);
            clearFields();
            showOnTable();
        }else{
            JOptionPane.showMessageDialog(null, "ID not exist");
        }
    }

    private void addStudent() {
        String id = txtStudentID.getText();
        String name = txtStudentName.getText();
        String classID = txtClassID.getText();
        boolean selected = radMale.isSelected();
        if ((radFemale.isSelected() || radMale.isSelected())
                && !id.trim().equalsIgnoreCase("")
                && !name.trim().equalsIgnoreCase("")
                && !classID.trim().equalsIgnoreCase("")) {
            if (isExistStudent(id)) {
                JOptionPane.showMessageDialog(null, "ID existed");
                return;
            } else {
                DatabaseManager.addStudent(new Student(id, name, selected, classID));
                showOnTable();
                clearFields();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fill all fields before add");
        }

    }

    private void showOnInfoFrame() {
        int selectedRow = tblStudent.getSelectedRow();
        txtStudentID.setText((String) tblStudent.getValueAt(selectedRow, 0));
        txtStudentName.setText((String) tblStudent.getValueAt(selectedRow, 1));
        if (tblStudent.getValueAt(selectedRow, 2).toString().equalsIgnoreCase("M")) {
            radMale.setSelected(true);
        } else {
            radFemale.setSelected(true);
        }
        txtClassID.setText((String) tblStudent.getValueAt(selectedRow, 3));
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
            java.util.logging.Logger.getLogger(QuanLySinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVienUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVienUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup groupGender;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblClassID;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lblStudentName;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnIDName;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnSexClass;
    private javax.swing.JPanel pnTop;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private javax.swing.JScrollPane scTable;
    private javax.swing.JTable tblStudent;
    private javax.swing.JTextField txtClassID;
    private javax.swing.JTextField txtStudentID;
    private javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables

}
