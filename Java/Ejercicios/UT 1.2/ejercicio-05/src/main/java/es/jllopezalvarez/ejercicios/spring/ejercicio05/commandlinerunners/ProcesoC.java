package es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejercicio05.commandlinerunners.services.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ProcesoC implements CommandLineRunner, Ordered {
    private final MessageService messageService;

    public ProcesoC(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(String[] args) throws Exception {
        messageService.showMessage(this.getClass().getCanonicalName());
    }

    @Override
    public int getOrder() {
        return 200;
    }
}
