package es.jllopezalvarez.ejemplos.ejemplo01primerawebspring.controllers;


import es.jllopezalvarez.ejemplos.ejemplo01primerawebspring.model.Event;
import es.jllopezalvarez.ejemplos.ejemplo01primerawebspring.repositories.base.Repository;
import es.jllopezalvarez.ejemplos.ejemplo01primerawebspring.repositories.base.RepositoryImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {

    // Mapping que solo admite GET
    //@RequestMapping(value = "", method = RequestMethod.GET)
    @GetMapping({"", "/"})
    public ModelAndView getAllEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(1, "Evento 1", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
        events.add(new Event(2, "Evento 2", "Descripción evento 2", LocalDateTime.now(), LocalDateTime.now()));
        events.add(new Event(3, "Evento 3", "Descripción evento 1", LocalDateTime.now(), LocalDateTime.now()));
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
    public String getEventDetails(@ModelAttribute(name = "eventId") @PathVariable(name = "id") int eventId, Model model) {
        System.out.println("Id recibido: " + eventId);

        Event event = new Event(1, "Comida con los amigos de Alcocebre", "Nos vamos a la plaza mayor a comer bocadillo de calamares", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(5));
        //Event event = new Event(1, "Comida con los amigos de Alcocebre", "Nos vamos a la plaza mayor a comer bocadillo de calamares", LocalDateTime.now().plusDays(2), null);

//        model.addAttribute("eventId", eventId)
        model.addAttribute("event", event)
                .addAttribute("otraCoas", "Esto es otra cosa");

        return "event-details";
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
        Repository<Event, Integer> repo = new RepositoryImpl<>();

        Event e = repo.findById(4);

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
