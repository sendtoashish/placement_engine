package placementengineauthenticationservice.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import placementengineauthenticationservice.entity.CredentialPayload;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthenticationService {

    public void authenticationService(CredentialPayload cp){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username",cp.getUsername());
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate psw = new RestTemplate();
        ResponseEntity<String> getpwd=  psw.postForEntity("http://localhost:8081/register/user/getpassword", requestEntity, String.class);
        System.out.println(getpwd);
    }

}
