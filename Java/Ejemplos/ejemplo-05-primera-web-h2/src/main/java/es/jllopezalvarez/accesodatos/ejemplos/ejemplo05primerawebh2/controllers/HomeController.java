package es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.controllers;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Course;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.entities.Student;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services.CourseService;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo05primerawebh2.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final StudentService studentService;
    private final CourseService courseService;

    public HomeController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping({"", "/"})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Student> students = studentService.findAll();
        Course course = courseService.findById(1L).orElseThrow();

        modelAndView.addObject("message", "Hello World!");
        modelAndView.addObject("students", students);
        modelAndView.addObject("course", course);
        return modelAndView;
    }

}
