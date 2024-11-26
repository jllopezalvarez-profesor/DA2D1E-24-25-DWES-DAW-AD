package es.jllopezalvarez.ejercicios.spring.ejercicio04;

import es.jllopezalvarez.ejercicios.spring.ejercicio04.beans.PrimerBean;
import es.jllopezalvarez.ejercicios.spring.ejercicio04.beans.SegundoBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
@Order(1)
public class EjemploInyecciones implements CommandLineRunner {
    // De forma tradicional:
    // private PrimerBean primerBean = new PrimerBean();
    // private SegundoBean segundoBean = new SegundoBean();
    // private Comparator<String> comparador = new Configuracion().getComparadorPorLongitud();

    private final PrimerBean primerBean;
    private final SegundoBean segundoBean;
    private final Comparator<String> comparador;

    public EjemploInyecciones(PrimerBean primerBean, SegundoBean segundoBean, Comparator<String> comparador) {
        this.primerBean = primerBean;
        this.segundoBean = segundoBean;
        this.comparador = comparador;
    }


    public void pruebaDependencias() {
        primerBean.hazAlgo();
        segundoBean.hazOtraCosa();
    }

    @Override
    public void run(String... args) throws Exception {
        this.pruebaDependencias();
    }
}
