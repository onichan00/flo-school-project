package com.hva.helios.rest;
import com.hva.helios.notifications.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    @ResponseBody
    public String sendEmail(String to, String name, String from, String subject, String time, String body) {
        String emailFormat = String.format
                ("Beste %s,\n\n" +
                        "Er zijn nieuwe mededelingen in %s (project). De mededeling is als volgt:\n\n" +
                        "%s\n" +
                        "Deze mededeling is vandaag gestuurd door %s op %s.\n\n" +
                        "Met vriendelijke groet\n" +
                        "Team Florijn", name, subject, body, from, time);

        emailService.sendEmail(to, subject, emailFormat);
        return "Email sent!";
    }
}

