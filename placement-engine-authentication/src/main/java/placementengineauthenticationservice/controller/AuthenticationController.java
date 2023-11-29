package placementengineauthenticationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import placementengineauthenticationservice.Service.AuthenticationService;
import placementengineauthenticationservice.entity.CredentialPayload;
@RestController
@RequestMapping(value="/Authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping(value="/auth")
    public void authUser(@RequestBody CredentialPayload cp){
        authenticationService.authenticationService(cp);
    }

}
