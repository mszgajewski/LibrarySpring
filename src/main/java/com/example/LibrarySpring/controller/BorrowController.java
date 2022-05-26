package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.service.BorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BorrowController {
    BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/borrowedBooks")
    public String borrowBook(Model model) {
        Borrow borrow = new Borrow();
        model.addAttribute("borrow", borrow);
        return "home";
    }

    @PostMapping("/borrowBook")
    public String submitForm(@ModelAttribute("borrow") Borrow borrow) {
        borrowService.borrowBook(borrow);
        return "home";
    }

    @RequestMapping("/allBorrows")
    public String showAllBorrows(Model model) {
       List<Borrow> borrows = borrowService.findAllBorrows();
       model.addAttribute("borrow", borrows);
        return "list_of_borrows";
    }
}
