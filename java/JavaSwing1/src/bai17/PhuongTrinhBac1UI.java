package bai17;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lnmin
 */
public class PhuongTrinhBac1UI extends  JFrame{
    JTextField txtANumber;
    JTextField txtBNumber;
    JButton btnSolve;
    JButton btnExit;
    JTextField txtResult;
    
    ActionListener envenSolve = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            xuLyGiaiPhuongTrinh();
        }
    };
    private void xuLyGiaiPhuongTrinh(){
        String aNumber= txtANumber.getText();
        String bNumber= txtBNumber.getText();
        
        double a=Double.valueOf(aNumber);
        double b=Double.valueOf(bNumber);
        if(a==0 && b==0){
            txtResult.setText("Vô số nghiệm");
        }else if(a==0&&b!=0){
            txtResult.setText("Vô nghiệm");
        }else{
            Double result = -b/a;
            DecimalFormat dcf =new DecimalFormat("#.###");
            txtResult.setText(dcf.format(result));
        }
        
        
    }
    
    public PhuongTrinhBac1UI (String title){
        super(title);
        addControls();
        addEvents();
    }
    public void addEvents(){
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        btnSolve.addActionListener(envenSolve);
    }
    public void addControls(){
        Container container = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
        container.add(pnMain);
        
        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(new FlowLayout());
        JLabel lblTitle = new JLabel("Giải phương trình bậc 1");
        pnTitle.setBackground(Color.darkGray);
        lblTitle.setForeground(Color.GREEN);
        Font fontTieuDe= new Font("arial", Font.BOLD, 20);
        lblTitle.setFont(fontTieuDe);
        pnTitle.add(lblTitle);
        pnMain.add(pnTitle);
        
        JPanel pnANumber = new JPanel();
        pnANumber.setLayout(new FlowLayout());
        JLabel lblANumber = new JLabel("Hệ số a: ");
        txtANumber = new JTextField(15);
        pnANumber.add(lblANumber);
        pnANumber.add(txtANumber);
        pnMain.add(pnANumber);
        
        JPanel pnBNumber = new JPanel();
        pnANumber.setLayout(new FlowLayout());
        JLabel lblBNumber = new JLabel("Hệ số b: ");
        txtBNumber = new JTextField(15);
        pnBNumber.add(lblBNumber);
        pnBNumber.add(txtBNumber);
        pnMain.add(pnBNumber);
        
        JPanel pnButton = new JPanel();
        btnSolve = new JButton("Giải");
        btnExit = new JButton("Thoát");
        pnButton.add(btnSolve);
        pnButton.add(btnExit);
        pnMain.add(pnButton);
        
        JPanel pnResult = new JPanel();
        pnResult.setLayout(new FlowLayout());
        JLabel lblResult= new JLabel("Kết quả");
        txtResult = new JTextField(20);
        pnResult.add(lblResult);
        pnResult.add(txtResult);
        pnMain.add(pnResult);
    }
    public void showWindow(){
        this.setSize(400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
