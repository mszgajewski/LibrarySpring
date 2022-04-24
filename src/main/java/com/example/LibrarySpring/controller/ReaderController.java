package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReaderController {

    ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/addReader")
    public String addReader(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);
        return "register_form_user";
    }

    @PostMapping("/register_user")
    public String submitForm(@ModelAttribute("reader")Reader reader) {
        readerService.addReader(reader);
        return "home";
    }
}
