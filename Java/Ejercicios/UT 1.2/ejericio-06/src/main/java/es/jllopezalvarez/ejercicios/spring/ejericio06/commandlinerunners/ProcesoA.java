package es.jllopezalvarez.ejercicios.spring.ejericio06.commandlinerunners;

import es.jllopezalvarez.ejercicios.spring.ejericio06.services.MessageService;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(100)
public class ProcesoA implements CommandLineRunner {


    private final MessageService messageService;
    private final Faker faker;


    public ProcesoA(MessageService messageService, Faker faker) {
        this.messageService = messageService;
        this.faker = faker;
    }

    @Override
    public void run(String[] args) throws Exception {
        messageService.showMessage(faker.backToTheFuture().quote());
    }
}
