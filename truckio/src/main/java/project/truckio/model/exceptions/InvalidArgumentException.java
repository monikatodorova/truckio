package project.truckio.model.exceptions;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
        super("Invalid arguments exception");
    }
}