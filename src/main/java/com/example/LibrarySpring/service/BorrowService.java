package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.repository.BorrowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService {
    BorrowRepository borrowRepository;

    public BorrowService(BorrowRepository borrowRepository){
        this.borrowRepository = borrowRepository;
    }

    public void borrowBook(Borrow borrow) {
        borrowRepository.save(borrow);
    }

    public List<Borrow> findBorrowById(int id) {
        return borrowRepository.findById(id);
    }

    public List<Borrow> findAllBorrows() {
        return borrowRepository.findAll();
    }
}
