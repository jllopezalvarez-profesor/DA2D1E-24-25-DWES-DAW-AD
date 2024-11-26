package es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services;

import org.springframework.stereotype.Component;

@Component
public class SystemOutMessageService implements MessageService {
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
