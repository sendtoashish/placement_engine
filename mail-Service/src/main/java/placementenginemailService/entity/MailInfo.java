package placementenginemailService.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MailInfo {

   private String sendTo;
    private String message;
    private String subject;

}
