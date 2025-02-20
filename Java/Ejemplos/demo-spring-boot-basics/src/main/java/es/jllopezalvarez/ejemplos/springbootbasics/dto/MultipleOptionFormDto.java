package es.jllopezalvarez.ejemplos.springbootbasics.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class MultipleOptionFormDto extends SimpleFormDto {
    private List<Integer> hobbiesIds;
}
