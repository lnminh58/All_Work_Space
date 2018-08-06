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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nguyenducthao
 */
public class create_Simple_Table extends JPanel {

    private final boolean DEBUG = false;

    public create_Simple_Table() {
        super(new GridLayout(1, 0));

        JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(500, 90));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    class MyTableModel extends AbstractTableModel {

        private String[] columnNames = new String[5];
        private Object[][] data = new Object[5][5];

        public MyTableModel() {
            String[] fileNames = {
            "user1.jpg", "user1.jpg", "user1.jpg", "user1.jpg"
        };
        BufferedImage[] images = new BufferedImage[fileNames.length];
        for (int j = 0; j < images.length; j++) {
            try {
                URL url = getClass().getResource(fileNames[j]);
                images[j] = ImageIO.read(url);
            } catch (MalformedURLException mue) {
                System.err.println("url: " + mue.getMessage());
            } catch (IOException ioe) {
                System.err.println("read: " + ioe.getMessage());
            }
        }
            columnNames[0] = "First Name";
            columnNames[1] = "Last Name";
            columnNames[2] = "Sport";
            columnNames[3] = "# of Years";
            columnNames[4] = "Vegetarian";
            data[0][0]= "Kathy";
                data[0][1] = "Smith";
                data[0][2] = images[0];
                data[0][3] = 5;
                data[0][4] = false;
                data[1][0]="John";
                data[1][1]="Doe";
                data[1][2]="Rowing";
                data[1][3]=3;
                data[1][4]=true;
                data[2][0]="Sue";
                data[2][1]="Black";
                data[2][2]="Knitting";
                data[2][3]=2;
                data[2][4]=false;
//                {"Jane"
//                , "White","Speed reading", 20, true},
//                {"Joe"
//                
//                
//            , "Brown","Pool", 10, false}
//        };
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */
        @Override
        public boolean isCellEditable(int row, int col) {
            //Note that the data/cell address is constant,
            //no matter where the cell appears onscreen.
            if (col < 2) {
                return false;
            } else {
                return true;
            }
        }

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        @Override
        public void setValueAt(Object value, int row, int col) {
            if (DEBUG) {
                System.out.println("Setting value at " + row + "," + col
                        + " to " + value
                        + " (an instance of "
                        + value.getClass() + ")");
            }

            data[row][col] = value;
            fireTableCellUpdated(row, col);

            if (DEBUG) {
                System.out.println("New value of data:");
                printDebugData();
            }
        }

        private void printDebugData() {
            int numRows = getRowCount();
            int numCols = getColumnCount();

            for (int i = 0; i < numRows; i++) {
                System.out.print("    row " + i + ":");
                for (int j = 0; j < numCols; j++) {
                    System.out.print("  " + data[i][j]);
                }
                System.out.println();
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        create_Simple_Table newContentPane = new create_Simple_Table();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
