package project.truckio.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException() {
        super("Невалидни корисничко име или лозинка.");
    }
}
