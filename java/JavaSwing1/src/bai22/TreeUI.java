/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai22;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author lnmin
 */
public class TreeUI extends JFrame {

    DefaultMutableTreeNode root = null;
    JTree tree;

    public TreeUI(String title) {

        super(title);
        addControls();
        addEvents();
        fakeData();
    }

    public void showWindows() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void addControls() {
        Container con = getContentPane();
        JPanel pnTree = new JPanel();
        pnTree.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("Topica Edumall");
        tree = new JTree(root);
        JScrollPane sc = new JScrollPane(tree,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        pnTree.add(sc, BorderLayout.CENTER);
        pnTree.setPreferredSize(new Dimension(200, 0));
        con.setLayout(new BorderLayout());
        JPanel pnRight = new JPanel();
        JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        spMain.add(pnTree);
        spMain.add(pnRight);
        spMain.setOneTouchExpandable(true);
        con.add(spMain, BorderLayout.CENTER);

    }

    private void addEvents() {
        tree.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Object objSelected = tree.getLastSelectedPathComponent();
                JOptionPane.showMessageDialog(null, ((DefaultMutableTreeNode)objSelected).getUserObject().toString());
            
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
        tree.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                if (ke.getKeyCode()==127 ) {
                }
            }
        });
    }

    public static void main(String[] args) {
        TreeUI ui = new TreeUI("Học TreeUI");
        ui.showWindows();
    }

    private void fakeData() {
        DefaultMutableTreeNode nodePhtgv = new DefaultMutableTreeNode("Phòng hợp tác giảng viên");
        
        DefaultMutableTreeNode nodeNV1 = new DefaultMutableTreeNode("Nguyễn Hồng Đào");
        DefaultMutableTreeNode nodeNV2 = new DefaultMutableTreeNode("Lê Thành Công");
        nodePhtgv.add(nodeNV1);
        nodePhtgv.add(nodeNV2);
        DefaultMutableTreeNode nodeKt = new DefaultMutableTreeNode("Phòng Kế Toán");
        DefaultMutableTreeNode nodeKd = new DefaultMutableTreeNode("Phòng Kinh doanh");
        root.add(nodePhtgv);
        root.add(nodeKt);
        root.add(nodeKd);
        tree.expandRow(0);
        tree.expandRow(1);
    }
}
