/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai25;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author lnmin
 */
public class OptionPaneFileChooserUI extends JFrame {

    JMenuBar mnuBar;
    JMenu mnuFile;
    JMenuItem mnuFileSave, mnuFileOpen;
    JMenuItem mnuFileExit;
    JTextArea txtDaTa;
    JFileChooser chooser;
    public OptionPaneFileChooserUI(String title) {
        super(title);
        addControls();
        addEvents();
    }

    private void addControls() {
        setupMenuBar();
        Container con = getContentPane();
        con.setLayout(new BorderLayout());
        txtDaTa = new JTextArea(50, 50);
        txtDaTa.setLineWrap(true);
        txtDaTa.setWrapStyleWord(true);
        JScrollPane sc = new JScrollPane(txtDaTa,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        con.add(sc);
        chooser = new JFileChooser();
        chooser.setFileFilter( new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getAbsolutePath().endsWith(".txt")||!file.getAbsolutePath().contains(".");
            }

            @Override
            public String getDescription() {
                return "tập tin.txt";
            }
        });
    }

    private void addEvents() {
        mnuFileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                exitSystem();
            }
        });
        mnuFileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                openFile();
            }
        });
        mnuFileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                saveFile();
            }
        });
    }
    private void saveFile() {
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                String data =txtDaTa.getText();
            try {
                File selectedFile = chooser.getSelectedFile();
                FileOutputStream fos = new FileOutputStream(selectedFile);
                OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(data);
               
                bw.close();
                osw.close();
                fos.close();
                JOptionPane.showMessageDialog(null, "Lưu thành công");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }
    
    private void openFile() {
       
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile = chooser.getSelectedFile();
                FileInputStream fis = new FileInputStream(selectedFile);
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                String line = br.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null) {
                    sb.append(line);
                    line = br.readLine();
                }
                br.close();
                isr.close();
                fis.close();
                txtDaTa.setText(sb.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void exitSystem() {
        int showConfirmDialog = JOptionPane.showConfirmDialog(null,
                "Chăc chắn thoát phần mềm?",
                "Xác nhận thoát", JOptionPane.YES_NO_OPTION);

        if (showConfirmDialog == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void setupMenuBar() {
        mnuBar = new JMenuBar();
        setJMenuBar(mnuBar);
        mnuFile = new JMenu("Hệ Thống");
        mnuBar.add(mnuFile);
        mnuFileSave = new JMenuItem("Lưu tập tin");
        mnuFileOpen = new JMenuItem("Mở tập tin");
        mnuFileExit = new JMenuItem("Thoát phần mềm");
        mnuFile.add(mnuFileOpen);
        mnuFile.add(mnuFileSave);
        mnuFile.addSeparator();
        mnuFile.add(mnuFileExit);
        mnuFile.add(mnuFileExit);

    }

    public void showWindow() {
        this.setSize(700, 500);
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
        OptionPaneFileChooserUI ui = new OptionPaneFileChooserUI("JOptionPanel và JFileChooser");
        ui.showWindow();
        System.out.println("bai25.OptionPaneFileChooserUI.main()");
    }

}
