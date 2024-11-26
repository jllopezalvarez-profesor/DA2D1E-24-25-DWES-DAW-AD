package es.jllopezalvarez.ejercicios.spring.ejericio06.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejericio06.services.MessageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProcesoD implements CommandLineRunner {

    private final MessageService messageService;

    public ProcesoD(MessageService messageService) {
        this.messageService = messageService;
    }


    @Override
    public void run(String... args) throws Exception {
        messageService.showMessage("Hola");
    }
}
