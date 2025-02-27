package es.jllopezalvarez.ejemplos.springbootbasics.services;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.DateAndTimeFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.MultipleOptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.OptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.SimpleFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.AgeRange;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.Hobby;

import java.util.List;

public interface DataGeneratorService {
    List<AgeRange> getAllAgeRanges();

    Integer getRandomAgeRangeId();

    List<Hobby> getAllHobbies();

    Integer getRandomHobbyId();

    List<Integer> getRandomHobbyIds();

    SimpleFormDto createFakeSimpleFormDto();

    OptionFormDto createFakeOptionFormDto();

    MultipleOptionFormDto createFakeMultipleOptionFormDto();

    DateAndTimeFormDto createFakeDateAndTimeFormDto();
}
