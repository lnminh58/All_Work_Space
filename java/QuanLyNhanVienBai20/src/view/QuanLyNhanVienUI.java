/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.FileFactory;
import static controler.FileFactory.luuFile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import model.NhanVien;
import model.PhongBan;

/**
 *
 * @author lnmin
 */
public class QuanLyNhanVienUI extends JFrame {

    JComboBox<PhongBan> cboPhongBan;
    JList<NhanVien> listNhanVien;
    JTextField txtMaNV, txtTenNV, txtNgayVaoLam, txtNamSinh;
    JButton btnthem, btnLuu, btnXoa, btnThoat;

    private static Vector<PhongBan> listPhongBan;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private NhanVien nvSeleted;
    private PhongBan pbSeleted;

    public QuanLyNhanVienUI(String tieude) {
        super(tieude);
        addControls();
        addEvents();
        loadData();
    }

    public void addControls() {
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        JPanel pnPhongBan = new JPanel();
        pnPhongBan.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnMain.add(pnPhongBan);
        JLabel lblPhongBan = new JLabel("Chọn Phòng Ban:");
        cboPhongBan = new JComboBox<>();
        cboPhongBan.setPreferredSize(new Dimension(200, 30));
        pnPhongBan.add(lblPhongBan);
        pnPhongBan.add(cboPhongBan);

        con.add(pnMain);
        JPanel pnDSCT = new JPanel();
        pnDSCT.setLayout(new GridLayout(1, 2));
        pnMain.add(pnDSCT);
        JPanel pnDanhSach = new JPanel();
        pnDanhSach.setLayout(new BorderLayout());
        Border borderDanhSach = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titleBorDerDanhSach = new TitledBorder(borderDanhSach, "Danh sách");
        titleBorDerDanhSach.setTitleJustification(TitledBorder.CENTER);
        titleBorDerDanhSach.setTitleColor(Color.RED);
        pnDanhSach.setBorder(titleBorDerDanhSach);

        listNhanVien = new JList<>();
        JScrollPane scDanhSach = new JScrollPane(listNhanVien,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnDanhSach.add(scDanhSach, BorderLayout.CENTER);
        pnDSCT.add(pnDanhSach);

        JPanel pnChiTiet = new JPanel();
        pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
        Border borderChiTiet = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder titleBorDerChiTiet = new TitledBorder(borderChiTiet, "Thông tin chi tiết");
        titleBorDerChiTiet.setTitleJustification(TitledBorder.CENTER);
        titleBorDerChiTiet.setTitleColor(Color.RED);
        pnChiTiet.setBorder(titleBorDerChiTiet);

        pnDSCT.add(pnChiTiet);

        JPanel pnMa = new JPanel();
        pnMa.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblMa = new JLabel("Mã: ");
        txtMaNV = new JTextField(15);
        pnMa.add(lblMa);
        pnMa.add(txtMaNV);
        pnChiTiet.add(pnMa);

        JPanel pnTen = new JPanel();
        pnTen.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblTen = new JLabel("Tên: ");
        txtTenNV = new JTextField(15);
        pnTen.add(lblTen);
        pnTen.add(txtTenNV);
        pnChiTiet.add(pnTen);

        JPanel pnNgayVaoLam = new JPanel();
        pnNgayVaoLam.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblNgayVaoLam = new JLabel("Ngày vào làm: ");
        txtNgayVaoLam = new JTextField(15);
        pnNgayVaoLam.add(lblNgayVaoLam);
        pnNgayVaoLam.add(txtNgayVaoLam);
        pnChiTiet.add(pnNgayVaoLam);

        JPanel pnNamSinh = new JPanel();
        pnNamSinh.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblNamSinh = new JLabel("Năm sinh: ");
        txtNamSinh = new JTextField(15);
        pnNamSinh.add(lblNamSinh);
        pnNamSinh.add(txtNamSinh);
        pnChiTiet.add(pnNamSinh);

        JPanel pnButton = new JPanel();
        pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnthem = new JButton("Thêm");
        btnXoa = new JButton("Xóa");
        btnLuu = new JButton("Lưu");
        btnThoat = new JButton("Thoát");
        pnButton.add(btnthem);
        pnButton.add(btnXoa);
        pnButton.add(btnLuu);
        pnButton.add(btnThoat);
        pnMain.add(pnButton);

        lblMa.setPreferredSize(lblNgayVaoLam.getPreferredSize());
        lblTen.setPreferredSize(lblNgayVaoLam.getPreferredSize());
        lblNamSinh.setPreferredSize(lblNgayVaoLam.getPreferredSize());

    }

    public void addEvents() {
        cboPhongBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showListNhanVien();
            }
        });

        listNhanVien.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (listNhanVien.getSelectedIndex() == -1) {
                    return;
                }
                nvSeleted = listNhanVien.getSelectedValue();
                txtMaNV.setText(nvSeleted.getMaNhanVien());
                txtTenNV.setText(nvSeleted.getTenNhanVien());
                txtNgayVaoLam.setText(sdf.format(nvSeleted.getNgayVaoLamVien()));
                txtNamSinh.setText(sdf.format(nvSeleted.getNamSinh()));
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
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                taoFile();
                saveData();
            }
        });
        btnthem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addNhanVien();
                showListNhanVien();
            }
        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pbSeleted.getListNhanVien().remove(nvSeleted);
                nvSeleted = null;
                showListNhanVien();
            }
        });
        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    public void showListNhanVien() {
        if (cboPhongBan.getSelectedIndex() == -1) {
            return;
        }
        pbSeleted = (PhongBan) cboPhongBan.getSelectedItem();
        listNhanVien.setListData(pbSeleted.getListNhanVien());
    }

    public void addNhanVien() {
        if (txtMaNV.getText().trim().equalsIgnoreCase("")
                || txtTenNV.getText().trim().equalsIgnoreCase("")
                || txtNgayVaoLam.getText().trim().equalsIgnoreCase("")
                || txtTenNV.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null,"Xin điền vào trước khi nhấn thêm!!!");
        } else if(checkExits()){
            JOptionPane.showMessageDialog(null,"Mã nhân viên bị trùng!!!");
            
        }else {

            try {
                NhanVien nv = new NhanVien(
                        txtMaNV.getText(),
                        txtTenNV.getText(),
                        sdf.parse(txtNgayVaoLam.getText()),
                        sdf.parse(txtNamSinh.getText()));
                if (pbSeleted != null) {
                    pbSeleted.themNhanVien(nv);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    private boolean checkExits(){
        for (PhongBan phongBan : listPhongBan) {
            for (NhanVien nhanVien : phongBan.getListNhanVien()) {
                if(txtMaNV.getText().trim().equalsIgnoreCase(nhanVien.getMaNhanVien())){
                    return true;
                }
            }
        }
        return false;
    }
    public void loadData() {
        QuanLyNhanVienUI.listPhongBan = FileFactory.loadFile();
        for (PhongBan phongBan : listPhongBan) {
            cboPhongBan.addItem(phongBan);
        }

    }

    public void saveData() {
        String luuFile = FileFactory.luuFile(QuanLyNhanVienUI.listPhongBan);
        JOptionPane.showMessageDialog(null, luuFile);
    }
//    public void taoFile(){
//        listPhongBan = new Vector<>();
//        listPhongBan.add(new PhongBan("P01", "Phòng nhân sự", new Vector<>()));
//        listPhongBan.add(new PhongBan("P02", "Phòng kế toán", new Vector<>()));
//        listPhongBan.add(new PhongBan("P03", "Phòng kinh doanh", new Vector<>()));
//        listPhongBan.add(new PhongBan("P04", "Phòng kỹ thuật", new Vector<>()));
//        String luuFile = FileFactory.luuFile(listPhongBan);
//        JOptionPane.showMessageDialog(null, luuFile);
//    }

    public void showWindow() {
        this.setSize(630, 320);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        QuanLyNhanVienUI qlnv = new QuanLyNhanVienUI("Quản Lý Nhân Viên");
        qlnv.showWindow();
    }
}
