package com.example.LibrarySpring.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bookId")
    private Long id;
    private String title;
    private String author;
    private int isbn;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Borrow borrow;


}
