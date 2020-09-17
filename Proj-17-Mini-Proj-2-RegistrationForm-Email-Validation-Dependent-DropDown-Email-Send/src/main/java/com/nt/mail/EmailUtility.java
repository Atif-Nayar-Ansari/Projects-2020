package com.nt.mail;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.nt.domain.UserAccounts;

@Service
public class EmailUtility {

	
	 //this logic send just the simple msg through the mail
	 
	@Autowired
	private JavaMailSender jms;
	 
	public boolean sendUserEmail(UserAccounts acc) {
		boolean isSent = false;
		try{
			
		/*	SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(acc.getEmail());
			msg.setSubject("Unlock your account....");
			msg.setText(getUnlockAccEmailBody(acc));
			
			jms.send(msg);
			isSent = true;  */
			
			MimeMessage mimeMsg = jms.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMsg);
			helper.setTo(acc.getEmail());
			helper.setSubject("Unlock your account....");
			helper.setText(getUnlockAccEmailBody(acc),true); //if we want our html tags are to work then we have to write the true here
			jms.send(mimeMsg);
			isSent = true; 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isSent;
	}
	
	public String getUnlockAccEmailBody(UserAccounts acc)throws Exception{
		
		StringBuffer sb = new StringBuffer("");
		
		FileReader fr = new FileReader("MAIL_TEMPLATE.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while(line!=null) {
			sb.append(line);
			line = br.readLine();
		}
		
		//format mailbody
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}",acc.getFirstName());
		mailBody = mailBody.replace("{LNAME}",acc.getLastName());
		mailBody = mailBody.replace("{PASS}",acc.getPazzword());//exception comming
		mailBody = mailBody.replace("{EMAIL}",acc.getEmail());
		//br.close();
		return mailBody;
		
	}
	
}
