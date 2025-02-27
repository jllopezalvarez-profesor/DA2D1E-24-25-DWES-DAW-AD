package es.jllopezalvarez.ejemplos.springbootbasics.controllers.forms;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.DateAndTimeFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.MultipleOptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.OptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.SimpleFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.services.DataGeneratorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/forms")
public class FormsController {

    private final DataGeneratorService dataGeneratorService;

    public FormsController(DataGeneratorService dataGeneratorService) {
        this.dataGeneratorService = dataGeneratorService;
    }


    // Get de formulario que usa name="" y value="" en lugar de th:object,
    @GetMapping("/basic")
    public String basicForm() {
        return "forms/basic";
    }

    // Post de formulario que usa name="" y value="" en lugar de th:object,
    @PostMapping("/basic")
    public String basicForm(@RequestParam(name = "dni") String documentNumber,
                            @RequestParam(name = "firstName") String userFirstName,
                            @RequestParam(name = "lastName") String userLastName, Model model) {
        System.out.printf("Datos recibidos: %s - %s %s\n", documentNumber, userFirstName, userLastName);

        // @ModelAttribute no funciona cuando se usa junto a @RequestParam.
        // Esto no funcionaría en el parámetro: @ModelAttribute("dni") @RequestParam(name = "dni") String documentNumber
        // @ModelAttribute no vuelve a añadir el parámetro al modelo.
        // Por eso se añaden manualmente de nuevo al modelo.
        model.addAttribute("dni", documentNumber);
        model.addAttribute("firstName", userFirstName);
        model.addAttribute("lastName", userLastName);
        return "forms/basic";
    }

    // Get de formulario básico, con campos de texto
    @GetMapping("/simple")
    public String simpleFormGet(Model model) {
        // Se añade al modelo un objeto vacío para que el formulario aparezca en blanco,
        // y la vista no falle en los th:object y th:field
        model.addAttribute("person", new SimpleFormDto());
        return "forms/simple";
    }

    // Get de formulario básico, con campos de texto, con valores iniciales
    @GetMapping("/simple/con-datos")
    public String simpleConDatosFormGet(Model model) {
        // Se añade al modelo un objeto que ya tiene datos, para que el formulario aparezca con datos iniciales.
        model.addAttribute("person", dataGeneratorService.createFakeSimpleFormDto());
        return "forms/simple";
    }

    // Post de formulario básico, con campos de texto.
    // Procesa dos formularios: sin datos iniciales y con datos iniciales.
    @PostMapping({"/simple", "/simple/con-datos"})
    public String simpleFormPost(@ModelAttribute("person") SimpleFormDto simpleFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/simple");
        System.out.println("Datos recibidos:");
        System.out.println(simpleFormDto);
        // Si se usa correctamente @ModelAttribute, no hace falta volver a añadir el objeto al modelo. Hay que ser
        // cuidadosos con los nombres en la declaración de parámetros o en @ModelAttribute, porque si hay
        // discrepancias el objeto se añade al modelo con otro nombre y la vista no funcionará correctamente
        // model.addAttribute("person", simpleFormDto);
        return "forms/simple";
    }

