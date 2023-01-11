package com.hva.helios.rest;

import com.hva.helios.notifications.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class for handling email related requests.
 * @author Simon Vriesema
 */
@Controller
public class EmailController {

    /**
     * Service class responsible for sending emails.
     */
    @Autowired
    private EmailService emailService;

    /**
     * Handles GET requests to the '/send-email' endpoint.
     * Sends an email to the specified 'to' address with the specified subject and body.
     * The email body is constructed using the provided 'name', 'from', 'time', and 'subject' parameters.
     *
     * @param to the email address of the recipient
     * @param name the name of the recipient
     * @param from the name of the sender
     * @param subject the subject of the email
     * @param time the time at which the email is sent
     * @param body the body of the email
     * @return a message indicating that the email has been sent
     */
    @GetMapping("/send-email")
    @ResponseBody
    public String sendEmail(String to, String name, String from, String subject, String time, String body) {
        // Construct the body of the email using the provided parameters
        String emailFormat = String.format(
                "Beste %s,\n\n" +
                        "Er zijn nieuwe mededelingen in %s (project). De mededeling is als volgt:\n\n" +
                        "%s\n" +
                        "Deze mededeling is vandaag gestuurd door %s op %s.\n\n" +
                        "Met vriendelijke groet\n" +
                        "Team Florijn",
                name, subject, body, from, time
        );

        // Call the sendEmail method of the EmailService class to send the email
        emailService.sendEmail(to, subject, emailFormat);
        return "Email sent!";
    }
}
