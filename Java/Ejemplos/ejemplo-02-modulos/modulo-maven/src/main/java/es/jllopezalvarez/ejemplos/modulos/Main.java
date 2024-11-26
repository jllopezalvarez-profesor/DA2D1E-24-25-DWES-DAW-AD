package es.jllopezalvarez.ejemplos.modulos;

import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        System.out.println(faker.breakingBad().character());
        System.out.println(faker.breakingBad().character());

        Faker faker2 = new Faker(new Random(10));

        System.out.println(faker2.breakingBad().character());
        System.out.println(faker2.breakingBad().character());

        System.out.println(faker.name().fullName());
        System.out.println(faker.name().fullName());

        Faker faker3 = new Faker(new Locale("es"));
        System.out.println(faker3.name().fullName());
        System.out.println(faker3.name().fullName());

        Faker faker4 = new Faker( new  Locale("es", "ES"), new Random(10));


    }
}