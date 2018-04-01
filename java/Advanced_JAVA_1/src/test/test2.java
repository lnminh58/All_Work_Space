/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nguyenducthao
 */
public class test2 extends JFrame {

    JPanel mainPanel;
    JTable tableData;

    void create_JFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("List student");
        setSize(550, 140);
        setLocationRelativeTo(null);
//        setResizable(false);
    }

    void create_mainPanel() {
        mainPanel = new JPanel();
    }
void create_and_add_Table_to_mainPanel(){
    tableData=new JTable(5, 3);
    
    mainPanel.add(tableData);
}
    

    

    void addMainPanel_to_JFrame() {
        add(this.mainPanel);
    }

    void displayJFrame() {
        setVisible(true);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        test2 test = new test2();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
        test.create_JFrame();
        test.create_mainPanel();
        test.create_and_add_Table_to_mainPanel();
        test.addMainPanel_to_JFrame();
        test.displayJFrame();
    }
}

class MyTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}