package placementenginejobposting.Utility;

public enum Review_status {
    INITIATE("initiate"),
    UNDER_PROCESS("under_process"),
    REJECT("reject");

    String status;

     Review_status(String status){
        this.status= status;
    }
}
