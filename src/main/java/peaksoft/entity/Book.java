package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq")
    private Long id;
    private String title;

    private String description;

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private LocalDate dateOfIssue;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "author_id")
    private Author author;

}