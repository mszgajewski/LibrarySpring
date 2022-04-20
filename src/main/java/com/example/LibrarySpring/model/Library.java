package com.example.LibrarySpring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "Borrows")
@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "reader_id")
    public int readerId;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "book_id")
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private String comment;

    public Library(Long id, int readerId, int bookId, Date borrowDate, Date returnDate, String comment, Reader reader) {
        this.id = id;
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.comment = comment;

    }





}
