package com.example.LibrarySpring.controller;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.repository.ReaderRepository;
import com.example.LibrarySpring.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReaderController {

    @Autowired
    ReaderService readerService;

    @Autowired
    ReaderRepository readerRepository;

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

    @GetMapping("/updateReader/{id}")
    public String updateReader(@PathVariable("id") Long id, Model model) {
        Reader reader = readerService.findReaderById(id);
        model.addAttribute("reader", reader);
        return "user_edit";
    }

    @PostMapping("/updateReader/{id}")
    public String updateReader(@ModelAttribute("reader") Reader editedReader, @PathVariable("id") Long id, Model model) {
        readerRepository.save(editedReader);
        model.addAttribute("reader", editedReader);
        return "list_of_readers";
    }

    @GetMapping("/deleteReader/{id}")
    public String deleteReader(@PathVariable("id")Long id, Model model) {
        Reader reader = readerService.findReaderById(id);
        readerRepository.delete(reader);
        model.addAttribute("reader", reader);
        return "list_of_readers";
    }
}
