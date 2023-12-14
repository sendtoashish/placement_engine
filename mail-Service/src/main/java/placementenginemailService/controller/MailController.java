package placementenginemailService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import placementenginemailService.entity.MailInfo;
import placementenginemailService.mailService.MailSender;

import javax.mail.internet.AddressException;


@Component
public class MailController {
     @Autowired
     private MailSender mailSender;




    @KafkaListener(topics = { "mailInfo" })
    private void sendMail(@RequestBody String mailDetail) throws JsonProcessingException, AddressException {
        ObjectMapper objectmapper = new ObjectMapper();
        MailInfo mail = objectmapper.readValue(mailDetail,MailInfo.class);
        mailSender.mailSender(mail);
        System.out.println(mailDetail);
    }
}
