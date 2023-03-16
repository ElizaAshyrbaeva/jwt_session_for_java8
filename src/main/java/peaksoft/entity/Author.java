package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Country;
import peaksoft.enums.Gender;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name = "author_seq")
    private Long id;

    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Country country;

    private String phoneNumber;

    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private AuthInfo authInfo;


    @OneToMany(mappedBy = "author",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE}, orphanRemoval = true)
    private Set<Book> books;

    public void addBook(Book book) {
        if (books == null) {
            books = new LinkedHashSet<>();
        }
        books.add(book);
    }
}