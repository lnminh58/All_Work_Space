/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai23;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 *
 * @author lnmin
 */
public class MenuContextMenuToolbarUI extends JFrame {

    JMenuBar mnuBar;
    JMenu mnuFile, mnuEdit, mnuHelp;
    JMenuItem mnuFileNew, mnuFileOpen, mnuFileExit;
    JMenuItem mnuEditCopy, mnuEditPaste, mnuEditDelete;
    JMenuItem mnuHelpGui, mnuHelpAbout;
    JButton btnButton1,btnButton2;
    JMenuItem mnuPopUpMauXanh,mnuPopUpMauDo;
    JButton btnLastSelected;
    public MenuContextMenuToolbarUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        mnuBar = new JMenuBar();
        setJMenuBar(mnuBar);
        mnuFile= new JMenu("File");
        mnuBar.add(mnuFile);
        mnuEdit= new JMenu("Edit");
        mnuBar.add(mnuEdit);
        mnuHelp= new JMenu("Help");
        mnuBar.add(mnuHelp);
        
        mnuFileNew = new JMenuItem("New");
        mnuFileNew.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        mnuFileOpen = new JMenuItem("Open");
        mnuFileExit = new JMenuItem("Exit");
        mnuFile.add(mnuFileNew);
        mnuFile.add(mnuFileOpen);
        mnuFile.addSeparator();
        mnuFileExit.setIcon(new ImageIcon("D:\\workspace\\java\\JavaSwing1\\src\\hinh\\exit.png"));
        mnuFile.add(mnuFileExit);
                
        mnuEditCopy = new JMenuItem("Copy");
        mnuEditPaste = new JMenuItem("Paste");
        mnuEditDelete = new JMenuItem("Delete");
        mnuEdit.add(mnuEditCopy);
        mnuEdit.add(mnuEditPaste);
        mnuEdit.add(mnuEditDelete);
        
        mnuHelpGui = new JMenuItem("GUI");
        mnuHelpAbout = new JMenuItem("About");
        mnuHelp.add(mnuHelpGui);
        mnuHelp.add(mnuHelpAbout);
        
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new FlowLayout());
        btnButton1 = new JButton("Button 1");
        btnButton2 = new JButton("Button 1");
        pnMain.add(btnButton1);
        pnMain.add(btnButton2);
        con.add(pnMain);

        btnButton1.addMouseListener(new PopClickListener());
        btnButton2.addMouseListener(new PopClickListener());
        
        


    }
    
    private void addEvents() {
        mnuFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        mnuFileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Bạn vừa gõ ctrl+N");
            }
        });
    }
    class PopUpDemo extends JPopupMenu{
        public PopUpDemo(){
            mnuPopUpMauDo = new JMenuItem("Tô màu đỏ");
            add(mnuPopUpMauDo);
            mnuPopUpMauXanh = new JMenuItem("Tô màu Xanh");
            add(mnuPopUpMauXanh);
            
            mnuPopUpMauDo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    btnLastSelected.setBackground(Color.RED);
                }
            });
            
             mnuPopUpMauXanh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    btnLastSelected.setBackground(Color.BLUE);
                }
            });
        }
    }
    
    class PopClickListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent me) {
            if(me.isPopupTrigger()){
                doPop(me);
            }
        }

        @Override
        public void mousePressed(MouseEvent me) {
             if(me.isPopupTrigger()){
                doPop(me);
            }
        }

        private void doPop(MouseEvent me) {
            PopUpDemo menu=new PopUpDemo();
            btnLastSelected= (JButton) me.getComponent();
            menu.show(me.getComponent(), me.getX(),me.getY());
        }

        
        
    }
    
    public void showWindows() {
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        MenuContextMenuToolbarUI ui = new MenuContextMenuToolbarUI("Học Menu");
        ui.showWindows();
    }
}
