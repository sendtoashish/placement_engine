package placementenginejobposting.entity;


import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class MailInfo {

    private String sendTo;
    private String message;
    private String subject;
}
