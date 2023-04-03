package ibf2022.tfip.paf.day21workshopJDBCTemplateQuery.exception;

public class CustomerException extends RuntimeException{

    public CustomerException() {
        super();
    }
    public CustomerException(String message) {
        super(message);
    }
    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
    
}