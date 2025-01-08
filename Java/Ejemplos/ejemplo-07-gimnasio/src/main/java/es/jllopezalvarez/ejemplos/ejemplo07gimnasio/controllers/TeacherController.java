package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.controllers;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.Teacher;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.TeacherService;
import jakarta.transaction.Transactional;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {


    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Transactional
    @GetMapping({"", "/"})
    public ModelAndView index() {
        List<Teacher> teachers = this.teacherService.findAll();

        System.out.println("Esto está despues de traer los profesores y antes de ejecutar la plantilla");


        if (AopUtils.isAopProxy(teacherService) || AopUtils.isCglibProxy(teacherService) || AopUtils.isJdkDynamicProxy(teacherService)) {
            System.out.println("Es un proxy");
        } else {
            System.out.println("No es un proxy");
        }
        System.out.println(teacherService.getClass().getName());
        System.out.println(AopUtils.getTargetClass(teacherService));
        return new ModelAndView("teachers/lists", "teachers", teachers);
    }

    @GetMapping("/{letra}")
    public ModelAndView show(@PathVariable String letra) {
        List<Teacher> teachers = this.teacherService.findByInitial(letra);

        return new ModelAndView("teachers/lists", "teachers", teachers);

    }

}
