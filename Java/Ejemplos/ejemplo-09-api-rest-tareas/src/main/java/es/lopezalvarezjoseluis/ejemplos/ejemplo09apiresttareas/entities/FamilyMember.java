package es.lopezalvarezjoseluis.ejemplos.ejemplo09apiresttareas.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer familyMemberId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private int age;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(familyMemberId, that.familyMemberId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(familyMemberId);
    }
}
