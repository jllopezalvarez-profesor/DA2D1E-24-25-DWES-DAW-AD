package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.exceptions;

public class TaskAssignmentAlreadyCompletedException extends RuntimeException {
    public TaskAssignmentAlreadyCompletedException() {
    }

    public TaskAssignmentAlreadyCompletedException(String message) {
        super(message);
    }

    public TaskAssignmentAlreadyCompletedException(String message, Throwable cause) {
        super(message, cause);
    }

    public TaskAssignmentAlreadyCompletedException(Throwable cause) {
        super(cause);
    }

    public TaskAssignmentAlreadyCompletedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
