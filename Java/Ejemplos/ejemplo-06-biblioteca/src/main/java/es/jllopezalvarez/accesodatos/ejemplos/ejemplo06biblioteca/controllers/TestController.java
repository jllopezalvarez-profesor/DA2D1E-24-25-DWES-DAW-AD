package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.controllers;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.Book;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {


    private final BookRepository bookRepository;

    public TestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/test-book")
    public ModelAndView testBook(){
        ModelAndView modelAndView = new ModelAndView("test-book", "books", bookRepository.findAll());
        return modelAndView;
    }

}
