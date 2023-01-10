package project.truckio.model.exceptions;

public class PasswordsDoNotMatch extends RuntimeException {
    public PasswordsDoNotMatch() {
        super("Лозинките не се совпаѓаат.");
    }
}
