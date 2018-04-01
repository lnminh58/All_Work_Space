/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author nguyenducthao
 */
public class giaiptbac2 extends JFrame {

    private JPanel myJPanel;
    private JTextArea TextArea_KetQua;

    public void create_JFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(350, 330);
        setResizable(false);
    }

    public void display_JFrame() {
//        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void create_JPanel() {
        myJPanel = new JPanel();
        myJPanel.setLayout(null);
    }

    public void add_JPanel_to_JFrame() {
        add(myJPanel);
    }

    public void create_content_JPanel() {
        JLabel label1 = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
        label1.setFont(new Font("times new roman", Font.BOLD, 18));
        label1.setSize(246, 20);
        label1.setLocation(50, 20);
        myJPanel.add((label1));
        JLabel label2 = new JLabel("a=");
        label2.setFont(new Font("times new roman", Font.PLAIN, 14));
        label2.setSize(20, 20);
        label2.setLocation(50, 50);
        myJPanel.add((label2));
        JTextField textField_a = new JTextField();
        textField_a.setSize(246, 20);
        textField_a.setLocation(70, 50);
        myJPanel.add((textField_a));
        JLabel label3 = new JLabel("b=");
        label3.setFont(new Font("times new roman", Font.PLAIN, 14));
        label3.setSize(20, 20);
        label3.setLocation(50, 80);
        myJPanel.add((label3));
        JTextField textField_b = new JTextField();
        textField_b.setSize(246, 20);
        textField_b.setLocation(70, 80);
        myJPanel.add((textField_b));
        JLabel label4 = new JLabel("c=");
        label4.setFont(new Font("times new roman", Font.PLAIN, 14));
        label4.setSize(20, 20);
        label4.setLocation(50, 110);
        myJPanel.add((label4));
        JTextField textField_c = new JTextField();
        textField_c.setSize(246, 20);
        textField_c.setLocation(70, 110);
        myJPanel.add((textField_c));
        JLabel label5 = new JLabel("Kết quả=");
        label5.setFont(new Font("times new roman", Font.PLAIN, 14));
        label5.setSize(55, 20);
        label5.setLocation(10, 140);
        myJPanel.add((label5));
        TextArea_KetQua = new JTextArea(3, 20);
        TextArea_KetQua.setSize(246, 100);
        TextArea_KetQua.setLocation(70, 140);
        TextArea_KetQua.setEditable(false);
        myJPanel.add((TextArea_KetQua));
        JButton buttonGiai = new JButton("Giải");
        buttonGiai.setSize(70, 30);
        buttonGiai.setLocation(70, 250);
        myJPanel.add((buttonGiai));
        JButton buttonNhapLai = new JButton("Nhập lại");
        buttonNhapLai.setSize(80, 30);
        buttonNhapLai.setLocation(147, 250);
        myJPanel.add((buttonNhapLai));
        JButton buttonThoat = new JButton("Thoát");
        buttonThoat.setSize(80, 30);
        buttonThoat.setLocation(235, 250);
        myJPanel.add((buttonThoat));
//        myJPanel.validate();
//        myJPanel.repaint();
        buttonGiai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (textField_a.getText().length() == 0) {
                    showDialog myDialog = new showDialog("Chưa nhập giá trị cho a!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_a.requestFocus();
                    return;
                }
                if (textField_b.getText().length() == 0) {
                    showDialog myDialog = new showDialog("Chưa nhập giá trị cho b!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_b.requestFocus();
                    return;
                }
                if (textField_c.getText().length() == 0) {
                    showDialog myDialog = new showDialog("Chưa nhập giá trị cho c!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_c.requestFocus();
                    return;
                }
                if (!(textField_a.getText().matches("\\d+"))) {
                    showDialog myDialog = new showDialog("Chỉ được nhập số cho giá trị a!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_a.requestFocus();
                    textField_a.selectAll();
                    return;
                }
                if (!(textField_b.getText().matches("\\d+"))) {
                    showDialog myDialog = new showDialog("Chỉ được nhập số cho giá trị b!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_b.requestFocus();
                    textField_b.selectAll();
                    return;
                }
                if (!(textField_c.getText().matches("\\d+"))) {
                    showDialog myDialog = new showDialog("Chỉ được nhập số cho giá trị c!");
                    myDialog.setModal(true);
                    myDialog.setVisible(true);
                    textField_c.requestFocus();
                    textField_c.selectAll();
                    return;
                }
                giaiPhuongTrinhBac2(Integer.parseInt(textField_a.getText()), Integer.parseInt(textField_b.getText()), Integer.parseInt(textField_c.getText()));
            }
        });
        buttonNhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textField_a.setText("");
                textField_b.setText("");
                textField_c.setText("");
                TextArea_KetQua.setText("");
            }
        });
        buttonThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }

    public void giaiPhuongTrinhBac2(int a, int b, int c) {
        double x1, x2;
        double delta;
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    TextArea_KetQua.setText("Phương trình vô số nghiệm");
                } else {
                    TextArea_KetQua.setText("Phương trình vô nghiệm");
                }
            } else {
                x1 = (-c) / b;
                TextArea_KetQua.setText("Phương trình có nghiệm duy nhất: " + x1);
            }
        } else {
            delta = (b * b) - (4 * a * c);
            if (delta < 0) {
                TextArea_KetQua.setText("Phương trình vô nghiệm");
            }
            if (delta == 0) {
                x1 = -b / (2 * a);
                TextArea_KetQua.setText("Phương trình có nghiệm duy nhất:" + x1);
            }
            if (delta > 0) {
                x1 = (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (-b - Math.sqrt(delta)) / (2 * a);
                TextArea_KetQua.setText("Phương trình có hai nghiệm: x1=" + x1 + ", x2=" + x2);
                TextArea_KetQua.setText("Phương trình có hai nghiệm:\n");
                DecimalFormat df = new DecimalFormat("0.000");

                TextArea_KetQua.append("x1= " + df.format(x1) + "\n");
                TextArea_KetQua.append("x2= " + df.format(x2) + "\n");
            }
        }
    }

    public static void main(String[] args) {
        giaiptbac2 giaiptb2 = new giaiptbac2();
        giaiptb2.create_JFrame("Giải phương trình bậc 2");
        giaiptb2.create_JPanel();
        giaiptb2.create_content_JPanel();

        giaiptb2.add_JPanel_to_JFrame();
        giaiptb2.display_JFrame();
    }
}
