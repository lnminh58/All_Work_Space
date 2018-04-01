/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TableBatchButtonEditor;
import controller.TableBatchButtonRenderer;
import controller.TableStudentButtonEditor;
import controller.TableStudentButtonRenderer;

import controller.controllerBatch;
import controller.controllerStudent;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import model.modelBatch;
import model.modelStudent;
import util.myUtil;

/**
 *
 * @author nguyenducthao
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmMain
     */
    public static Vector tableBatchHeader = new Vector();
    public static Vector tableBatchData = new Vector();
    public static Vector tableStudentHeader = new Vector();
    public static Vector tableStudentData = new Vector();
    public static ArrayList<modelStudent> arrayListAllStudent = new ArrayList<>();
    public static ArrayList<String> arrayFileNameAvatar = new ArrayList<>();
    public static HashMap<String, String> mapBatchCodeBatchName = new HashMap<String, String>();
    public static HashMap<String, String> mapBatchNameBatchCode = new HashMap<String, String>();
    public static String oldBatchName = "";
    public static File fileNameAvatar;
    public static modelStudent student = null;

    public frmMain() throws ClassNotFoundException, SQLException, IOException, FileNotFoundException, InterruptedException, ParseException {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("images/frmMainIcon.png")));
        panelAction.add(panelBatch, "panelBatch");
        panelAction.add(panelStudent, "panelStudent");
        loadHeaderForTableBatch();
        loadDataForTableBatch();
        showDataToTableBatch();
        loadHeaderForTableStudent();
        loadDataForTableStudent();
        showDataToTableStudent();
        loadDataForComboboxBatch();
    }

    public static void loadHeaderForTableBatch() {
        tableBatchHeader.add("No.");
        tableBatchHeader.add("Batch code");
        tableBatchHeader.add("Batch name");
        tableBatchHeader.add("Action");
    }

    public static void loadDataForTableBatch() throws ClassNotFoundException, SQLException {
        ResultSet rs = controllerBatch.getAllBatchCodeAndBatchName();
        int count = 0;
        tableBatchData.clear();
        while (rs.next()) {
            Vector vTemp = new Vector();
            count++;
            vTemp.add(count);
            vTemp.add(rs.getString("batchcode"));
            vTemp.add(rs.getString("batchname"));
            vTemp.add("Delete");
            tableBatchData.add(vTemp);
        }
    }

    public static void showDataToTableBatch() {
        DefaultTableModel model = new DefaultTableModel(tableBatchData, tableBatchHeader) {
            public Class getColumnClass(int col) {
                Vector vTemp = new Vector();
                vTemp = (Vector) tableBatchData.elementAt(0);
                return vTemp.elementAt(col).getClass();
//                return allData[col][0].getClass();
            }

            public boolean isCellEditable(int row, int col) {
                if (col == 3) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        tblBatch.setModel(model);
        tblBatch.getColumn("Action").setCellRenderer(new TableBatchButtonRenderer());
        tblBatch.getColumn("Action").setCellEditor(new TableBatchButtonEditor(new JCheckBox()));
        tblBatch.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblBatch.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblBatch.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblBatch.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblBatch.getColumnModel().getColumn(3).setPreferredWidth(88);
    }

    static void updateDataForTableBatch_Edit() {
        for (int i = 0; i < tableBatchData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) tableBatchData.elementAt(i);
            if (vTemp.get(2).toString().equalsIgnoreCase(oldBatchName)) {
                vTemp.set(2, txtBatchName.getText().trim());
            }
            tableBatchData.set(i, vTemp);
        }
        showDataToTableBatch();
    }

    public static void updateDataForTableBatch_Delete() {
        for (int i = 0; i < frmMain.tableBatchData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) frmMain.tableBatchData.elementAt(i);
            if (vTemp.get(0).toString().equalsIgnoreCase(frmMain.tblBatch.getValueAt(frmMain.tblBatch.getSelectedRow(), 0).toString())) {
                frmMain.tableBatchData.remove(i);
            }
        }
        for (int i = 0; i < tableBatchData.size(); i++) {
            Vector vTemp = new Vector();
            vTemp = (Vector) tableBatchData.elementAt(i);
            vTemp.set(0, i + 1);
            tableBatchData.set(i, vTemp);
        }
        frmMain.showDataToTableBatch();

    }

    public static void loadHeaderForTableStudent() {
        tableStudentHeader.add("No.");
        tableStudentHeader.add("Student code");
        tableStudentHeader.add("Student name");
        tableStudentHeader.add("Student gender");
        tableStudentHeader.add("Student birthday");
        tableStudentHeader.add("Batch name");
        tableStudentHeader.add("English mark");
        tableStudentHeader.add("Math mark");
        tableStudentHeader.add("Computer mark");
        tableStudentHeader.add("Action");
    }

    public static void loadArrayListAllStudent() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException, InterruptedException {
        // dang lam
        ResultSet rs = controllerStudent.getAllStudentAllField();
        int count = 0;
        arrayListAllStudent.clear();
        while (rs.next()) {
            arrayListAllStudent.add(new modelStudent(
                    rs.getString("studentCode"),
                    rs.getString("studentName"),
                    rs.getBoolean("studentGender"),
                    rs.getDate("studentBirthday"),
                    rs.getString("batchcode"),
                    rs.getFloat("studentEnglishMark"),
                    rs.getFloat("studentMathMark"),
                    rs.getFloat("studentComputerMark"),
                    rs.getString("filename_avatar"),
                    rs.getBytes("image_avatar")));
            mapBatchCodeBatchName.put(rs.getString("batchcode"), rs.getString("batchname"));
            mapBatchNameBatchCode.put(rs.getString("batchname"), rs.getString("batchcode"));
        }

        for (int i = 0; i < arrayListAllStudent.size(); i++) {
//            OutputStream targetFile = new FileOutputStream("./src/view/temp/" + arrayListAllStudent.get(i).getFilename_avatar());
//            targetFile.write(arrayListAllStudent.get(i).getImage_avatar());
            File fileTemp = new File("");
            OutputStream targetFile = new FileOutputStream(fileTemp.getAbsolutePath() + "/data/images/temp/" + arrayListAllStudent.get(i).getFilename_avatar());
            targetFile.write(arrayListAllStudent.get(i).getImage_avatar());
            targetFile.close();
            Thread.sleep(1000);
        }
        for (int i = 0; i < arrayListAllStudent.size(); i++) {
            arrayFileNameAvatar.add("/view/temp/" + arrayListAllStudent.get(i).getFilename_avatar());
        }
    }

    public static void loadDataForTableStudent() throws ClassNotFoundException, SQLException, IOException, FileNotFoundException, InterruptedException, ParseException {
        loadArrayListAllStudent();
        tableStudentData.clear();
        for (int i = 0; i < arrayListAllStudent.size(); i++) {
            Vector temp = new Vector();
            temp.add(i + 1);
            temp.add(arrayListAllStudent.get(i).getStudentCode());
            temp.add(arrayListAllStudent.get(i).getStudentName());
            temp.add(arrayListAllStudent.get(i).isStudentGender());
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
//            temp.add(arrayListAllStudent.get(i).getStudentBirthday());
            temp.add(format.format(arrayListAllStudent.get(i).getStudentBirthday()));
//            temp.add(arrayListAllStudent.get(i).getBatchCode());
            temp.add(mapBatchCodeBatchName.get(arrayListAllStudent.get(i).getBatchCode()));
            temp.add(arrayListAllStudent.get(i).getStudentEnglishMark());
            temp.add(arrayListAllStudent.get(i).getStudentMathMark());
            temp.add(arrayListAllStudent.get(i).getStudentComputerMark());
            temp.add("Delete");
            tableStudentData.add(temp);
        }
    }

    public static void showDataToTableStudent() {
        DefaultTableModel model = new DefaultTableModel(tableStudentData, tableStudentHeader) {
            public Class getColumnClass(int col) {
                Vector vTemp = new Vector();
                vTemp = (Vector) tableStudentData.elementAt(0);
                return vTemp.elementAt(col).getClass();
//                return allData[col][0].getClass();
            }

            public boolean isCellEditable(int row, int col) {
                if (col == 9) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        tblStudent.setModel(model);
        tblStudent.getColumn("Action").setCellRenderer(new TableStudentButtonRenderer());
        tblStudent.getColumn("Action").setCellEditor(new TableStudentButtonEditor(new JCheckBox()));
        tblStudent.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblStudent.getColumnModel().getColumn(0).setPreferredWidth(30);
        tblStudent.getColumnModel().getColumn(1).setPreferredWidth(75);
        tblStudent.getColumnModel().getColumn(2).setPreferredWidth(120);
        tblStudent.getColumnModel().getColumn(3).setPreferredWidth(85);
        tblStudent.getColumnModel().getColumn(4).setPreferredWidth(95);
        tblStudent.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblStudent.getColumnModel().getColumn(6).setPreferredWidth(70);
        tblStudent.getColumnModel().getColumn(7).setPreferredWidth(60);
        tblStudent.getColumnModel().getColumn(8).setPreferredWidth(90);
        tblStudent.getColumnModel().getColumn(9).setPreferredWidth(65);
    }

    void loadDataForComboboxBatch() {
        cboBatch.removeAllItems();
        ArrayList arrTemp = new ArrayList();
        for (String key : mapBatchCodeBatchName.keySet()) {
//    System.out.println("key: " + key + " value: " + mapBatchCodeBatchName.get(key));
            arrTemp.add(mapBatchCodeBatchName.get(key));
        }
        Collections.sort(arrTemp);
        for (Object object : arrTemp) {
            cboBatch.addItem(object.toString());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooserImageAvatar = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBatch = new javax.swing.JButton();
        btnStudent = new javax.swing.JButton();
        panelAction = new javax.swing.JPanel();
        panelBatch = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBatchCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBatchName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBatch = new javax.swing.JTable();
        btnAddNewBatch = new javax.swing.JButton();
        btnUpdateBatch = new javax.swing.JButton();
        panelStudent = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtStudentCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStudentName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        txtBirthday = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboBatch = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEnglishMark = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtMathMark = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtComputerMark = new javax.swing.JTextField();
        btnAddStudent = new javax.swing.JButton();
        btnEditStudent = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblAvatar = new javax.swing.JLabel();
        btnAddAvatar = new javax.swing.JButton();
        btnDeleteAvatar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStudent = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Managerment");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnBatch.setText("Batch");
        btnBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatchActionPerformed(evt);
            }
        });

        btnStudent.setText("Student");
        btnStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudent)
                .addContainerGap(378, Short.MAX_VALUE))
        );

        panelAction.setLayout(new java.awt.CardLayout());

        jLabel1.setText("Batch code");

        txtBatchCode.setEditable(false);

        jLabel2.setText("Batch name");

        tblBatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBatch.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBatch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBatchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBatch);

        btnAddNewBatch.setText("Add");
        btnAddNewBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewBatchActionPerformed(evt);
            }
        });

        btnUpdateBatch.setText("Edit");
        btnUpdateBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBatchLayout = new javax.swing.GroupLayout(panelBatch);
        panelBatch.setLayout(panelBatchLayout);
        panelBatchLayout.setHorizontalGroup(
            panelBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(panelBatchLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBatchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBatchName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddNewBatch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateBatch)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panelBatchLayout.setVerticalGroup(
            panelBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBatchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBatchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBatchCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtBatchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddNewBatch)
                    .addComponent(btnUpdateBatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelAction.add(panelBatch, "card2");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel3.setText("Student code");

        txtStudentCode.setEditable(false);

        jLabel4.setText("Student name");

        jLabel5.setText("Gender");

        buttonGroup1.add(radioMale);
        radioMale.setText("Male");

        buttonGroup1.add(radioFemale);
        radioFemale.setText("Female");

        jLabel6.setText("Birthday");

        jLabel7.setText("Batch");

        cboBatch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("English mark");

        jLabel9.setText("Math mark");

        jLabel10.setText("Computer mark");

        btnAddStudent.setText("Add");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        btnEditStudent.setText("Edit");
        btnEditStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditStudentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEnglishMark, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtMathMark, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(radioMale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioFemale))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtComputerMark, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStudentCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStudentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMale)
                    .addComponent(jLabel5)
                    .addComponent(radioFemale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboBatch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEnglishMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMathMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtComputerMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStudent)
                    .addComponent(btnEditStudent))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Avatar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblAvatar.setText("image avatar");

        btnAddAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/iconAddAvatar.png"))); // NOI18N
        btnAddAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvatarActionPerformed(evt);
            }
        });

        btnDeleteAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/iconDeleteAvatar.png"))); // NOI18N
        btnDeleteAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAvatarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnDeleteAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDeleteAvatar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAddAvatar, javax.swing.GroupLayout.Alignment.TRAILING)))
        );

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
        tblStudent.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStudent);

        javax.swing.GroupLayout panelStudentLayout = new javax.swing.GroupLayout(panelStudent);
        panelStudent.setLayout(panelStudentLayout);
        panelStudentLayout.setHorizontalGroup(
            panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentLayout.createSequentialGroup()
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStudentLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panelStudentLayout.setVerticalGroup(
            panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
        );

        panelAction.add(panelStudent, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAction, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBatchActionPerformed
        // TODO add your handling code here:
        if (txtBatchName.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input batch name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (oldBatchName.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please choose batch name you want to edit from table!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            if (controllerBatch.searchBatchByName(txtBatchName.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Batch name already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                controllerBatch.updateBatchName(oldBatchName, txtBatchName.getText().trim());
                updateDataForTableBatch_Edit();
                oldBatchName = "";
                JOptionPane.showMessageDialog(null, "Update success new batch name to database!", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateBatchActionPerformed

    private void btnAddNewBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewBatchActionPerformed
        // TODO add your handling code here:
        if (txtBatchName.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please input batch name!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String newBatchCode = controllerBatch.createNewBatchCode();
            modelBatch batch = new modelBatch(newBatchCode, txtBatchName.getText().trim());
            controllerBatch.insertNewBatch(batch);
            txtBatchCode.setText(newBatchCode);
            Vector vTemp = new Vector();
            vTemp.add(tblBatch.getRowCount() + 1);
            vTemp.add(newBatchCode);
            vTemp.add(txtBatchName.getText().trim());
            vTemp.add("Delete");
            tableBatchData.add(vTemp);
            showDataToTableBatch();
            JOptionPane.showMessageDialog(null, "Add success new student to database!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddNewBatchActionPerformed

    private void tblBatchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBatchMouseClicked
        // TODO add your handling code here:
        oldBatchName = tblBatch.getValueAt(tblBatch.getSelectedRow(), 2).toString();
        txtBatchCode.setText(tblBatch.getValueAt(tblBatch.getSelectedRow(), 1).toString());
        txtBatchName.setText(tblBatch.getValueAt(tblBatch.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tblBatchMouseClicked

    private void btnStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) panelAction.getLayout();
        cardLayout.show(panelAction, "panelStudent");
    }//GEN-LAST:event_btnStudentActionPerformed

    private void btnBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatchActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) panelAction.getLayout();
        cardLayout.show(panelAction, "panelBatch");
    }//GEN-LAST:event_btnBatchActionPerformed

    private void btnDeleteAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAvatarActionPerformed
        // TODO add your handling code here:
        lblAvatar.setIcon(null);
        lblAvatar.setText("image avatar");
        fileNameAvatar = null;
    }//GEN-LAST:event_btnDeleteAvatarActionPerformed

    private void btnAddAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvatarActionPerformed
        // TODO add your handling code here:
        fileChooserImageAvatar.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        fileChooserImageAvatar.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
//        fileChooserImageAvatar.addChoosableFileFilter(new FileNameExtensionFilter("MS Office Documents", "docx", "xlsx", "pptx"));
        fileChooserImageAvatar.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
        fileChooserImageAvatar.setAcceptAllFileFilterUsed(true);
        int result = fileChooserImageAvatar.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileNameAvatar = fileChooserImageAvatar.getSelectedFile();
            Image icon;
            try {
                icon = ImageIO.read(fileNameAvatar);
                icon = icon.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
                lblAvatar.setText("");
                lblAvatar.setIcon(new ImageIcon(icon));
            } catch (IOException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnAddAvatarActionPerformed

    private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentMouseClicked
        // TODO add your handling code here:
        txtStudentCode.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 1).toString());
        txtStudentName.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 2).toString());
        if (tblStudent.getValueAt(tblStudent.getSelectedRow(), 3).toString().equalsIgnoreCase("true")) {
            radioMale.setSelected(true);
            radioFemale.setSelected(false);
        } else {
            radioMale.setSelected(false);
            radioFemale.setSelected(true);
        }
        txtBirthday.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 4).toString());
        cboBatch.setSelectedItem(tblStudent.getValueAt(tblStudent.getSelectedRow(), 5).toString());
        txtEnglishMark.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 6).toString());
        txtMathMark.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 7).toString());
        txtComputerMark.setText(tblStudent.getValueAt(tblStudent.getSelectedRow(), 8).toString());
        String filename = "";
        for (int i = 0; i < arrayFileNameAvatar.size(); i++) {
            String studentCode = tblStudent.getValueAt(tblStudent.getSelectedRow(), 1).toString();
            filename = arrayFileNameAvatar.get(i);
            if (filename.substring(filename.lastIndexOf("/") + 1, filename.lastIndexOf("/") + studentCode.length() + 1).equals(studentCode)) {
                filename = filename.substring(filename.lastIndexOf("/") + 1);
                break;
            }
        }
        Image icon;
        try {
            File fileTemp = new File("");
            fileNameAvatar = new File(fileTemp.getAbsolutePath() + "/data/images/temp/" + filename);
//            fileNameAvatar = new File(frmMain.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/view/temp/" + filename);
            icon = ImageIO.read(fileNameAvatar);
            icon = icon.getScaledInstance(lblAvatar.getWidth(), lblAvatar.getHeight(), Image.SCALE_SMOOTH);
            lblAvatar.setText("");
            lblAvatar.setIcon(new ImageIcon(icon));
        } catch (IOException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStudentMouseClicked

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        // TODO add your handling code here:
        if (!myUtil.checkValidFrmMain()) {
            return;
        }
        FileInputStream in;
        try {
            in = new FileInputStream(fileNameAvatar);
            byte[] image = new byte[(int) fileNameAvatar.length()];
            in.read(image);
            String newStudentCode = controllerStudent.createNewStudentCode();
            if (radioMale.isSelected()) {
                student = new modelStudent(
                        newStudentCode,
                        txtStudentName.getText().trim(),
                        true,
                        myUtil.convertStringToJavaDate(txtBirthday.getText().trim()),
                        mapBatchNameBatchCode.get(cboBatch.getSelectedItem()),
                        Float.valueOf(txtEnglishMark.getText().trim()),
                        Float.valueOf(txtMathMark.getText().trim()),
                        Float.valueOf(txtComputerMark.getText().trim()),
                        newStudentCode + "_avatar.jpg",
                        image);
                controllerStudent.insertNewStudent(student);
            } else {
                student = new modelStudent(
                        newStudentCode,
                        txtStudentName.getText().trim(),
                        false,
                        myUtil.convertStringToJavaDate(txtBirthday.getText().trim()),
                        mapBatchNameBatchCode.get(cboBatch.getSelectedItem()),
                        Float.valueOf(txtEnglishMark.getText().trim()),
                        Float.valueOf(txtMathMark.getText().trim()),
                        Float.valueOf(txtComputerMark.getText().trim()),
                        newStudentCode + "_avatar.jpg",
                        image);
                controllerStudent.insertNewStudent(student);
            }
            txtStudentCode.setText(newStudentCode);
            myUtil.updateAllInformationAfterInsertNewStudent();
            JOptionPane.showMessageDialog(null, "Add success new student to database!", "Message", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | SQLException | InterruptedException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

//        for (int i = 0; i < arrayListAllStudent.size(); i++) {
//            File file = new File("");
//            Path pathObj = Paths.get(file.getAbsoluteFile() + "/data/images/temp/" + arrayListAllStudent.get(i).getStudentCode() + "_avatar.jpg");
//            try {
//                Files.delete(pathObj);
//            } catch (IOException ex) {
//                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        File file = new File("");
        file = new File(file.getAbsoluteFile() + "/data/images/temp/");
        File[] listFiles = file.listFiles();
        for (File listFile : listFiles) {
            Path path = Paths.get(listFile.toString());
            try {
                Files.delete(path);
            } catch (IOException ex) {
                Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnEditStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditStudentActionPerformed
        // TODO add your handling code here:
        if (txtStudentCode.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please choose student you want to edit from table!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!myUtil.checkValidFrmMain()) {
            return;
        }
        FileInputStream in;
        try {
            in = new FileInputStream(fileNameAvatar);
            byte[] image = new byte[(int) fileNameAvatar.length()];
            in.read(image);
            if (radioMale.isSelected()) {
                student = new modelStudent(
                        txtStudentCode.getText(),
                        txtStudentName.getText().trim(),
                        true,
                        myUtil.convertStringToJavaDate(txtBirthday.getText().trim()),
                        mapBatchNameBatchCode.get(cboBatch.getSelectedItem()),
                        Float.valueOf(txtEnglishMark.getText().trim()),
                        Float.valueOf(txtMathMark.getText().trim()),
                        Float.valueOf(txtComputerMark.getText().trim()),
                        txtStudentCode.getText() + "_avatar.jpg",
                        image);
                controllerStudent.updateStudent(student);
            } else {
                student = new modelStudent(
                        txtStudentCode.getText(),
                        txtStudentName.getText().trim(),
                        false,
                        myUtil.convertStringToJavaDate(txtBirthday.getText().trim()),
                        mapBatchNameBatchCode.get(cboBatch.getSelectedItem()),
                        Float.valueOf(txtEnglishMark.getText().trim()),
                        Float.valueOf(txtMathMark.getText().trim()),
                        Float.valueOf(txtComputerMark.getText().trim()),
                        txtStudentCode.getText() + "_avatar.jpg",
                        image);
                controllerStudent.updateStudent(student);
            }
            myUtil.updateAllInformationAfterUpdateNewStudent(student);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException | SQLException | InterruptedException ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditStudentActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmMain().setVisible(true);
                } catch (ClassNotFoundException | SQLException | IOException | InterruptedException | ParseException ex) {
                    Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAvatar;
    private javax.swing.JButton btnAddNewBatch;
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnBatch;
    private javax.swing.JButton btnDeleteAvatar;
    private javax.swing.JButton btnEditStudent;
    private javax.swing.JButton btnStudent;
    private javax.swing.JButton btnUpdateBatch;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox<String> cboBatch;
    private javax.swing.JFileChooser fileChooserImageAvatar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JPanel panelAction;
    private javax.swing.JPanel panelBatch;
    private javax.swing.JPanel panelStudent;
    public static javax.swing.JRadioButton radioFemale;
    public static javax.swing.JRadioButton radioMale;
    public static javax.swing.JTable tblBatch;
    public static javax.swing.JTable tblStudent;
    public static javax.swing.JTextField txtBatchCode;
    private static javax.swing.JTextField txtBatchName;
    public static javax.swing.JTextField txtBirthday;
    public static javax.swing.JTextField txtComputerMark;
    public static javax.swing.JTextField txtEnglishMark;
    public static javax.swing.JTextField txtMathMark;
    public static javax.swing.JTextField txtStudentCode;
    public static javax.swing.JTextField txtStudentName;
    // End of variables declaration//GEN-END:variables
}