    // Get de formulario con campos de texto y campo select
    @GetMapping("/select")
    public String selectFormGet(Model model) {
        // Este elemento del modelo, la lista de edades, se podría añadir con un método del controlador
        // anotado con @ModelAttribute. Entonces "ageRanges" estaría disponible siempre, en todas las vistas.
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges()); // Lista de opciones para select
        // Se añade al modelo un objeto vacío para que el formulario aparezca en blanco
        model.addAttribute("person", new OptionFormDto());
        return "forms/select";
    }

    // Get de formulario con campos de texto y campo select y valores iniciales
    @GetMapping("/select/con-datos")
    public String selectConDatosFormGet(Model model) {
        // Este elemento del modelo, la lista de edades, se podría añadir con un método del controlador
        // anotado con @ModelAttribute. Entonces "ageRanges" estaría disponible siempre, en todas las vistas.
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges()); // Lista de opciones para select
        // Se añade al modelo un objeto con datos para que el formulario aparezca con valores iniciales.
        model.addAttribute("person", dataGeneratorService.createFakeOptionFormDto());
        return "forms/select";
    }

    // Post de formulario con campos de texto y campo select y valores iniciales
    // Procesa dos formularios: sin datos iniciales y con datos iniciales.
    @PostMapping({"/select", "/select/con-datos"})
    public String selectFormPost(@ModelAttribute("person") OptionFormDto optionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/select");
        System.out.println("Datos recibidos:");
        System.out.println(optionFormDto);
        // Se añade siempre para que esté disponible para "montar" el select
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges());
        // Si se usa correctamente @ModelAttribute, no hace falta volver a añadir el objeto al modelo. Hay que ser
        // cuidadosos con los nombres en la declaración de parámetros o en @ModelAttribute, porque si hay
        // discrepancias el objeto se añade al modelo con otro nombre y la vista no funcionará correctamente
        // model.addAttribute("person", optionFormDto);
        return "forms/select";
    }

    @GetMapping("/radio")
    public String radioFormGet(Model model) {
        // Se añade siempre para que esté disponible para "montar" la lista de radio buttons
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges());
        // Se añade al modelo un objeto vacío para que el formulario aparezca en blanco.
        model.addAttribute("person", new OptionFormDto());
        return "forms/radio";
    }

    @GetMapping("/radio/con-datos")
    public String radioConDatosFormGet(Model model) {
        // Se añade siempre para que esté disponible para "montar" la lista de radio buttons
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges());
        // Se añade al modelo un objeto con datos para que el formulario aparezca con valores inicales.
        model.addAttribute("person", dataGeneratorService.createFakeOptionFormDto());
        return "forms/radio";
    }

    @PostMapping({"/radio", "/radio/con-datos"})
    public String radioFormPost(@ModelAttribute("person") OptionFormDto optionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/radio");
        System.out.println("Datos recibidos:");
        System.out.println(optionFormDto);
        // Se añade siempre para que esté disponible para "montar" la lista de radio buttons
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("ageRanges", dataGeneratorService.getAllAgeRanges());
        // Si se usa correctamente @ModelAttribute, no hace falta volver a añadir el objeto al modelo. Hay que ser
        // cuidadosos con los nombres en la declaración de parámetros o en @ModelAttribute, porque si hay
        // discrepancias el objeto se añade al modelo con otro nombre y la vista no funcionará correctamente
        // model.addAttribute("person", optionFormDto);
        return "forms/radio";
    }

    // Post de formulario con campos de texto y conjunto de checkboxes
    @GetMapping("/checkbox")
    public String checkboxFormGet(Model model) {
        // Se añade siempre para que esté disponible para "montar" la lista de checkboxes
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("hobbies", dataGeneratorService.getAllHobbies());
        // Se añade al modelo un objeto vacío para que el formulario aparezca en blanco.
        model.addAttribute("person", new MultipleOptionFormDto());
        return "forms/checkbox";
    }

    // Post de formulario con campos de texto y conjunto de checkboxes, con datos iniciales
    @GetMapping("/checkbox/con-datos")
    public String checkboxConDatosFormGet(Model model) {
        // Se añade siempre para que esté disponible para "montar" la lista de checkboxes
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("hobbies", dataGeneratorService.getAllHobbies());
        // Se añade al modelo un objeto con datos para que el formulario aparezca con valores iniciales.
        model.addAttribute("person", dataGeneratorService.createFakeMultipleOptionFormDto());
        return "forms/checkbox";
    }

    // Post de formulario con campos de texto y conjunto de checkboxes
    // Procesa dos formularios: sin datos iniciales y con datos iniciales.
    @PostMapping({"/checkbox", "/checkbox/con-datos"})
    public String checkboxFormPost(@ModelAttribute("person") MultipleOptionFormDto multipleOptionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/checkbox");
        System.out.println("Datos recibidos:");
        System.out.println(multipleOptionFormDto);
        // Se añade siempre para que esté disponible para "montar" la lista de checkboxes
        // Podría hacerse con @ModelAttribute en un método
        model.addAttribute("hobbies", dataGeneratorService.getAllHobbies());
        // Si se usa correctamente @ModelAttribute, no hace falta volver a añadir el objeto al modelo. Hay que ser
        // cuidadosos con los nombres en la declaración de parámetros o en @ModelAttribute, porque si hay
        // discrepancias el objeto se añade al modelo con otro nombre y la vista no funcionará correctamente
        // model.addAttribute("person", multipleOptionFormDto);
        return "forms/checkbox";
    }

    // Get de formulario básico, con campos de texto y de fecha y hora.
    @GetMapping("/date-time")
    public String dateTimeFormGet(Model model) {
        // Se añade al modelo un objeto vacío para que el formulario aparezca en blanco
        model.addAttribute("person", new DateAndTimeFormDto());
        return "forms/date-form";
    }

    // Get de formulario básico, con campos de texto y de fecha y hora, con datos iniciales
    @GetMapping("/date-time/con-datos")
    public String dateTimeConDatosFormGet(Model model) {
        // Lo generado con DataGeneratorService normalmente se obtendría en llamadas a servicios
        // Se añade al modelo un objeto que ya tiene datos, para que el formulario aparezca con datos iniciales.
        model.addAttribute("person", dataGeneratorService.createFakeDateAndTimeFormDto());
        return "forms/date-form";
    }

    // Post de formulario básico, con campos de texto y de fecha y hora.
    // Procesa dos formularios: sin datos iniciales y con datos iniciales.
    @PostMapping({"/date-time", "/date-time/con-datos"})
    public String dateTimeFormPost(@ModelAttribute("person") DateAndTimeFormDto dateAndTimeFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/date-time");
        System.out.println("Datos recibidos:");
        System.out.println(dateAndTimeFormDto);
        // Si se usa correctamente @ModelAttribute, no hace falta volver a añadir el objeto al modelo. Hay que ser
        // cuidadosos con los nombres en la declaración de parámetros o en @ModelAttribute, porque si hay
        // discrepancias el objeto se añade al modelo con otro nombre y la vista no funcionará correctamente
        // model.addAttribute("person", dateAndTimeFormDto);
        return "forms/date-form";
    }
}
