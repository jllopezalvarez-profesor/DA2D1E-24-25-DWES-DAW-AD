package es.jllopezalvarez.ejemplos.springbootbasics.controllers.forms;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.fileupload.MultipleFileUploadDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.fileupload.SingleFileUploadDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/forms/file-upload")
public class FileUploadController {

    @GetMapping("/simple-single")
    public String simpleFileUpload() {
        return "forms/file-upload/simple-file-upload";
    }


    @PostMapping("/simple-single")
    public String simpleFileUploadPost(@RequestParam("firstName") String firstName,
                                       @RequestParam("lastName") String lastName,
                                       @RequestParam("userPhoto") MultipartFile userPhoto,
                                       Model model) {

        // Comprobar si el fichero está vacío
        if (userPhoto.isEmpty()) {
            model.addAttribute("errorMessage", "No has seleccionado un fichero o el fichero está vacío");
        } else {
            // Comprobar el tipo de contenido
            if (userPhoto.getContentType() != null && !userPhoto.getContentType().equalsIgnoreCase("image/png")) {
                model.addAttribute("errorMessage", "La imagen no es de tipo image/png");
            } else {
                // Aquí iría el código pra guardar el fichero.
                model.addAttribute("successMessage",
                        String.format("Se han recibido los datos correctamente. El tamaño del fichero es de %d bytes", userPhoto.getSize()));
            }
        }

        // Añadir parámetros al modelo para que estén disponibles (@ModelAttribute no funciona con @RequestParam)
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "forms/file-upload/simple-file-upload";
    }

    @GetMapping("/simple-multiple")
    public String simpleMultipleFileUpload() {
        return "forms/file-upload/simple-multiple-file-upload";
    }

    @PostMapping("/simple-multiple")
    public String simpleMultipleFileUploadPost(@RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName,
                                               // userPhotos podría ser MultipartFile[], en lugar de lista
                                               @RequestParam("userPhotos") List<MultipartFile> userPhotos,
                                               Model model) {
        // Procesar ficheros.
        processMultipleFilesWithModel(userPhotos, model);

        // Añadir parámetros al modelo para que estén disponibles (@ModelAttribute no funciona con @RequestParam)
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "forms/file-upload/simple-multiple-file-upload";
    }


    @GetMapping("/simple-multiple-attribute")
    public String simpleMultipleAttributeFileUpload() {
        return "forms/file-upload/simple-multiple-attribute-file-upload";
    }

    @PostMapping("/simple-multiple-attribute")
    public String simpleMultipleAttributeFileUploadPost(@RequestParam("firstName") String firstName,
                                                        @RequestParam("lastName") String lastName,
                                                        // userPhotos podría ser MultipartFile[], en lugar de lista
                                                        @RequestParam("userPhotos") List<MultipartFile> userPhotos,
                                                        Model model) {
        // Procesar ficheros.
        processMultipleFilesWithModel(userPhotos, model);

        // Añadir parámetros al modelo para que estén disponibles (@ModelAttribute no funciona con @RequestParam)
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);

        return "forms/file-upload/simple-multiple-attribute-file-upload";
    }


    @GetMapping("/dto-single")
    public String dtoFileUpload(Model model) {
        model.addAttribute("userData", SingleFileUploadDto.builder().build());
        return "forms/file-upload/dto-single-file-upload";
    }


//    @PostMapping("/dto-single")
//    public String dtoFileUploadPost(@Valid @ModelAttribute("userData") SingleFileUploadDto userData,
//                                    BindingResult result,
//                                    Model model) {
//        // Primero, comprobar si se ha pasado la validación de BindingResults
////        if (!result.hasErrors()) {
//        // Comprobación manual de qué ha pasado con el fichero
//        if (userData.getPhoto().isEmpty()) {
//            // Fichero no subido o vacío
//            result.rejectValue("photo", null, "No has seleccionado un fichero o el fichero está vacío");
//        } else if (userData.getPhoto().getContentType() != null && !userData.getPhoto().getContentType().equalsIgnoreCase("image/png")) {
//            // No es del tipo de contenido adecuado
//            result.rejectValue("photo", null, "La imagen no es de tipo image/png");
//        } else {
//            model.addAttribute("successMessage",
//                    String.format("Se han recibido los datos correctamente. El tamaño del fichero es de %d bytes", userData.getPhoto().getSize()));
//        }

    /// /        }
