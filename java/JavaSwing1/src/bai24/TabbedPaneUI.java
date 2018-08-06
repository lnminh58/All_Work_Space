/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai24;

import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lnmin
 */
public class TabbedPaneUI extends JFrame {

    JTabbedPane tab;

    public TabbedPaneUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        Container con = getContentPane();
        tab = new JTabbedPane();
        con.add(tab);

        JPanel pnTab1 = new JPanel();
        JPanel pnTab2 = new JPanel();
        JPanel pnTab3 = new JPanel();
        tab.add(pnTab1, "Cấu hình");
        tab.add(pnTab2, "Bảo mật");
        tab.add(pnTab3, "Phân quyền");
        pnTab1.setBackground(Color.RED);
        pnTab2.setBackground(Color.GREEN);
        pnTab3.setBackground(Color.BLUE);
        pnTab3.setBackground(Color.getHSBColor(123, 255, 189));
        
    }

    private void addEvents() {
    }

   

    public void showWindows() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        TabbedPaneUI ui = new TabbedPaneUI("Tabbed");
        ui.showWindows();
    }

}
