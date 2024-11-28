package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.controllers;


import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.entities.Event;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.generic.EventRepository;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.notgeneric.NotGenericEventRepository;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base.Repository;
import es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.repositories.base.RepositoryImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/event")
public class EventController {


    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Mapping que solo admite GET
    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping({"", "/"})
    public ModelAndView getAllEvents() {

        Collection<Event> events =  eventRepository.findAll();



//        List<Event> events = new ArrayList<>();
//        events.add(new Event(1, "Evento 1", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
//        events.add(new Event(2, "Evento 2", "Descripción evento 2", LocalDateTime.now(), LocalDateTime.now()));
//        events.add(new Event(3, "Evento 3", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
        ModelAndView modelAndView = new ModelAndView("event-list", "events", events);
        modelAndView.addObject("usuario", "José Luis López Álvarez");

        // Forma alternativa de construir el modelo
//        ModelAndView modeloAlternativo = new ModelAndView();
//        modeloAlternativo.addObject("events", events);
//        modeloAlternativo.addObject("usuario", "José Luis López");
//        modeloAlternativo.setViewName("event-list");

        return modelAndView;
    }

    @GetMapping("/{id}")
    public String getEventDetails(@ModelAttribute(name = "eventId") @PathVariable(name = "id") long eventId, Model model) {
        System.out.println("Id recibido: " + eventId);

        Optional<Event> event = eventRepository.findById(eventId);



        if (event.isPresent()) {
            model.addAttribute("event", event.orElseThrow())
                    .addAttribute("otraCoas", "Esto es otra cosa");
            return "event-details";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/new")
    public String getCreateForm(HttpServletRequest httpServletRequest) {
        return "new-event";
    }

    @PostMapping("/new")
    public String createEvent() {
        return "event-created";
    }


    private void pruebas(){


    }


//
//    @RequestMapping("")
//    public String doSomething(){
//        System.out.println("Estoy en el controlador");
//        return "Hola";
//
//    }

    @ModelAttribute(name = "languages")
    private Iterable<String> getLanguages() {
        List<String> languages = new ArrayList<>();
        languages.add("es");
        languages.add("fr");
        languages.add("de");
        languages.add("it");
        return languages;
    }

}
