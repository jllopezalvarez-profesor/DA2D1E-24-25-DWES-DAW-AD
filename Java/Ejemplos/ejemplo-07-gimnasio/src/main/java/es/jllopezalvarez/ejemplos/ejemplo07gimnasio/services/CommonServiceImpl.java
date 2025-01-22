package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public String getTextoComun() {
        return String.format("Son las %s del %s", LocalDate.now(), LocalTime.now());
    }
}
