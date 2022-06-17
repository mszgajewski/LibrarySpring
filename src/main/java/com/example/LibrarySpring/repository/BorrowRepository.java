package com.example.LibrarySpring.repository;

import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRepository extends JpaRepository<Borrow,Long> {

    List<Borrow> findAll();

    Borrow findBorrowById(long id);
}
