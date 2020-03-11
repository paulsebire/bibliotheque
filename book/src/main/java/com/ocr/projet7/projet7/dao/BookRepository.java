package com.ocr.projet7.projet7.dao;

import com.ocr.projet7.projet7.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Long> {
}
