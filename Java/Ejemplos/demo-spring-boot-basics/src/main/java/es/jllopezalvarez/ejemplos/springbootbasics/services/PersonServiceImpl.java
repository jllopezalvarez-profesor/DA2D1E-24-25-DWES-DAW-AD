package es.jllopezalvarez.ejemplos.springbootbasics.services;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.validation.NewPersonFormDto;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public void create(NewPersonFormDto dto) {
        if (dto.getFirstName() == null || dto.getFirstName().isBlank()) {
            throw new IllegalArgumentException("First name cannot be blank");
        }
        if (dto.getLastName() == null || dto.getLastName().isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank");
        }
        if (dto.getBirthDate() == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if (dto.getPhone() == null || dto.getPhone().isBlank()) {
            throw new IllegalArgumentException("Phone cannot be blank");
        }
        System.out.printf("Se ha creado la persona con los datos: \n%s\n", dto);
    }
}
