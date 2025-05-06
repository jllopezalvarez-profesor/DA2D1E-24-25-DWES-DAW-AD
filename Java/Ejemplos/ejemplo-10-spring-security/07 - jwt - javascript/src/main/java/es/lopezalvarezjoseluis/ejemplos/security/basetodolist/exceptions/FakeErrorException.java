package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.exceptions;

public class FakeErrorException extends RuntimeException {
    public FakeErrorException() {
    }

    public FakeErrorException(String message) {
        super(message);
    }

    public FakeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public FakeErrorException(Throwable cause) {
        super(cause);
    }
}
