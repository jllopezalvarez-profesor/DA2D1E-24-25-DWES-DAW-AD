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
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime goToBedTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime nextTestDatetime;
}
