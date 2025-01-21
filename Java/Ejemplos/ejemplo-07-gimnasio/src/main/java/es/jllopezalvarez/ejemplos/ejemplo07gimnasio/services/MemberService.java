package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface MemberService {
    Optional<Double> getAvgAgeForOlderThan(int age);
}
