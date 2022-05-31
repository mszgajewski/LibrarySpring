package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.service.ReaderService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReaderController {

    ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/addUser")
    public String addReader(Model model) {
        Reader reader = new Reader();
        model.addAttribute("reader", reader);
        return "register_form_user";
    }

    @PostMapping("/addUser")
    public String submitForm(@ModelAttribute("reader")Reader reader) {
        readerService.addReader(reader);
        return "user_register_success";
    }

    @PostMapping("/getUser")
    public String deleteForm(@ModelAttribute("reader") Reader reader) {
        readerService.addReader(reader);
        return "user_register_success";
    }

    @RequestMapping("/allReaders")
    public String showAllReaders(Model model) {
        List<Reader> readers = readerService.findAll();
        model.addAttribute("reader", readers);
        return "list_of_readers";
    }

    @RequestMapping("/allReadersByName")
    public String showAllReadersByName(Model model, @Param("name") String name) {
        List<Reader> readers = readerService.findReaderByName(name);
        model.addAttribute("reader", readers);
        return "list_of_readers";
    }

    @DeleteMapping("/deleteReader")
    public String deleteReader(@ModelAttribute("reader") Reader reader){
        readerService.deleteReader(reader);
        return "list_of_readers";
    }
}
