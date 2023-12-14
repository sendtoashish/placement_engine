package placementengineauthenticationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialPayload {

    private String username;
    private String password;
}
