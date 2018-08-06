/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai18;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author lnmin
 */
public class BorderTextAreaUI extends JFrame {
    JTextField txtName;
    JTextArea txtAddress;
    JButton btnOK;
    public BorderTextAreaUI(String title) {
        super(title);
        addControls();
        addEvents();
    }
  
    
    public void addControls(){
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
         JLabel lblAddress = new  JLabel("Địa Chỉ:  ");
         txtAddress = new JTextArea(10,20);
         txtAddress.setWrapStyleWord(true);
         txtAddress.setLineWrap(true);
         
         JScrollPane scAddress = new JScrollPane(txtAddress,
                                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                          JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         pnAddress.add(lblAddress);
         pnAddress.add(scAddress);
         pnInfo.add(pnAddress);
         
         Border borderInfo = BorderFactory.createLineBorder(Color.BLACK);
         TitledBorder tbInfo = new TitledBorder(borderInfo, "Thông tin: ");
         tbInfo.setTitleColor(Color.RED);
         tbInfo.setTitleJustification(TitledBorder.CENTER);
         pnInfo.setBorder(tbInfo);
                 
         JPanel pnOK = new JPanel();
         pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
         btnOK = new JButton("OK");
         pnOK.add(btnOK);
         pnMain.add(pnOK);
         
         lblAddress.setPreferredSize(lblName.getPreferredSize());
         
     }
    public void addEvents(){
        
    }
    public void showWindow() {
        this.setSize(350, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
