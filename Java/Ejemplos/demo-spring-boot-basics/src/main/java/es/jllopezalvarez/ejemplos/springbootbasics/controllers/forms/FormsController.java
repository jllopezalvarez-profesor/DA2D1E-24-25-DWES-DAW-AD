package es.jllopezalvarez.ejemplos.springbootbasics.controllers.forms;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.MultipleOptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.OptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.SimpleFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.utils.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forms")
public class FormsController {

    private final DataGenerator dataGenerator;

    public FormsController(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @GetMapping("/simple")
    public String simpleFormGet(Model model) {
        model.addAttribute("person", new SimpleFormDto());
        return "forms/simple";
    }

    @PostMapping("/simple")
    public String simpleFormPost(@ModelAttribute SimpleFormDto simpleFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/simple");
        System.out.println("Datos recibidos:");
        System.out.println(simpleFormDto);
        model.addAttribute("person", simpleFormDto);
        return "forms/simple";
    }


    @GetMapping("/select")
    public String selectFormGet(Model model) {
        model.addAttribute("ageRanges", dataGenerator.getAllAgeRanges());
        model.addAttribute("person", new OptionFormDto());
        return "forms/select";
    }

    @GetMapping("/select/con-datos")
    public String selectFormConDatosGet(Model model) {
        // Esto normalmente saldría de una llamada a un servicio o similar
        OptionFormDto optionFormDto = new OptionFormDto();
        optionFormDto.setDni("1234567890");
        optionFormDto.setFirstName("John");
        optionFormDto.setLastName("Doe");
        optionFormDto.setAgeRangeId(4);
        model.addAttribute("ageRanges", dataGenerator.getAllAgeRanges());
        model.addAttribute("person", optionFormDto);
        return "forms/select";
    }

    @PostMapping({"/select", "/select/con-datos"})
    public String selectFormPost(@ModelAttribute OptionFormDto optionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/select");
        System.out.println("Datos recibidos:");
        System.out.println(optionFormDto);
        model.addAttribute("ageRanges", dataGenerator.getAllAgeRanges());
        model.addAttribute("person", optionFormDto);
        return "forms/select";
    }

    @GetMapping("/radio")
    public String radioFormGet(Model model) {
        model.addAttribute("ageRanges", dataGenerator.getAllAgeRanges());
        model.addAttribute("person", new OptionFormDto());
        return "forms/radio";
    }

    @PostMapping("/radio")
    public String radioFormPost(@ModelAttribute OptionFormDto optionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/radio");
        System.out.println("Datos recibidos:");
        System.out.println(optionFormDto);
        model.addAttribute("ageRanges", dataGenerator.getAllAgeRanges());
        model.addAttribute("person", optionFormDto);
        return "forms/radio";
    }

    @GetMapping("/checkbox")
    public String checkboxFormGet(Model model) {
        model.addAttribute("hobbies", dataGenerator.getAllHobbies());
        model.addAttribute("person", new MultipleOptionFormDto());
        return "forms/checkbox";
    }

    @PostMapping("/checkbox")
    public String checkboxFormPost(@ModelAttribute MultipleOptionFormDto multipleOptionFormDto, Model model) {
        System.out.println("Recibido post de formulario /forms/checkbox");
        System.out.println("Datos recibidos:");
        System.out.println(multipleOptionFormDto);
        model.addAttribute("hobbies", dataGenerator.getAllHobbies());
        model.addAttribute("person", multipleOptionFormDto);
        return "forms/checkbox";
    }




}
