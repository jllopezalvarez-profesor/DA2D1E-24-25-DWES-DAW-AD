package es.jllopezalvarez.ejemplos.springbootbasics;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.validation.NewPersonFormDto;

public interface PersonService {
    void create(NewPersonFormDto dto);
}
