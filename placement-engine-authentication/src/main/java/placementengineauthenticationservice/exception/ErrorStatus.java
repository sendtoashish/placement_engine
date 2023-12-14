package placementengineauthenticationservice.exception;

import org.springframework.http.HttpStatus;

public enum ErrorStatus {

INVALID_HEADER("INVALID_TOKEN", HttpStatus.UNAUTHORIZED);

    String code;
    HttpStatus httpStatus;

    ErrorStatus(String code, HttpStatus httpStatus) {
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
