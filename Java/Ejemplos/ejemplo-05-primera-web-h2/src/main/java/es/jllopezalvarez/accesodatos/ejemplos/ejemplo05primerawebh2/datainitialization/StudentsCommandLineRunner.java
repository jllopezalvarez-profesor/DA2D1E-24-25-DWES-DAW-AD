package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.datainitialization;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Course;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Student;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services.CourseService;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentsCommandLineRunner implements CommandLineRunner {

    private final StudentService studentService;
    private final CourseService courseService;

    public StudentsCommandLineRunner(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @Override
    public void run(String... args) throws Exception {
        Course newCourse = courseService.save(new Course("DWES", "Desarrollo web en entorno servidor"));


        studentService.save(new Student("1111111A", "José Luis", "López Álvarez", LocalDate.of(1972, 8, 13), newCourse));
        studentService.save(new Student("2222222B", "Elena", "Lamela Azañedo", LocalDate.of(1971, 3, 17), newCourse));

    }
}
