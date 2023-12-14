package placementengineauthenticationservice.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import placementengineauthenticationservice.DAO.SessionDataDAO;
import placementengineauthenticationservice.DAO.UserDAO;
import placementengineauthenticationservice.entity.CredentialPayload;
import placementengineauthenticationservice.entity.SessionData;
import placementengineauthenticationservice.entity.Tokens;
import placementengineauthenticationservice.entity.User;
import placementengineauthenticationservice.utils.JwtConstant;
import placementengineauthenticationservice.utils.JwtUtils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthenticationService {
@Autowired
    SessionDataDAO sessionDataDAO;
@Autowired
    UserDAO userDAO;
    public Tokens authenticationService(CredentialPayload cp){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
 //       Map<String, String> requestBody = new HashMap<>();
 //       requestBody.put("username",cp.getUsername());
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(null, headers);
        RestTemplate psw = new RestTemplate();
        ResponseEntity<String> getpwd=  psw.postForEntity("http://localhost:8081/register/user/getpassword?username="+cp.getUsername(),requestEntity,String.class);
        String dbPassword=getpwd.getBody();
        if(dbPassword.equals(cp.getPassword())){
            return doGenerateToken(cp);
        }
        return null;
    }

    private Tokens doGenerateToken(CredentialPayload cp){
        Tokens token = JwtUtils.generateToken(cp);
        SessionData sessiondata = new SessionData();
        sessiondata.setAccessToken(token.getAccess_token());
        sessiondata.setTokenType(token.getToken_type());
        sessiondata.setLoginCount(1);
        sessiondata.setCreatedOn(LocalDateTime.now());
        SessionData sd = sessionDataDAO.findByLoginId(cp.getUsername());
        if(sd != null){
            sessionDataDAO.delete(sd);
        }
        sessionDataDAO.save(sessiondata);
        return token;

    }
    public SessionData findByToken(String token){
        return sessionDataDAO.findByToken(token);
    }

    public User  findUserByUserName(String username){
        return userDAO.findUserByUsername(username);

    }

}
