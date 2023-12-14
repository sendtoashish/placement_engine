package placementengineauthenticationservice.controller;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import placementengineauthenticationservice.Service.AuthenticationService;
import placementengineauthenticationservice.entity.CredentialPayload;
import placementengineauthenticationservice.entity.SessionData;
import placementengineauthenticationservice.entity.Tokens;
import placementengineauthenticationservice.entity.User;
import placementengineauthenticationservice.utils.JwtUtils;

@RestController
@RequestMapping(value="/user/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping(value="/auth")
    public ResponseEntity<Tokens> authUser(@RequestBody CredentialPayload cp){
        Tokens token =authenticationService.authenticationService(cp);
        return ResponseEntity.ok().body(token);
    }
    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestBody(required = true) Tokens token) {
        SessionData sessionData = authenticationService.findByToken(token.getAccess_token());
        if (sessionData != null && token != null && token.getAccess_token() != "") {
            try {
                Claims claims = JwtUtils.validateToken(sessionData.getAccessToken());
                User user = authenticationService.findUserByUserName(JwtUtils.getUserName(claims));
                if (user == null || JwtUtils.isTokenExpired(claims)) {
                    return new ResponseEntity<>("{\"result\":\"false\"}", HttpStatus.GATEWAY_TIMEOUT);
                }
            } catch (Exception e) {
                return new ResponseEntity<>("{\"result\":\"false\"}", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("{\"result\":\"false\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("{\"result\":\"true\"}", HttpStatus.OK);
    }


}




