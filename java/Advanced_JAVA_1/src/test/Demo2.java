/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author nguyenducthao
 */
import javax.swing.*;
import java.beans.*;
// For property change listener interface and classes
import java.awt.*;
import java.io.File;
public class Demo2 {
    public static void main(String[] args) {
        JFrame frm;
JMenuBar mnbBar;
JMenu mnuFile, mnuEdit, mnuView, mnuHelp;
mnbBar = new JMenuBar();
// Creates a frame
frm = new JFrame();
frm.setSize(400,400);
frm.add(mnbBar);
mnuFile = new JMenu("File");
mnuEdit = new JMenu("Edit");
mnuView = new JMenu("View");
mnuHelp = new JMenu("Help");
// Add the menus
mnbBar.add(mnuFile);
mnbBar.add(mnuEdit);
mnbBar.add(mnuView);
// Add a Horizontal Glue
mnbBar.add(Box.createHorizontalGlue());
// Add the last menu
mnbBar.add(mnuHelp);
frm.setJMenuBar(mnbBar);
frm.setVisible(true);
    }
}
