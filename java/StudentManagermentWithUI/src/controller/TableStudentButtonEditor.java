/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.myUtil;
import view.frmMain;

/**
 *
 * @author nguyenducthao
 */
public class TableStudentButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private String label;
    private boolean isPushed;

    public TableStudentButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fireEditingStopped();
                } catch (Exception error) {
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    @Override
    public Object getCellEditorValue() {
        if (isPushed) {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this student?", "Comfirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == 0) {
                try {
                    controllerStudent.deleteStudentByCode(frmMain.tblStudent.getValueAt(frmMain.tblStudent.getSelectedRow(), 1).toString());
                    JOptionPane.showMessageDialog(null, "Delete success a student from database!", "Message", JOptionPane.INFORMATION_MESSAGE);
                    myUtil.updateAllInformationAfterDeleteStudent();
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(TableStudentButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
                // de set lai selectedrow sau khi xoa dong cuoi trong jTabe thi su dung
                // TableBatchButtonEditor.this.cancelCellEditing();
                // hoac frmMain.tblBatch.setRowSelectionInterval(frmMain.tblBatch.getSelectedRow(), frmMain.tblBatch.getSelectedRow());
//                TableBatchButtonEditor.this.cancelCellEditing();
                frmMain.tblStudent.setRowSelectionInterval(frmMain.tblStudent.getSelectedRow(), frmMain.tblStudent.getSelectedRow());
            }
        }
        isPushed = false;
        return label;
    }

    @Override
    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }
}
