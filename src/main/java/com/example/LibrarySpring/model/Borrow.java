package com.example.LibrarySpring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Data
@Table(name = "Borrows")
@NoArgsConstructor
@AllArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String borrowDate;
    private String returnDate;
    private String comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book Book;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "readerId")
    private Reader reader;
}