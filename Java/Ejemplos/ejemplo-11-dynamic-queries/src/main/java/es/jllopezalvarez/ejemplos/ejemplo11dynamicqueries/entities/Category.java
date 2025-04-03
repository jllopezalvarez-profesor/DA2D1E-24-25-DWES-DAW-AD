package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean active;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();
}