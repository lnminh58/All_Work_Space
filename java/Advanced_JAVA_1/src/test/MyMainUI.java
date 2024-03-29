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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nguyenducthao
 */
public class MyMainUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public MyMainUI(String title) {

        setTitle(title);

    }

    public void doShow() {

        setSize(400, 200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addControl();

        setVisible(true);

    }

    public void addControl() {

        JPanel pnBox = new JPanel();

        JButton btn1 = new JButton("Open MyUI1");

        JButton btn2 = new JButton("Open MyUI2");

        pnBox.add(btn1);

        pnBox.add(btn2);

        btn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                MyUI1 ui1 = new MyUI1("Hello Teo!");

                ui1.setVisible(true);

            }

        });

        btn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                MyUI2 ui2 = new MyUI2("Hello Teo!");

                ui2.setModal(true);

                ui2.setVisible(true);

            }

        });

        Container con = getContentPane();

        con.add(pnBox);

    }

    public static void main(String[] args) {

        MyMainUI mainUI = new MyMainUI("Demo OPen Another Windows");

        mainUI.doShow();

    }
}
