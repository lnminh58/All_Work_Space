/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai18;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lnmin
 */
public class BorderTextAreaCheckBoxRadioUI extends JFrame {

    JTextField txtName;
    JTextArea txtAddress;
    JButton btnOK;
    JCheckBox chkSwimming, chkCinema;
    JRadioButton radMale, radFemale;
    ButtonGroup groupSex;

    public BorderTextAreaCheckBoxRadioUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    public void addControls() {
        Container container = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

        container.add(pnMain);

        JPanel pnInfo = new JPanel();
        pnInfo.setLayout(new BoxLayout(pnInfo, BoxLayout.Y_AXIS));
        JPanel pnName = new JPanel();
        pnName.setLayout(new FlowLayout());
        JLabel lblName = new JLabel("Nhập tên: ");
        txtName = new JTextField(20);
        pnName.add(lblName);
        pnName.add(txtName);
        pnInfo.add(pnName);
        pnMain.add(pnInfo);

        JPanel pnAddress = new JPanel();
        pnAddress.setLayout(new FlowLayout());
        JLabel lblAddress = new JLabel("Địa Chỉ:  ");
        txtAddress = new JTextArea(10, 20);
        txtAddress.setWrapStyleWord(true);
        txtAddress.setLineWrap(true);

        JScrollPane scAddress = new JScrollPane(txtAddress,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pnAddress.add(lblAddress);
        pnAddress.add(scAddress);
        pnInfo.add(pnAddress);

        Border borderInfo = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder tbInfo = new TitledBorder(borderInfo, "Thông tin: ");
        tbInfo.setTitleColor(Color.RED);
        tbInfo.setTitleJustification(TitledBorder.CENTER);
        pnInfo.setBorder(tbInfo);

        JPanel pnHobbyAndSex = new JPanel();
//         pnHobbyAndSex.setLayout(new BoxLayout(pnHobbyAndSex,BoxLayout.X_AXIS));
        pnHobbyAndSex.setLayout(new GridLayout(1, 2));
        JPanel pnHobby = new JPanel();
        pnHobby.setLayout(new BoxLayout(pnHobby, BoxLayout.Y_AXIS));
        chkSwimming = new JCheckBox("Đi bơi");
        chkCinema = new JCheckBox("Đi xem phim ");
        pnHobby.add(chkSwimming);
        pnHobby.add(chkCinema);
        pnHobbyAndSex.add(pnHobby);

        Border borderHobby = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder tbHobby = new TitledBorder(borderHobby, "Sở thích: ");
        tbHobby.setTitleColor(Color.RED);
        tbHobby.setTitleJustification(TitledBorder.CENTER);
        pnHobby.setBorder(tbHobby);

        JPanel pnSex = new JPanel();
        pnSex.setLayout(new BoxLayout(pnSex, BoxLayout.Y_AXIS));
        radMale = new JRadioButton("Nam");
        radFemale = new JRadioButton("Nữ");
        groupSex = new ButtonGroup();
        groupSex.add(radMale);
        groupSex.add(radFemale);
        pnSex.add(radMale);
        pnSex.add(radFemale);

        Border borderSex = BorderFactory.createLineBorder(Color.BLACK);
        TitledBorder tbSex = new TitledBorder(borderSex, "Giới tính: ");
        tbSex.setTitleColor(Color.RED);
        tbSex.setTitleJustification(TitledBorder.CENTER);
        pnSex.setBorder(tbSex);

        pnHobbyAndSex.add(pnSex);
        pnMain.add(pnHobbyAndSex);

        JPanel pnOK = new JPanel();
        pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
        btnOK = new JButton("OK");
        pnOK.add(btnOK);
        pnMain.add(pnOK);

        lblAddress.setPreferredSize(lblName.getPreferredSize());

    }

    public void addEvents() {
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                xuLyLayThongTin();
            }

        });
    }

    private void xuLyLayThongTin() {
        String message = txtName.getText()+"\n" + txtAddress.getText();
        String hobby ="";
        if(chkSwimming.isSelected()){
            hobby+=chkSwimming.getText();
        }
        if(chkCinema.isSelected()){
            hobby+="\n"+ chkCinema.getText();
        }
        String sex= "";
        if(radMale.isSelected()){
            sex="Nam";
        }else if(radFemale.isSelected()){
            sex="Nữ";
        }
        message +="\n"+ sex + "\n"+ hobby;
        JOptionPane.showMessageDialog(null, message);
    }

    public void showWindow() {
        this.setSize(350, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
