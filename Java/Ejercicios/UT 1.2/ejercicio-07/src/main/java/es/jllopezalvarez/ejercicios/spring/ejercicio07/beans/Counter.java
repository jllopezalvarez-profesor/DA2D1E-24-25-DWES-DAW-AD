package es.jllopezalvarez.ejercicios.spring.ejercicio07.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Por defecto el scope es singleton
// @Scope("prototype") // Con esto hacemos que cada vez que se inyecta el bean, se cree una nueva instancia
public class Counter {
    private int counter;
    public Counter() {this.counter=0;}
    public void increment() {  counter++; }

    public int getCounter() {
        return counter;
    }
}
