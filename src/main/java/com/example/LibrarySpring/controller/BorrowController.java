package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Borrow;
import com.example.LibrarySpring.service.BorrowService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowController {
    BorrowService borrowService;

    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @GetMapping("/borrowBook")
    public String borrowBook(Model model) {
        Borrow borrow = new Borrow();
        model.addAttribute("borrow", borrow);
        return "home";
    }

    @PostMapping("/register_user")
    public String submitForm(@ModelAttribute("borrow") Borrow borrow) {
        borrowService.borrowBook(borrow);
        return "home";
    }
}
