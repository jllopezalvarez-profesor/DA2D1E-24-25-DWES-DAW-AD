package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException {
    public UserNameAlreadyExistsException(String email) {
        super(String.format("Email %s already exists", email));
    }
}
