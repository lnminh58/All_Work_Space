/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author nguyenducthao
 */
public class test1 {

    public static void main(String[] args) throws Exception {
        
		// Email ID cua nguoi nhan can duoc de cap den.
      String to = "ndthaodng@gmail.com";

      // Email ID cua nguoi gui can duoc de cap den
      String from = "CraigLConner1@gmail.com";

      // Gia su ban dang gui email tu localhost
      String host = "smtp.gmail.com";

      // Lay cac system properties
      Properties properties = System.getProperties();

      // Thiet lap mail server
      properties.setProperty("mail.smtp.host", host);

      // Lay doi tuong Session mac dinh.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Tao mot doi tuong MimeMessage mac dinh.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field.
         message.setFrom(new InternetAddress(from));

         // Set To: header field.
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Day la dong Subject!");

         // Bay gio thiet lap message thuc su
         message.setText("Day la message thuc su");

         // Send message
         Transport.send(message);
         System.out.println("Gui message thanh cong....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
        
    }

    

}
