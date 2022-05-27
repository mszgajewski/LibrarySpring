package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Book;
import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.repository.ReaderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    public void addReader(Reader reader){
        readerRepository.save(reader);
    }

    public void deleteReader(Reader reader) { readerRepository.delete(reader);}

    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    public List<Reader> findReaderByName(String name) {
        return readerRepository.getReaderByName(name);
    }
}
