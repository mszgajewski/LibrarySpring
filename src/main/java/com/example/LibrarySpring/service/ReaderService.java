package com.example.LibrarySpring.service;

import com.example.LibrarySpring.model.Reader;
import com.example.LibrarySpring.repository.ReaderRepository;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {

    ReaderRepository readerRepository;

    public ReaderService(ReaderRepository readerRepository){
        this.readerRepository = readerRepository;
    }

    public void addReader(Reader reader){
        readerRepository.save(reader);
    }
}
