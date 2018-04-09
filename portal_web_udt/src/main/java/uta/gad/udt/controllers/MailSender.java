package uta.gad.udt.controllers;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailSender {
	public MailSender() { 
	   } 
	   public static boolean send(String hostSmtp, String senderAddress, String toAddress, 
	       String ccAddress, String bccAddress, String subject, 
	       boolean isHTMLFormat, StringBuffer body, boolean debug){ 

	   MimeMultipart multipart = new MimeMultipart(); 

	   Properties properties = new Properties(); 

	    properties.put("mail.smtp.host", hostSmtp);
	    properties.put("mail.smtp.port",587); 
	    properties.put("mail.smtp.username","apatriciol_@hotmail.com");
	    properties.put("mail.smtp.password","jSsA1991");
	   Session session = Session.getDefaultInstance(properties, null); 
	   session.setDebug(debug); 
	   try { 
	      MimeMessage msg = new MimeMessage(session); 
	      msg.setFrom(new InternetAddress(senderAddress)); 
	      msg.setRecipients(Message.RecipientType.TO, toAddress); 
	      msg.setRecipients(Message.RecipientType.CC, ccAddress); 
	      msg.setRecipients(Message.RecipientType.BCC, bccAddress); 
	      msg.setSubject(subject); 
	      msg.setSentDate(new Date()); 

	      // BODY 
	      MimeBodyPart mbp = new MimeBodyPart(); 
	      if(isHTMLFormat){ 
	         mbp.setContent(body.toString(), "text/html"); 
	      } 
	      else{ 
	         mbp.setText(body.toString()); 
	      } 

	      multipart.addBodyPart(mbp); 

	      msg.setContent(multipart); 
	      Transport.send(msg); 
	   } 
	   catch (Exception mex){ 
	      System.out.println(">> MailSender.send() error = "+mex ); 
	      return false; 
	   } 
	   return true; 
	  } 
}
