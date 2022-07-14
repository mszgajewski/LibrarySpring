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
@Table(name = "Readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "readerId")
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "readerId", referencedColumnName = "readerId")
    private Borrow borrow;

}
