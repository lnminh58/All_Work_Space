/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FileFactory;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.KhachHang;
import model.NhomKhachHang;

/**
 *
 * @author lnmin
 */
public class KhachHangUI extends JFrame {

    JMenuBar mnuBar;
    JMenu mnuFile;
    JMenuItem mnuFileOpen, mnuFileSave, mnuFileExit;
    JFileChooser chooser;
    
    DefaultMutableTreeNode root = null;
    JTree treeNhom;
    DefaultTableModel dtm;
    JTable tblKhachHang;
    JTextField txtMa, txtTen, txtSDT, txtEmail;
    JButton btnClear, btnThem,btnXoa;
    Vector<NhomKhachHang> dsNhomKhachHang = new Vector<>();
    Vector<KhachHang> dsKhachHang;
    DefaultMutableTreeNode nodeSelected;
    NhomKhachHang nhomSelected = null;

    public KhachHangUI(String title) {
        super(title);
        addControls();
        addEvents();
        fakeData();
        showData();
    }

    private void addEvents() {
        mnuFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                exitSystem();
            }
        });
        mnuFileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saveFile();
            }
        });
        mnuFileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                loadFile();
            }
        });
        treeNhom.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showOnTable();
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
        tblKhachHang.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                showOnInfoFrame();
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
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addKhachHang();
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearInfoOnTextField();

            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteKhachHang();
            }
        });
      
    }

    private void saveFile() {
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            String luuFile = FileFactory.luuFile(dsNhomKhachHang, selectedFile.getAbsolutePath());
            JOptionPane.showMessageDialog(null, luuFile);
        }
    }

    private void loadFile() {
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = chooser.getSelectedFile();
                dsNhomKhachHang = FileFactory.loadFile(selectedFile.getAbsolutePath());
                showData();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Đọc thất bại");
            }

        }
    }

    private void showData() {
        
        root.removeAllChildren();
        
        for (NhomKhachHang nhomKhachHang : dsNhomKhachHang) {
            DefaultMutableTreeNode nhom = new DefaultMutableTreeNode(nhomKhachHang);
            root.add(nhom);
        }
        DefaultTreeModel treeModel= (DefaultTreeModel) treeNhom.getModel();
        treeModel.reload(root);
        treeNhom.validate();
        treeNhom.repaint();
        treeNhom.expandRow(0);
    }

    private void exitSystem() {
        int showConfirmDialog = JOptionPane.showConfirmDialog(
                null,
                "Chắc Chắn muốn thoát phần mềm không?",
                "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void deleteKhachHang() {
        if (nhomSelected != null && tblKhachHang.getSelectedRow() != -1) {
            nhomSelected.getDsKhachHang().remove(tblKhachHang.getSelectedRow());
            showOnTable();

        }
    }

    private void clearInfoOnTextField() {
        txtMa.setText(null);
        txtTen.setText(null);
        txtSDT.setText(null);
        txtEmail.setText(null);
    }

    private void showOnInfoFrame() {
        int rowSelected = tblKhachHang.getSelectedRow();
        if (rowSelected == -1) {
            return;
        }
        txtMa.setText((String) tblKhachHang.getValueAt(rowSelected, 0));
        txtTen.setText((String) tblKhachHang.getValueAt(rowSelected, 1));
        txtSDT.setText((String) tblKhachHang.getValueAt(rowSelected, 2));
        txtEmail.setText((String) tblKhachHang.getValueAt(rowSelected, 3));
    }

    private void addKhachHang() {
        KhachHang kh = new KhachHang(
                txtMa.getText(),
                txtTen.getText(),
                txtSDT.getText(),
                txtEmail.getText());
        nhomSelected.themKhachHang(kh);
        showOnTable();
    }

    private void showOnTable() {
        nodeSelected = (DefaultMutableTreeNode) treeNhom.getLastSelectedPathComponent();
        if (nodeSelected != null && nodeSelected.getLevel() == 1) {
            nhomSelected = (NhomKhachHang) nodeSelected.getUserObject();
            dtm.setRowCount(0);
            for (KhachHang kh : nhomSelected.getDsKhachHang()) {
                Vector<String> vtkh = new Vector<>();
                vtkh.add(kh.getMa());
                vtkh.add(kh.getTen());
                vtkh.add(kh.getSoDienThoai());
                vtkh.add(kh.getEmail());
                dtm.addRow(vtkh);
            }
        }

    }

    private void addControls() {
        setupMenubar();
        chooser = new JFileChooser();
        Container con = getContentPane();
        JPanel pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(300, 0));
        JPanel pnRight = new JPanel();
        JSplitPane spHori = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        spHori.setOneTouchExpandable(true);
        spHori.add(pnLeft);
        spHori.add(pnRight);
        con.setLayout(new BorderLayout());
        con.add(spHori, BorderLayout.CENTER);

        pnRight.setLayout(new BorderLayout());
        JPanel pnTop = new JPanel();
        pnTop.setPreferredSize(new Dimension(0, 300));
        JPanel pnBottom = new JPanel();
        JSplitPane spVerti = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        spVerti.setOneTouchExpandable(true);
        spVerti.add(pnTop);
        spVerti.add(pnBottom);
        pnRight.add(spVerti);

        pnLeft.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("Công Ty Đa Cấp");
        treeNhom = new JTree(root);
        JScrollPane scTree = new JScrollPane(treeNhom,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnLeft.add(scTree, BorderLayout.CENTER);

        pnTop.setLayout(new BorderLayout());
        dtm = new DefaultTableModel();
        dtm.addColumn("Mã khách hàng");
        dtm.addColumn("Tên khách hàng");
        dtm.addColumn("SĐT khách hàng");
        dtm.addColumn("Email khách hàng");
        tblKhachHang = new JTable(dtm);
        JScrollPane scTable = new JScrollPane(tblKhachHang, 22, 32);
        pnTop.add(scTable);

        pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.Y_AXIS));
        JPanel pnMa = new JPanel();
        pnMa.setLayout(new FlowLayout());
        JLabel lblMa = new JLabel("Mã khách hàng: ");
        txtMa = new JTextField(20);
        pnMa.add(lblMa);
        pnMa.add(txtMa);
        pnBottom.add(pnMa);

        JPanel pnTen = new JPanel();
        pnTen.setLayout(new FlowLayout());
        JLabel lblTen = new JLabel("Tên khách hàng: ");
        txtTen = new JTextField(20);
        pnTen.add(lblTen);
        pnTen.add(txtTen);
        pnBottom.add(pnTen);

        JPanel pnSDT = new JPanel();
        pnSDT.setLayout(new FlowLayout());
        JLabel lblSDT = new JLabel("SĐT khách hàng: ");
        txtSDT = new JTextField(20);
        pnSDT.add(lblSDT);
        pnSDT.add(txtSDT);
        pnBottom.add(pnSDT);

        JPanel pnEmail = new JPanel();
        pnEmail.setLayout(new FlowLayout());
        JLabel lblEmail = new JLabel("Email khách hàng: ");
        txtEmail = new JTextField(20);
        pnEmail.add(lblEmail);
        pnEmail.add(txtEmail);
        pnBottom.add(pnEmail);

        JPanel pnClear = new JPanel();
        pnClear.setLayout(new FlowLayout());
        btnClear = new JButton("Làm sạch");
        pnClear.add(btnClear);
        pnBottom.add(pnClear);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnThem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");

        pnButton.add(btnThem);
        pnButton.add(btnXoa);
        pnBottom.add(pnButton);
        lblMa.setPreferredSize(lblEmail.getPreferredSize());
        lblTen.setPreferredSize(lblEmail.getPreferredSize());
        lblSDT.setPreferredSize(lblEmail.getPreferredSize());

    }

    private void setupMenubar() {
        mnuBar = new JMenuBar();
        setJMenuBar(mnuBar);
        mnuFile = new JMenu("Hệ Thống");
        mnuBar.add(mnuFile);
        mnuFileSave = new JMenuItem("Lưu tập tin");
        mnuFileOpen = new JMenuItem("Mở tập tin");
        mnuFileExit = new JMenuItem("Thoát phần mềm");
        mnuFile.add(mnuFileOpen);
        mnuFile.add(mnuFileSave);
        mnuFile.addSeparator();
        mnuFile.add(mnuFileExit);

    }

    public void fakeData() {
        dsNhomKhachHang.add(new NhomKhachHang("N01", "Khách Hàng Thân Thiết"));
        dsNhomKhachHang.add(new NhomKhachHang("N02", "Khách Hàng Tiềm Năng"));
        dsNhomKhachHang.add(new NhomKhachHang("N03", "Black list khách hàng"));
        for (NhomKhachHang nhomKhachHang : dsNhomKhachHang) {
            DefaultMutableTreeNode nhom = new DefaultMutableTreeNode(nhomKhachHang);
            root.add(nhom);
        }
        treeNhom.expandRow(0);
        dsNhomKhachHang.get(0).getDsKhachHang().add(
                new KhachHang("KH01", "Lê Ngọc Minh", "0935889315", "lnminh58@gmail.com"));
        dsNhomKhachHang.get(0).getDsKhachHang().add(
                new KhachHang("KH02", "Trần Bình Trọng", "0943889111", "tbTrong@gmail.com"));
        dsNhomKhachHang.get(0).getDsKhachHang().add(
                new KhachHang("KH03", "Nguyễn Văn Lũy", "0943123987", "vnLuy1986@gmail.com"));

        dsNhomKhachHang.get(1).getDsKhachHang().add(
                new KhachHang("KH01", "Jonh", "0893113114", "jonh_alentica58@gmail.com"));
        dsNhomKhachHang.get(1).getDsKhachHang().add(
                new KhachHang("KH02", "Alena", "0486111222", "alena_pornstar@gmail.com"));
        dsNhomKhachHang.get(1).getDsKhachHang().add(
                new KhachHang("KH03", "MariaOlala", "0934813702", "maria_danat@gmail.com"));

        dsNhomKhachHang.get(2).getDsKhachHang().add(
                new KhachHang("KH01", "Thích Quịt Nợ", "0933456789", "thanhquit@gmail.com"));
    }

    public void showWidow() {
        this.setSize(new Dimension(1000, 600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        KhachHangUI ui = new KhachHangUI("Quản Lý Khách Hàng");
        ui.showWidow();
    }
}
