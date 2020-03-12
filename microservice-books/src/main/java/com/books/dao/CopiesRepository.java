package com.books.dao;


import com.books.entities.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiesRepository extends JpaRepository<Copy, Long> {
}
