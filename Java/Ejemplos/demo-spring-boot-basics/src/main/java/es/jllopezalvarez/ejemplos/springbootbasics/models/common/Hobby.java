package es.jllopezalvarez.ejemplos.springbootbasics.models.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hobby {
    private Integer hobbyId;
    private String name;

    public Hobby(Integer hobbyId, String name) {
        this.hobbyId = hobbyId;
        this.name = name;
    }
}
