package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.commandlinerunners;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories.SportClassRepository;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.SportClassService;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TestCommandLineRunner implements CommandLineRunner {


    private final SportClassService sportClassService;

    public TestCommandLineRunner( SportClassService sportClassService) {
        this.sportClassService = sportClassService;
    }

    @Override
//    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("En el command line runner de pruebas");

        System.out.printf("La clase que implementa el repositorio es: %s%n", sportClassService.getClass().getName());
        System.out.printf("La clase que implementa el repositorio es: %s%n", AopUtils.getTargetClass(sportClassService));



        SportClass sportClass = sportClassService.findById(1L).orElseThrow(() ->
                new RuntimeException("No se encontró el id de prueba"));

        System.out.printf("La clase buscada es: %s%n", sportClass.getName());

        List<Teacher> teachers = sportClass.getTeachers();

        System.out.println("Los profesores de la clase son:");

        teachers.forEach(teacher -> System.out.println(teacher.getFirstName() + " " + teacher.getLastName()));

        System.out.println("Clases que contienen la letra p en orden inverso:");
        // Obtener las clases que contienen cierta letra, ordenados por nombre de clase, descendente
        //List<SportClass> foundClasses = sportClassService.findByLetterOrderedByNameDesc("p");
//        List<SportClass> foundClasses = sportClassService.findByLetterOrderedByNameDescOptimized("p");
        List<SportClass> foundClasses = sportClassService.findByLetterOrderedByNameDescOptimized("advanced pilates");
        // Mostrar las clases
        foundClasses.forEach(sc -> System.out.println(sc.getName()));

    }
}
