package com.books.web.controller;

import com.books.dao.CopiesRepository;
import com.books.entities.Book;
import com.books.entities.Copy;
import com.books.web.exceptions.CopyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CopyController {

    @Autowired
    private CopiesRepository copiesRepository;

    @GetMapping(value = "/livre/{id}/copies")
    public List CopiesDispo(@PathVariable(value = "id")Long id){
        List<Copy> copies = copiesRepository.ListCopyDispoByBook(id);
        return copies;
    }
}
