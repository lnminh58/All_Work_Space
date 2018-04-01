/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author nguyenducthao
 */
public class showDialog extends JDialog{
    public showDialog(String title) {

        setTitle("Thông báo");
        JPanel pn = new JPanel();
        JButton buttonOK = new JButton("OK");
        JLabel label = new JLabel(title);
        pn.add(label);
        pn.add(buttonOK);
        
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
Container con = getContentPane();

        con.add(pn);

        setSize(200, 100);

        setLocationRelativeTo(null);
    }
}
