package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.controllers;

import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.Author;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities.Book;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories.AuthorRepository;
import es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class TestController {


    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public TestController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping("/test-book")
    public ModelAndView testBook(){
        ModelAndView modelAndView = new ModelAndView("test-book", "books", bookRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/add-author-to-book/{bookId}/{authorId}")
    public String addAuthorToBook(@PathVariable Long bookId, @PathVariable Long authorId){
        Book book = bookRepository.findById(bookId).orElseThrow();
        Author author = authorRepository.findById(authorId).orElseThrow();

        book.getAuthors().add(author);

        bookRepository.save(book);

        return "test-book";


    }
    @GetMapping("/add-book-to-author/{authorId}/{bookId}")
    public String addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow();
        Author author = authorRepository.findById(authorId).orElseThrow();

        author.getBooks().add(book);

        authorRepository.save(author);

        return "test-book";

    }

}
