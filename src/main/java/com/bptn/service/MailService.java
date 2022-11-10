package com.bptn.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Async
	public void sendEmail() throws AddressException, MessagingException {

		   Properties props = new Properties();
		   
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com"); // This code for sending emails
		   props.put("mail.smtp.port", "587");
		   
		   //  port 587 The standard secure SMTP port
		   // pop is for sending emails

           /*
            * Ensure a new password is created properly
            * with the google two-steps verification
		    * As this example uses Gmail, please ensure a new password is 
            * created properly with the Google two-step verification feature.
		    */    
        
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("abdi.hassan7077@gmail.com", "xzgfylidljbtevom");
		      }
		   });
		   
		   Message msg = new MimeMessage(session);
		   //Mime message stands for 
		   // Multipurpose InternetMail Extentions: Standard
		   
		   msg.setFrom(new InternetAddress("abdi.hassan7077@gmail.com", false));

           /* Recipient */
		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abdi.hassan7077@gmail.com"));
		   msg.setSubject("I Love Spring Mail");
		   msg.setContent("Welcome to Spring Mail", "text/html");
		   msg.setSentDate(new Date());

		   Multipart multipart = new MimeMultipart(); //Create a MultiPart Message 
		   
		   // MimeBodyPart will be able
		   MimeBodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setContent("I love Spring", "text/html");
		   multipart.addBodyPart(messageBodyPart); // Add the body to the MultiPart
		   
		   /*
		   MimeBodyPart attachPart = new MimeBodyPart();
		   attachPart.attachFile("/var/tmp/bptn.png");
		   multipart.addBodyPart(attachPart);*/ // Add the attachment to the MultiPart
		   
		   msg.setContent(multipart);
		   
		   Transport.send(msg);   
		}
}