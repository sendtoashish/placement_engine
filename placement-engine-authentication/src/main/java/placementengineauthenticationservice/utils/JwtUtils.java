package placementengineauthenticationservice.utils;

import ch.qos.logback.core.subst.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import placementengineauthenticationservice.entity.CredentialPayload;
import placementengineauthenticationservice.entity.Tokens;
import placementengineauthenticationservice.exception.ApplicationException;
import placementengineauthenticationservice.exception.ErrorStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class JwtUtils {
    private static final long JWT_TOKEN_VALIDITY = 120;
    private static final String secret = "secret";
      private static String doGenerateToken(String subject){

         return Jwts.builder()
                  .setSubject(subject)
                  .setIssuedAt(new Date(System.currentTimeMillis()))
                  .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY*60*100))
                  .signWith(SignatureAlgorithm.HS256,secret)
                  .compact();
      }

      public static Tokens generateToken(CredentialPayload cp){
             String token = doGenerateToken(cp.getUsername());
             return new Tokens(token);

      }

    public static Claims validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception ex) {
            throw new ApplicationException(ErrorStatus.INVALID_HEADER, "Invalid Authorization header");
        }
    }
    public static String getUserName(Claims claims) {
        String userName = claims.getSubject();
        return userName;
    }
    public static Boolean isTokenExpired(Claims claims) {
        Date expirationDate = claims.getExpiration();
        Date currentDate = new Date();
        return expirationDate.before(currentDate);
    }
}
