package es.jllopezalvarez.ejemplos.springbootbasics.utils;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.MultipleOptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.OptionFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.SimpleFormDto;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.AgeRange;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.Hobby;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class DataGenerator {
    private final Faker faker;
    private final Random random;

    public DataGenerator(Faker faker) {
        this.faker = faker;
        random = new Random();
    }

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

    public Integer getRandomAgeRangeId() {
        return faker.number().numberBetween(0, getAllAgeRanges().size()) + 1;
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

    public Integer getRandomHobbyId() {
        return faker.number().numberBetween(0, getAllHobbies().size()) + 1;
    }

    public List<Integer> getRandomHobbyIds() {
        int limit = getAllHobbies().size() + 1;
        int count = random.nextInt(getAllHobbies().size()) + 1;
        return random.ints(count, 1, limit).boxed().toList();
    }

    public SimpleFormDto createFakeSimpleFormDto() {
        SimpleFormDto simpleFormDto = new SimpleFormDto();
        simpleFormDto.setDni(faker.idNumber().valid());
        simpleFormDto.setFirstName(faker.name().firstName());
        simpleFormDto.setLastName(faker.name().lastName());
        return simpleFormDto;
    }

    public OptionFormDto createFakeOptionFormDto() {
        OptionFormDto optionFormDto = new OptionFormDto();
        optionFormDto.setDni(faker.idNumber().valid());
        optionFormDto.setFirstName(faker.name().firstName());
        optionFormDto.setLastName(faker.name().lastName());
        optionFormDto.setAgeRangeId(getRandomAgeRangeId());
        return optionFormDto;
    }

    public MultipleOptionFormDto createFakeMultipleOptionFormDto() {
        MultipleOptionFormDto multipleOptionFormDto = new MultipleOptionFormDto();
        multipleOptionFormDto.setDni(faker.idNumber().valid());
        multipleOptionFormDto.setFirstName(faker.name().firstName());
        multipleOptionFormDto.setLastName(faker.name().lastName());
        multipleOptionFormDto.setHobbiesIds(getRandomHobbyIds());
        return multipleOptionFormDto;
    }

}
