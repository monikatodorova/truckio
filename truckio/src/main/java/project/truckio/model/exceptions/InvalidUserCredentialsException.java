package project.truckio.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {
    public InvalidUserCredentialsException() {
        super("Невалидни креденцијали.");
    }
}
