package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {
    BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
    }

    public void borrowBook(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    public void returnBook(Borrow borrow) {
        borrowRepository.delete(borrow);
    }

    public Borrow findBorrowById(long id) {
        Optional<Borrow> optional = Optional.ofNullable(borrowRepository.findBorrowById(id));
        Borrow borrow = null;
        if(optional.isPresent()) {
            borrow = optional.get();
        } else {
            throw new RuntimeException("Nie znaleziono wypożyczenia o id :: " + id);
        }
        return borrow;
    }

    public List<Borrow> findAllBorrows() {
        return borrowRepository.findAll();
    }
}
