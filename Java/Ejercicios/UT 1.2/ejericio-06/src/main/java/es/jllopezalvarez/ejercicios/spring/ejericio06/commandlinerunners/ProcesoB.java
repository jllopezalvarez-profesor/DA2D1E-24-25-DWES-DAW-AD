package es.jllopezalvarez.ejercicios.spring.ejericio06.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejericio06.services.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProcesoB implements CommandLineRunner {
    private final MessageService messageService;

    public ProcesoB(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void run(String[] args) throws Exception {
        messageService.showMessage(this.getClass().getCanonicalName());
    }
}
