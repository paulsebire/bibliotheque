package com.books.web.controller;

import com.books.dao.BookRepository;
import com.books.entities.Book;
import com.books.web.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/livres")
    public List<Book> bookList(){
        List<Book> books = bookRepository.findAll();
        if (books.isEmpty()) throw new BookNotFoundException("Aucun livre n'est disponible");
        return books;
    }

    @GetMapping( value = "/livre/{id}")
    public Optional<Book> recupererUnLivre(@PathVariable long id) {

        Optional<Book> book = bookRepository.findById(id);

        if(!book.isPresent())  throw new BookNotFoundException("Le livre correspondant à l'id " + id + " n'existe pas");

        return book;
    }

}
