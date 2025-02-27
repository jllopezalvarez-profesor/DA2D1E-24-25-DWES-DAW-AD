package es.jllopezalvarez.ejemplos.springbootbasics.services;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.validation.NewPersonFormDto;

public interface PersonService {
    void create(NewPersonFormDto dto);
}
