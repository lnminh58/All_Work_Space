/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai21;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.awt.SunHints;

/**
 *
 * @author lnmin
 */
public class TableUI extends JFrame {

    DefaultTableModel dtm;
    JTable tblSinhVien;
    JButton btnThemMoi, btnXoa;

    public TableUI(String title) {

        super(title);
        addControls();
        addEvents();
        fakeData();
    }

    private void addControls() {
        Container con = getContentPane();
        JPanel pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(300, 0));
        JPanel pnRight = new JPanel();
        JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
        con.add(spMain);

        dtm = new DefaultTableModel();
        tblSinhVien = new JTable(dtm);
        JScrollPane scTable = new JScrollPane(tblSinhVien,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnLeft.setLayout(new BorderLayout());
        pnLeft.add(scTable, BorderLayout.CENTER);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnThemMoi = new JButton("Thêm Mới");
        btnXoa = new JButton("Xóa");
        pnButton.add(btnThemMoi);
        pnButton.add(btnXoa);
        pnLeft.add(pnButton, BorderLayout.SOUTH);
    }

    public void addEvents() {
        btnThemMoi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector<String> vec = new Vector<>();
                vec.add("Mã xyz");
                vec.add("Tên abc");
                vec.add("Địa chỉ def");
                dtm.addRow(vec);
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int rowPosition = tblSinhVien.getSelectedRow();
                if (rowPosition == -1) {
                    return;
                }
                dtm.removeRow(rowPosition);
            }
        });
        tblSinhVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showRowInfo();
            }

            @Override
            public void mousePressed(MouseEvent me) {
              
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });

        tblSinhVien.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == 10) {
                    showRowInfo();
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
               
            }
        });
    }

    private void showRowInfo() {
        int rowPosition = tblSinhVien.getSelectedRow();
        if (rowPosition == -1) {
            return;
        }
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < tblSinhVien.getColumnCount(); i++) {
            message.append(tblSinhVien.getValueAt(rowPosition, i));
            message.append("   ");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private void fakeData() {
        dtm.addColumn("Mã");

        dtm.addColumn("Tên");
        dtm.addColumn("Địa Chỉ");
        String[] row1 = {"SV01", "Lê Ngọc Minh", "Đà Nẵng"};
        String[] row2 = {"SV02", "Trần Văn Tèo", "Huế"};
        String[] row3 = {"SV03", "Đinh Văn Liệt", "Quảng Nam"};
        dtm.addRow(row1);
        dtm.addRow(row2);
        dtm.addRow(row3);

    }

    public void showWindows() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        TableUI ui = new TableUI("Table");
        ui.showWindows();
    }

}
