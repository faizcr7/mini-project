/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.*;
import jakarta.mail.*;      //package in GlassFish Server
import jakarta.mail.internet.*;

/**
 *
 * @author faiz
 */
public class MailSender {
    public void sendMail(String emailto){
        String from="faiz7294@gmail.com";
        final String username= "faiz7294";
        final String password= "nwthgbevldpwnspl";
        Properties props= new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.ssl.trust","smtp.gmail.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session= Session.getInstance(props,new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });
        
        try{
            Message msg=  new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailto));
            msg.setSubject("Welcome to MY APP");
            msg.setText("Please verify by clicking here<a href=\"#\">Verify </a>");
            Transport.send(msg);
        }catch(MessagingException mex){
            mex.printStackTrace();
        }
            
            
        }
}
