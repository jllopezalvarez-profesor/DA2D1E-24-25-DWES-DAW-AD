package es.jllopezalvarez.accesodatos.ejemplos.ejemplo06biblioteca.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long bookId;
    @Column(nullable = false, length = 13)
    private String isbn;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(length = 1000)
    private String description;

    @ManyToMany
    @JoinTable(name = "authors_books",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")})
    Set<Author> authors;

    @OneToMany(mappedBy = "book")
    private Set<Loan> loans;
}
