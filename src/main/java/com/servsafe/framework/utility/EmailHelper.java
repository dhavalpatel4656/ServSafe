package com.servsafe.framework.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;

public class EmailHelper {

	public static String check(String host, String storeType, String user, String password) {
		String content = "";
		try {
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			properties.put("mail.imap.ssl.trust", host);
			Session emailSession = Session.getDefaultInstance(properties);
			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);
			Folder inbox = store.getFolder("Inbox");
			inbox.open(Folder.READ_WRITE);
			Message[] messages = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
			Message message = messages[messages.length - 1];
			message.setFlag(Flag.SEEN, true);
			String contentType = message.getContentType();
			if (contentType.contains("TEXT/HTML")) {
				content = message.getContent().toString();
			} else {
				MimeMultipart multiPart = (MimeMultipart) message.getContent();
				BodyPart bodyPart = multiPart.getBodyPart(0);
				InputStream input = bodyPart.getInputStream();
				byte[] byteArr = input.readAllBytes();
				content = new String(byteArr, StandardCharsets.UTF_8);
			}
			inbox.close(false);
			store.close();
			FileWriter fw = new FileWriter(new File("test.txt"));
			fw.write(content);
			fw.flush();
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				if (line.contains(
						"<td class=\"element\" style=\"text-size-adjust:none;text-align:left;\"> <span style=\"line-height:1.5;mso-font-alt: 'Helvetica Neue';font-family:Arial, 'Helvetica Neue', Helvetica, sans-serif;font-weight:700;font-size:24px;letter-spacing:3px;\">")) {
					line = line.trim();
					content = line.split("spacing:3px;\">")[1].trim();
					break;
				}
				line = br.readLine();
			}
			br.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CommonHelper.fetchOnlyDigits(content);
	}

	public static void main(String[] args) {
		String host = "imap.gmail.com";
		String mailStoreType = "imap";
		String username = "dhaval.patelservsafe@gmail.com";
		String password = "Automation@2022";
		System.out.println(check(host, mailStoreType, username, password));
	}
}