package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    ModelAndView handleAlreadyExistsException(AlreadyExistsException e) {
        return new ModelAndView("admin/error", "message", e.getMessage());
    }
}
