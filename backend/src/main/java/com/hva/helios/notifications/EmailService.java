package com.hva.helios.notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * A service for sending emails.
 * @author Simon Vriesema
 */
@Service
public class EmailService {
    /**
     * An autowired instance of `JavaMailSender`, which is used to send emails.
     */
    @Autowired
    public JavaMailSender emailSender;

    /**
     * Sends a simple email message.
     * @param to the recipient's email address
     * @param subject the subject of the email
     * @param text the body of the email
     */
    public void sendEmail(String to, String subject, String text) {
        // Create a SimpleMailMessage instance.
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to); // Set the recipient's email address.
        message.setSubject(subject); // Set the subject of the email.
        message.setText(text); // Set the body of the email.
        emailSender.send(message); // Send the email.
    }
}
