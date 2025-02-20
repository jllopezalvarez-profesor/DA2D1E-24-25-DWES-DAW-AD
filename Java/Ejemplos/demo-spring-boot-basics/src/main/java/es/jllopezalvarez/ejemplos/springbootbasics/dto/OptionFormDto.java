package es.jllopezalvarez.ejemplos.springbootbasics.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class OptionFormDto extends SimpleFormDto {
    private Integer ageRangeId;
}
