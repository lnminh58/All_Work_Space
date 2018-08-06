/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai19;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author lnmin
 */
public class ComboboxListUI extends JFrame{
    JComboBox<Integer> cboSo; 
    JList<Integer> listSo;
    JButton btnOK;
    public ComboboxListUI(String title) {
        super(title);
        addControls();
        addEvents();
    }
    
    public void addControls(){
        Container container= getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        JPanel pnCombo = new JPanel();
        pnCombo.setLayout(new FlowLayout());
        JLabel lblChonso=new JLabel("Chọn số: ");
        pnCombo.add(lblChonso);
        cboSo = new JComboBox();
        Random rd =new Random();
        for (int i = 0; i < 100; i++) {
            Integer x = rd.nextInt(500);
            cboSo.addItem(x);
        }
        pnCombo.add(cboSo);
        
        container.add(pnCombo);
        
        JPanel pnList = new JPanel();
        pnList.setLayout(new FlowLayout());
        JLabel lblChonso2=new JLabel("Chọn số trong list: ");
        listSo = new JList<>();
        Vector<Integer> vt = new Vector<>();
        for (int i = 0; i < 100; i++) {
            int x=rd.nextInt(500);
            vt.add(x);
        }
        listSo.setListData(vt);
        pnList.add(lblChonso2);
        
        JScrollPane scList = new JScrollPane(listSo, 
                                            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        pnList.add(scList);
        container.add(pnList);
        JPanel pnOK = new JPanel();
        pnOK.setLayout(new FlowLayout());
        btnOK = new JButton("OK");
        pnOK.add(btnOK);
        container.add(pnOK);
        
    }
    public void addEvents(){
        cboSo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int vt = cboSo.getSelectedIndex();
                if(vt!=-1){
                    JOptionPane.showMessageDialog(null, "Vi trí: "+vt
                            + "\nGiá trị = " + cboSo.getSelectedItem());
                }
            }
        }); 
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Integer selectedValue = listSo.getSelectedValue();
                int position = listSo.getSelectedIndex();
                JOptionPane.showMessageDialog(null, "Vị trí chọn: "+position 
                                              + "\nGía trị = "+selectedValue);
            }
        });
    }
    
    public void showWindow() {
        this.setSize(350, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        ComboboxListUI ui = new ComboboxListUI("Học Jcombobox và Jlist");
        ui.showWindow();
    }
    
}
