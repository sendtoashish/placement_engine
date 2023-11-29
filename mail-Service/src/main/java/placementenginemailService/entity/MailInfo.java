package placementenginemailService.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MailInfo {

    private String sendTo;
    private int otp;

    private String subject = "Your Otp is in the message";
}
