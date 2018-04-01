/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author nguyenducthao
 */
public class Client1 extends JFrame implements ActionListener{
    JLabel b1=new JLabel("UserName");
 JTextField tuser=new JTextField(25);
 
 JLabel b3=new JLabel("Password");
 JTextField tpass=new JTextField(25);
 
 JButton bregister=new JButton("Register");
 public Client1() {
 // TODO Auto-generated constructor stub
 }
 public static void main(String[] args) throws Exception {
 // TODO Auto-generated method stub
 Client1 cl=new Client1();
 cl.add(cl.register());
 }
 public void accept_Client(String user,String pass) throws Exception{
 Socket sk=new Socket("localhost",8080);
 DataOutputStream dos= new DataOutputStream(sk.getOutputStream());
 dos.writeUTF(user+" "+pass);
 
 DataInputStream din=new DataInputStream(sk.getInputStream());
 
 System.out.println("server gui:"+din.readUTF());
 sk.close();
 }
 public JFrame register(){
 JFrame jf=new JFrame("design by Huutrieuit");
 GridLayout grid=new GridLayout(3,2);
 jf.setLayout(grid);
 jf.add(b1);
 jf.add(tuser);
 jf.add(b3);
 jf.add(tpass);
 jf.add(new JLabel(""));
 jf.add(bregister);
 bregister.addActionListener(this);
 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 jf.pack();
 jf.setVisible(true);
 return jf;
 }
 // xu ly su kien
 @Override
 public void actionPerformed(ActionEvent ae){
 // TODO Auto-generated method stub
 try{
 if(ae.getSource()==bregister)
 accept_Client(tuser.getText(),tpass.getText());
 }catch(Exception e){
 System.out.println("actionperformed"+e);
 }
 }
}
