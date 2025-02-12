package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.utils;

import java.util.Comparator;

public class CustomLongComparator implements Comparator<Long> {
    @Override
    public int compare(Long o1, Long o2) {
        return Integer.compare(  String.valueOf(o1).length(), String.valueOf(o2).length());
    }
}
