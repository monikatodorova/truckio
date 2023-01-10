package project.truckio.model.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username){
        super(String.format("Корисник со корисничко име %s веќе постои.", username));
    }
}
