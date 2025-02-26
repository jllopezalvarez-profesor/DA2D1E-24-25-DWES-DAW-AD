package es.jllopezalvarez.ejemplos.springbootbasics.dto.validation;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class NewPersonFormDto {

    @NotBlank(message = "Oye, escribe algo aquí!!!")
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    @Email
    private String email;
    @NotBlank
    private String phone;

}
