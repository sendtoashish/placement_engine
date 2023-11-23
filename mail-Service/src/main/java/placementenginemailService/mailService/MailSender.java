package placementenginemailService.mailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;


@Component
@Slf4j
public class MailSender {

    public boolean mailSender() throws AddressException {
        log.debug("Start: Email Service");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sendtoashish123@gmail.com", "vquzjelhoimioami");
            }
        });
        try {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress("sendtoashish123@gmail.com"));
            mm.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress("sendtoashish123@gmail.com@gmail.com"));
            mm.addRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress("possiadian@gmail.com"));

            mm.setSubject("Mail Check");

            mm.setText("This is the testmail", "utf-8", "html");
            Transport.send(mm);
            log.debug("Email sent successfully...");
            return true;
        } catch (MessagingException e) {
            log.error("Problem to send email..." + e);
            return false;
        }
    }
}
