package es.jllopezalvarez.ejemplos.springbootbasics.models.common;

import lombok.Getter;

@Getter
public class AgeRange {
    private final int ageRangeId;
    private final int minAge;
    private final int maxAge;

    public AgeRange(int ageRangeId, int minAge, int maxAge) {
        this.ageRangeId = ageRangeId;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public String asString() {
        return String.format("%d-%d", minAge, maxAge);
    }
}
