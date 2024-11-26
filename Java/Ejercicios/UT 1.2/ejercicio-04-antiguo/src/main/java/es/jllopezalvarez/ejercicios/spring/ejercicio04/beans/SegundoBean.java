package es.jllopezalvarez.ejercicios.spring.ejercicio04.beans;

import org.springframework.stereotype.Component;

@Component
public class SegundoBean {
    public void hazOtraCosa(){
        System.out.println("Otra cosa");
    }
}