//
//        // En este caso no hace falta añadir de nuevo nada al modelo, porque está anotado con @ModelAttribute
//
//        return "forms/file-upload/dto-single-file-upload";
//    }
    @PostMapping("/dto-single")
    public String dtoFileUploadPostWithJakartaValidation(@Valid @ModelAttribute("userData") SingleFileUploadDto userData,
                                                         BindingResult result,

                                                         Model model) {
        if (!result.hasErrors()) {
            model.addAttribute("successMessage",
                    String.format("Se han recibido los datos correctamente. El tamaño del fichero es de %d bytes", userData.getPhoto().getSize()));
        }
        return "forms/file-upload/dto-single-file-upload";
    }

    @GetMapping("/dto-multiple-attribute")
    public String dtoMultipleFileUpload(Model model) {
        model.addAttribute("userData", MultipleFileUploadDto.builder().build());
        return "forms/file-upload/dto-multiple-attribute-file-upload";
    }

    @PostMapping("/dto-multiple-attribute")
    public String dtoMultipleFileUploadPost(@Valid @ModelAttribute("userData") MultipleFileUploadDto userData, BindingResult result, Model model) {

        // Comprobar si ha habido errores en validación automática.
//        if (!result.hasErrors()) {
        processMultipleFilesWithBindingResults(userData.getPhotos(), result, model);
//        }

        // En este caso no hace falta añadir de nuevo nada al modelo, porque está anotado con @ModelAttribute
        return "forms/file-upload/dto-multiple-attribute-file-upload";
    }


    // Procesa múltiples ficheros recibidos, pero cuando no se usa DTO.
    // Se usa desde varios de los métodos de controlador que procesan múltiples ficheros, sin DTO.
    private void processMultipleFilesWithModel(List<MultipartFile> userPhotos, Model model) {
        // Comprobar si el fichero está vacío
        if (userPhotos.isEmpty()) {
            // No hay archivos. Esto normalmente no se cumple, porque aunque se deje el campo vacío,
            // se recibe el objeto MultipartFile. Estaría vacía si no hubiera campos file con el nombre
            // "userPhotos".
            model.addAttribute("errorMessage", "No se ha subido ningún fichero (lista vacía)");
        } else if (userPhotos.stream().allMatch(MultipartFile::isEmpty)) {
            // Esto sí pasaría, si se dejan los campos en blanco.
            model.addAttribute("errorMessage", "No se ha subido ningún fichero (todos vacíos)");
        } else if (userPhotos.stream()
                .filter(multipartFile -> !multipartFile.isEmpty())
                .anyMatch(multipartFile -> !multipartFile.getContentType().equalsIgnoreCase("image/png"))) {
            model.addAttribute("errorMessage", "Alguno de los ficheros subidos no es de tipo image/png");
        } else {
            String fileNamesAndSizes = userPhotos.stream()
                    .filter(multipartFile -> !multipartFile.isEmpty())
                    .map(multipartFile -> String.format("%s (%d bytes)", multipartFile.getOriginalFilename(), multipartFile.getSize()))
                    .collect(Collectors.joining(", "));
            model.addAttribute("successMessage", String.format("Se han recibido los datos correctamente. Ficheros: %s", fileNamesAndSizes));
        }
    }

    // Procesa múltiples ficheros recibidos, cuando sí se usa DTO / BindingResults.
    // Se usa desde varios de los métodos de controlador que procesan múltiples ficheros, con DTO 7  BindingResults.
    private void processMultipleFilesWithBindingResults(List<MultipartFile> userPhotos, BindingResult result, Model model) {
        // Comprobar si el fichero está vacío
        if (userPhotos.isEmpty()) {
            // No hay archivos. Esto normalmente no se cumple, porque aunque se deje el campo vacío,
            // se recibe el objeto MultipartFile. Estaría vacía si no hubiera campos file con el nombre
            // "userPhotos".
            result.rejectValue("photos", null, "No se ha subido ningún fichero (lista vacía)");
        } else if (userPhotos.stream().allMatch(MultipartFile::isEmpty)) {
            // Esto sí pasaría, si se dejan los campos en blanco.
            result.rejectValue("photos", null, "No se ha subido ningún fichero (todos vacíos)");
        } else if (userPhotos.stream()
                .filter(multipartFile -> !multipartFile.isEmpty())
                .anyMatch(multipartFile -> !multipartFile.getContentType().equalsIgnoreCase("image/png"))) {
            result.rejectValue("photos", null, "Alguno de los ficheros subidos no es de tipo image/png");
        } else {
            String fileNamesAndSizes = userPhotos.stream()
                    .filter(multipartFile -> !multipartFile.isEmpty())
                    .map(multipartFile -> String.format("%s (%d bytes)", multipartFile.getOriginalFilename(), multipartFile.getSize()))
                    .collect(Collectors.joining(", "));
            model.addAttribute("successMessage", String.format("Se han recibido los datos correctamente. Ficheros: %s", fileNamesAndSizes));
        }
    }

}

