package com.example.LibrarySpring.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public int readerId;
    private int bookId;
    private Date borrowDate;
    private Date returnDate;
    private String comment;

    public Borrow(int bookId, Date borrowDate, Date returnDate, String comment, Reader reader) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.comment = comment;

    }
}