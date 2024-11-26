package es.jllopezalvarez.ejercicios.spring.ejericio06.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejericio06.services.MessageService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ProcesoC implements CommandLineRunner, Ordered {
    private final MessageService messageService;

    public ProcesoC(@Qualifier("pepe") MessageService messageService) {
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
