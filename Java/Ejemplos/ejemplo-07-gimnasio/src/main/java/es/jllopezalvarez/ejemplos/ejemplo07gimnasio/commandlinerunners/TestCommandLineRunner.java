package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.commandlinerunners;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.repositories.SportClassRepository;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.MemberService;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.SportClassService;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.TeacherService;
import org.springframework.aop.support.AopUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@Component
public class TestCommandLineRunner implements CommandLineRunner {


    private final SportClassService sportClassService;
    private final TeacherService teacherService;
    private final MemberService memberService;

    public TestCommandLineRunner(SportClassService sportClassService, TeacherService teacherService, MemberService memberService) {
        this.sportClassService = sportClassService;
        this.teacherService = teacherService;
        this.memberService = memberService;
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

        System.out.println("Probando la consulta nativa para el profesor con id 1 (SQL)");
        System.out.println( teacherService.countStudentsByTeacherId(1L) );

        System.out.println("Probando la consulta nativa para el profesor con id 1 (JPQL)");
        System.out.println( teacherService.countStudentsByTeacherIdJpql(1L) );

        System.out.println("Buscando la edad media de los mayores de 0 años");
        Optional<Double> edadMedia = memberService.getAvgAgeForOlderThan(0);
        if (edadMedia.isPresent()) {
            System.out.println("La edad media es " + edadMedia.orElseThrow());
        } else {
            System.out.println("La edad media no se ha encontrada");
        }



        System.out.println("Buscando la edad media de los mayores de 00 años");
        edadMedia = memberService.getAvgAgeForOlderThan(60);
        if (edadMedia.isPresent()) {
            System.out.println("La edad media es " + edadMedia.orElseThrow());
        } else {
            System.out.println("La edad media no se ha encontrada");
        }
    }
}
