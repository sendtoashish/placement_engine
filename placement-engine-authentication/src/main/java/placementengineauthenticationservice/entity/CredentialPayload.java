package placementengineauthenticationservice.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CredentialPayload {

    private String username;
    private String password;
}
