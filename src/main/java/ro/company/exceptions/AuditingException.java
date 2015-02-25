package ro.company.exceptions;

/**
 * Created by Cristian.Dumitru on 2/18/2015.
 */
public class AuditingException extends Exception {

    public AuditingException() {
        super();
    }

    public AuditingException(String message){
        super(message);
    }
}
