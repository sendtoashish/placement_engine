package placementengineauthenticationservice.utils;

public enum JwtConstant {
    JWT("jwt");
    String token_type ;
    JwtConstant(String token){

        this.token_type = token;
    }


}
