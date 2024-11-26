package es.jllopezalvarez.ejercicios.spring.ejericio06.services;

import org.springframework.stereotype.Component;

@Component("pepe")
public class SystemErrorMessageService implements MessageService {

    private final SystemOutMessageService systemOutMessageService;

    public SystemErrorMessageService(SystemOutMessageService systemOutMessageService) {
        this.systemOutMessageService = systemOutMessageService;
    }

    @Override
        public void showMessage(String message) {
        System.err.println(message);

    }
}
