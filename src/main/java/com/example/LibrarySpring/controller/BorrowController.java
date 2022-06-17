package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.repository.BorrowRepository;
import com.example.LibrarySpring.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BorrowController {
    @Autowired
    BorrowService borrowService;

    @Autowired
    BorrowRepository borrowRepository;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/borrowBook")
    public String showBorrows(Model model){
        Borrow borrow = new Borrow();
        model.addAttribute("borrow", borrow);
        return "register_form_borrow";
    }

    @PostMapping("/getBorrow")
    public String deleteForm(@ModelAttribute("borrow") Borrow borrow) {
        borrowService.borrowBook(borrow);
        return "borrow_register_success";
    }

    @PostMapping("/borrowBook")
    public String submitForm(@ModelAttribute("borrow") Borrow borrow) {
        borrowService.borrowBook(borrow);
        return "borrow_register_success";
    }

    @RequestMapping("/allBorrows")
    public String showAllBorrows(Model model) {
       List<Borrow> borrow = borrowService.findAllBorrows();
       model.addAttribute("borrow", borrow);
        return "list_of_borrows";
    }

    @RequestMapping("/allBorrowsById")
    public String showAllBorrowsById(Model model, @Param("id") Long id) {
        Borrow borrow = borrowService.findBorrowById(id);
        model.addAttribute("borrow", borrow);
        return "list_of_borrows";
    }

    @GetMapping("/returnBook/{id}")
    public String returnBook(@PathVariable("id")Long id, Model model) {
        Borrow borrow = borrowService.findBorrowById(id);
        borrowRepository.delete(borrow);
        model.addAttribute("borrow", borrow);
        return "list_of_borrows";
    }
}
