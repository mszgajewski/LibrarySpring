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
    public int readerId;
    private int bookId;
    private String borrowDate;
    private String returnDate;
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    private Book Book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "readerId")
    private Reader reader;


    public Borrow(int bookId, String borrowDate, String returnDate, String comment, Reader reader) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.comment = comment;

    }
}