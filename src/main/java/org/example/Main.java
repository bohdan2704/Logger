package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.trace("Logger message trace level info");
        logger.debug("Logger message debug level info");
        logger.info("Logger message info level info");
        logger.info("Logger message info level info");
        logger.warn("Logger message warn level info");
        logger.error("Logger message error level info");
//        emailMe();
    }

    public static void emailMe() {
        final String username = "bohdan.hohol.oi.2022@lpnu.ua"; // Your Gmail email address
        final String password = "my password";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("gogolbohdan2005@gmail.com"));
            message.setSubject("Subject of the Email");
            message.setText("Body of the Email");

            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

