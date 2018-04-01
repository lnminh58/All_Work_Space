/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai21;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author lnmin
 */
public class SplitPanesUI extends JFrame {

    public SplitPanesUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();
        JPanel pnLeft = new JPanel();
        pnLeft.setPreferredSize(new Dimension(200, 0));
        JPanel pnRight = new JPanel();
        pnRight.setLayout(new BorderLayout());
        JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
        spMain.setOneTouchExpandable(true);
        con.add(spMain);

        JPanel pnRightTop = new JPanel();
        JPanel pnRightBottom = new JPanel();
        pnRightTop.setPreferredSize(new Dimension(0, 200));
        JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnRightTop,
                                            pnRightBottom);
        spRight.setOneTouchExpandable(true);
        pnRight.add(spRight,BorderLayout.CENTER);
        
    }

    public void addEvents() {

    }

    public void showWindows() {
        this.setSize(getMaximumSize());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SplitPanesUI ui = new SplitPanesUI("Chia đôi");
        ui.showWindows();
    }
}
