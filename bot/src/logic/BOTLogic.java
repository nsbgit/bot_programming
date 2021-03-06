package logic;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dto.Registration;

public class BOTLogic {
	
	private String pkey;
	/************	LOGIC OF SEND INFORMATION	*****/
	
	public boolean sendInfo(Registration registration) {
		//pkey = BOTLogic.createPassKey();
		
		boolean isSend = this.sendPassKey(registration.getSemail(), registration.getRpass(), registration.getRemail(), registration.getRemail(), registration.getSemail(), registration.getSpass());
		
		return isSend;
	}
	
	/******************************************/
	
	
	/****************	SEND MAIL	************************/
	public boolean sendPassKey(String userId,String password,String mailId,String personName, String sendresEmail, String senderPassword) {
		
		try {
			String from = sendresEmail;
			String to = mailId;
			String subject = "Confirm email id";
			//String username = userId;
			String pass = password;
			//String person = personName;
			String message = "Your passkey is : " + pass;
			Properties props = new Properties();
			props.setProperty("mail.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.port", "587");
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");
			
			Authenticator auth = new SMTPAuthenticator(sendresEmail,senderPassword);
			Session mailsession = Session.getInstance(props, auth);
			MimeMessage msg = new MimeMessage(mailsession);
			msg.setContent(message, "text/html");
			msg.setSubject(subject);
			msg.setFrom(new InternetAddress(from));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			Transport.send(msg);
		}
		catch (Exception e) {
			 e.printStackTrace();
			 return false;
		}
		
		
		return true;
	}
	/*************************************************/
	
	
	
	/***************	GENERATE PASSKEY	*********/
	public static String createPassKey() {
		Random random = new Random();
		
		String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		
		StringBuilder builder = new StringBuilder(alphabetString);
		
		char[] alphabet = builder.toString().toCharArray();
		
		StringBuilder generator = new StringBuilder();
		
		for(int i = 0; i<5; i++) {
			generator.append(alphabet[random.nextInt(alphabet.length)]);
		}
		return generator.toString();
	}
	/****************************************/
	
	
	/**********	CHECK PASSKEY	**********************/
	public boolean checkPasskey(String parameter, String key) {
		// TODO Auto-generated method stub
		if(parameter.equals(key))
			return true;
		else 
			return false;
	}
	
	/*****************************************************/

}
