package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(length = 1000)
    private String description;

    @ManyToMany(mappedBy = "authors")
    Set<Book> books;

    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Book> getBooks() {
        return books;
    }
}
