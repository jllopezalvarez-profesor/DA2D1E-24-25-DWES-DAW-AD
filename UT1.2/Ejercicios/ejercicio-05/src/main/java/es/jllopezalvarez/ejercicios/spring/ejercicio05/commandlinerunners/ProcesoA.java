package es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services.MessageService;
import es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services.SystemOutMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class ProcesoA implements CommandLineRunner {


    private final MessageService messageService;

    public ProcesoA(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(String[] args) throws Exception {
        messageService.showMessage(this.getClass().getCanonicalName());
    }
}
