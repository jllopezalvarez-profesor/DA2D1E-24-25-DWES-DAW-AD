package es.jllopezalvarez.ejemplos.springbootbasics.utils;

import es.jllopezalvarez.ejemplos.springbootbasics.models.common.AgeRange;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.Hobby;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataGenerator {
    public List<AgeRange> getAllAgeRanges() {
        return List.of(
                new AgeRange(1, 0, 10),
                new AgeRange(2, 10, 20),
                new AgeRange(3, 20, 30),
                new AgeRange(4, 30, 40),
                new AgeRange(5, 40, 50),
                new AgeRange(6, 50, 60),
                new AgeRange(7, 60, 70),
                new AgeRange(8, 70, 100)
        );
    }

    public List<Hobby> getAllHobbies() {
        return List.of(
                new Hobby(1, "Pintura"),
                new Hobby(2, "Aeromodelismo"),
                new Hobby(3, "Música"),
                new Hobby(4, "Cine"),
                new Hobby(5, "Deporte"),
                new Hobby(6, "Series"),
                new Hobby(7, "Yoga"));
    }
}
