package es.jllopezalvarez.ejemplos.springbootbasics.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@ToString(callSuper = true)
public class DateAndTimeFormDto extends SimpleFormDto {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;
    // No se puede usar DateTimeFormat.ISO.TIME, porque incluye segundos y milisegundos
    // @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @DateTimeFormat(pattern = "HH:mm" )
    private LocalTime goToBedTime;
    // No se puede usar DateTimeFormat.ISO.DATE_TIME, porque incluye segundos y milisegundos
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime nextTestDatetime;
}
