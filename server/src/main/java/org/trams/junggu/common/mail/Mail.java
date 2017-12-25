package org.trams.junggu.common.mail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class Mail {
	private MailSender mailSender;
	private SimpleMailMessage simpleMailMessage;
	
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String to,String header, String subject,String content) {
		SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);
		message.setTo(to);
		message.setText(String.format(simpleMailMessage.getText(),header, subject, content));
		mailSender.send(message);
		
	}
}
