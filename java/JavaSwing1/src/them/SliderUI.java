/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package them;

import bai24.TabbedPaneUI;
import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicMenuUI;

/**
 *
 * @author lnmin
 */
public class SliderUI extends JFrame {

    JPanel pnMain;
    JSlider sldRed;
    JSlider sldBlue;
    JSlider sldGreen;
    int value1, value2, value3;

    public SliderUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        Container con = getContentPane();
        pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        sldRed = new JSlider(JSlider.HORIZONTAL, 0, 255, 30);
//        sldRed.setMinorTickSpacing(5);
//        sldRed.setMajorTickSpacing(10);
//        sldRed.setPaintTicks(true);
        sldBlue = new JSlider(JSlider.HORIZONTAL, 0, 255, 30);
        sldGreen = new JSlider(JSlider.HORIZONTAL, 0, 255, 30);
        pnMain.add(sldRed);
        pnMain.add(sldGreen);
        pnMain.add(sldBlue);
        con.add(pnMain);

    }

    private void addEvents() {

        sldRed.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                value1 = sldRed.getValue();
                pnMain.setBackground(new Color(value1, value2, value3));
            }
        });
        sldBlue.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                value2 = sldBlue.getValue();
                pnMain.setBackground(new Color(value1, value2, value3));
            }
        });
        sldGreen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent ce) {
                value3 = sldGreen.getValue();
                pnMain.setBackground(new Color(value1, value2, value3));
            }
        });

    }

    public void showWindows() {
        this.setSize(500, 500);
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
        SliderUI ui = new SliderUI("Đổi màu");
        ui.showWindows();
    }
}
