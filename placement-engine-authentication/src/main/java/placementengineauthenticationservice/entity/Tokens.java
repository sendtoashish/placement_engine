package placementengineauthenticationservice.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import placementengineauthenticationservice.utils.JwtConstant;

import java.io.Serializable;

@Data
public class Tokens implements Serializable {
    private static final long serialVersionUID = 1L;
    private String token_type = JwtConstant.JWT.name();
    private String access_token;
    public Tokens(String access_token) {
        this.access_token = access_token;


    }
}
