package placementengineauthenticationservice.exception;

public class ApplicationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

   ErrorStatus errorStatus;
   String message;

   public ApplicationException(ErrorStatus errorStatus,String message){
       this.errorStatus = errorStatus;
       this.message= message;
   }


}
