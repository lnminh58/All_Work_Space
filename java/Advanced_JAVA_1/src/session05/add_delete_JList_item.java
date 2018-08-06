/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session05;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static sun.misc.ClassFileTransformer.add;

/**
 *
 * @author nguyenducthao
 */
public class add_delete_JList_item extends JFrame implements ActionListener {

    private int width = 350;
    private int height = 250;
    private JTextField tfAdd;
    private JList<String> myList;

    public add_delete_JList_item() {
        // add main panel
        add(createMainPanel());

        // display
        setTitle("Add - delete item in JList");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createMainPanel() {
        // create main panel
        JPanel panel = new JPanel(new BorderLayout());
        // set border empty for main panel
        panel.setBorder(new EmptyBorder(0, 10, 10, 10));
        // add content
        panel.add(createDeletePanel(), BorderLayout.PAGE_START);
        panel.add(createAddPanel(), BorderLayout.PAGE_END);
        panel.add(createList(), BorderLayout.CENTER);
        return panel;
    }

    // delete panel in top of frame
    private JPanel createDeletePanel() {
        JPanel panel = new JPanel();
        panel.add(createButton("Delete"));
        return panel;
    }

    // add panel in bottom of frame
    private JPanel createAddPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(tfAdd = new JTextField());
        panel.add(createButton("Add"));
        return panel;
    }

    // create Jlist
    private JList<String> createList() {
        // create defaultListModel
        DefaultListModel<String> model = new DefaultListModel<>();
        // add element to model
        model.addElement("Java");
        model.addElement("C#");
        // set model to JList
        myList = new JList<String>(model);
        return myList;
    }

    // create a button
    private JButton createButton(String btnName) {
        JButton btn = new JButton(btnName);
        btn.addActionListener(this);
        return btn;
    }

    private void deleteItem() {
        // get model of Jlist
        DefaultListModel<String> model = (DefaultListModel<String>) myList
                .getModel();
        // delete item is selected
        if (!model.isEmpty() && myList.getSelectedIndex() >= 0) {
            model.remove(myList.getSelectedIndex());
        }
        // set model for JList
        myList.setModel(model);
    }

    private void addItem() {
        String item = tfAdd.getText().trim();
        if (item.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "Pleas enter item add to Jlist", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultListModel model = (DefaultListModel) myList.getModel();
            model.addElement(item);
            myList.setModel(model);
            tfAdd.setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Delete") {
            deleteItem();
            return;
        }
        if (e.getActionCommand() == "Add") {
            addItem();
        }
    }

    public static void main(String[] args) {
        add_delete_JList_item myJList = new add_delete_JList_item();
    }
}

/*
Trong ví dụ này JList được khởi tạo với 1 model là DefaultListModel, đó là 1 model mà Java xây dựng sẵn cho chúng ta, 
nó rất dễ sử dụng. Việc thêm bớt phần tử vào JList bắt buộc chúng ta phải thực hiện thông qua model của JList 
chứ không thể làm trực tiếp được (Trừ khi mỗi lần thêm bớt bạn dùng 1 list (hoặc mảng) các phần tử 
và lại tạo lại JList đó).
*/