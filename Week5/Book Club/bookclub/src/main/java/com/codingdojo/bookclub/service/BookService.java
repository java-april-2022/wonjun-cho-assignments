package com.codingdojo.bookclub.service;

import com.codingdojo.bookclub.model.Book;
import com.codingdojo.bookclub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent()) return book.get();
        return null;
    }

    public Book addOrUpdateBook(Book book) {
        return bookRepository.save(book);
    }
}
